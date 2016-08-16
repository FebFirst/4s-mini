package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.User;
import CarSaleManagerSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by HFQ on 2016/8/5.
 */

@Controller
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserService userService;

    private LoginFilter loginFilter = new LoginFilter();

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView createUserPage(){
        ModelAndView modelAndView = new ModelAndView("User/userCreate");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute User user,HttpSession session,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("redirect:/User/list");
        userService.createUser(user);
        session.setAttribute("userID",user.getUserID());
        session.setAttribute("username",user.getUsername());
        return modelAndView;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView listUser(HttpSession session) {
//        ModelAndView modelAndView = loginFilter.adminLogin(session);
//        if (modelAndView != null)
//            return modelAndView;
        ModelAndView modelAndView = new ModelAndView("User/userList");
        List<?> userList = userService.getAllUsers();
        modelAndView.addObject("users",userList);
        return modelAndView;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView editUserPage(HttpSession session){
        ModelAndView modelAndView = loginFilter.userLogin(session);
        if (modelAndView != null)
            return modelAndView;
        int userID = (int)session.getAttribute("userID");
        modelAndView = new ModelAndView("User/userUpdate");
        User user = userService.findUserById(userID);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{userID}",method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute User user,@PathVariable Integer userID,HttpSession session){
        ModelAndView modelAndView = loginFilter.userLogin(session);
        if (modelAndView != null)
            return modelAndView;
        modelAndView = new ModelAndView("redirect:/User/list");
        userService.updateUser(user);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{userID}",method = RequestMethod.GET)
    public ModelAndView removeUser(@PathVariable Integer userID,HttpSession session){
//        ModelAndView modelAndView = loginFilter.adminLogin(session);
//        if (modelAndView != null)
//            return modelAndView;
        ModelAndView modelAndView = new ModelAndView("redirect:/User/list");
        User user = userService.findUserById(userID);
        userService.removeUser(user);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView("/Logon/login");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, HttpSession session){
        ModelAndView modelAndView;
        int userID = userService.login(user);
        if(userID < 0) {
            modelAndView = new ModelAndView("redirect:/User/login");
            modelAndView.addObject("message","用户名或密码错误");
            return modelAndView;
        }else{
            modelAndView = new ModelAndView("redirect:/User/profile");
            session.setAttribute("userID",userID);
            session.setAttribute("username", user.getUsername());
            return modelAndView;
        }
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ModelAndView getProfile(HttpSession session){
        ModelAndView modelAndView = loginFilter.userLogin(session);
        if (modelAndView != null)
            return modelAndView;
        int userID = (int)session.getAttribute("userID");
        modelAndView = new ModelAndView("User/userCenter");
        User user = userService.findUserById(userID);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("redirect:/Site/home");
        if(session.getAttribute("userID") != null){
            session.removeAttribute("userID");
        }
        if(session.getAttribute("username") != null)
        {
            session.removeAttribute("username");
        }
        if(session.getAttribute("admin") != null)
        {
            session.removeAttribute("admin");
        }
        return modelAndView;
    }
}
