package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.CustomerService;
import CarSaleManagerSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HFQ on 2016/8/5.
 */

@Controller
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    private LoginFilter loginFilter = new LoginFilter();

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView createUserPage(){
        ModelAndView modelAndView = new ModelAndView("User/userCreate");
        List<Job> jobs = userService.getAllJobs();
        List<Apartment> apartments = userService.getAllApartment();
        List<Level> levels = userService.getAllLevels();
        List<JobStatus> jobStatuses = userService.getAllJobStatus();
        modelAndView.addObject("jobs",jobs);
        modelAndView.addObject("apartments",apartments);
        modelAndView.addObject("levels", levels);
        modelAndView.addObject("jobStatuses", jobStatuses);
        modelAndView.addObject("user",new User());

        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute User user,HttpSession session,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("redirect:/User/list");
        System.out.println(user.getApartment() + "HHH");
        user.setType(user.getJob());
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
        ModelAndView modelAndView = new ModelAndView("redirect:/Site/index");
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

    @RequestMapping(value = "/createApartment",method = RequestMethod.GET)
    public ModelAndView createApartmentPage(){
        ModelAndView modelAndView = new ModelAndView("User/createApartment");
        modelAndView.addObject("apartment",new Apartment());
        return modelAndView;
    }

    @RequestMapping(value = "/createApartment",method = RequestMethod.POST)
    public ModelAndView createApartment(@ModelAttribute Apartment apartment){
        ModelAndView modelAndView = new ModelAndView("redirect:/User/listApartment");
        userService.createApartment(apartment);
        return modelAndView;
    }

    @RequestMapping(value = "/listApartment",method = RequestMethod.GET)
    public ModelAndView listApartment(){
        ModelAndView modelAndView = new ModelAndView("User/apartmentList");
        modelAndView.addObject("apartments",userService.getAllApartment());
        return modelAndView;
    }

    @RequestMapping(value = "/apartmentExists")
    public @ResponseBody
    Map<String, Object> apartmentExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String apartment = request.getParameter("apartment");

        if(!userService.apartmentExist(apartment)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }

    @RequestMapping(value = "/createJob",method = RequestMethod.GET)
    public ModelAndView createJobPage(){
        ModelAndView modelAndView = new ModelAndView("User/createJob");
        modelAndView.addObject("job",new Job());
        return modelAndView;
    }

    @RequestMapping(value = "/createJob",method = RequestMethod.POST)
    public ModelAndView createJob(@ModelAttribute Job job){
        ModelAndView modelAndView = new ModelAndView("redirect:/User/listJob");
        userService.createJob(job);
        return modelAndView;
    }

    @RequestMapping(value = "/listJob",method = RequestMethod.GET)
    public ModelAndView listJob(){
        ModelAndView modelAndView = new ModelAndView("User/jobList");
        modelAndView.addObject("jobs",userService.getAllJobs());
        return modelAndView;
    }

    @RequestMapping(value = "/jobExists")
    public @ResponseBody
    Map<String, Object> jobExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String job = request.getParameter("job");

        if(!userService.jobExist(job)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }

    @RequestMapping(value = "/createJobStatus",method = RequestMethod.GET)
    public ModelAndView createJobStatusPage(){
        ModelAndView modelAndView = new ModelAndView("User/createJobStatus");
        modelAndView.addObject("jobStatus",new JobStatus());
        return modelAndView;
    }

    @RequestMapping(value = "/createJobStatus",method = RequestMethod.POST)
    public ModelAndView createJobStatus(@ModelAttribute JobStatus jobStatus){
        ModelAndView modelAndView = new ModelAndView("redirect:/User/listJobStatus");
        userService.createJobStatus(jobStatus);
        return modelAndView;
    }

    @RequestMapping(value = "/listJobStatus",method = RequestMethod.GET)
    public ModelAndView listJobStatus(){
        ModelAndView modelAndView = new ModelAndView("User/jobStatusList");
        modelAndView.addObject("jobStatuss",userService.getAllJobStatus());
        return modelAndView;
    }

    @RequestMapping(value = "/jobStatusExists")
    public @ResponseBody
    Map<String, Object> jobStatusExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String jobStatus = request.getParameter("jobStatus");

        if(!userService.jobStatusExist(jobStatus)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }

    @RequestMapping(value = "/createLevel",method = RequestMethod.GET)
    public ModelAndView createLevelPage(){
        ModelAndView modelAndView = new ModelAndView("User/createLevel");
        modelAndView.addObject("level",new Level());
        return modelAndView;
    }

    @RequestMapping(value = "/createLevel",method = RequestMethod.POST)
    public ModelAndView createLevel(@ModelAttribute Level level){
        ModelAndView modelAndView = new ModelAndView("redirect:/User/listLevel");
        userService.createLevel(level);
        return modelAndView;
    }

    @RequestMapping(value = "/listLevel",method = RequestMethod.GET)
    public ModelAndView listLevel(){
        ModelAndView modelAndView = new ModelAndView("User/levelList");
        modelAndView.addObject("levels",userService.getAllLevels());
        return modelAndView;
    }

    @RequestMapping(value = "/levelExists")
    public @ResponseBody
    Map<String, Object> levelExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String level = request.getParameter("level");

        if(!userService.levelExist(level)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }


    /**
     * Customer controller
     */

    @RequestMapping(value = "/createCustomer",method = RequestMethod.GET)
    public ModelAndView createCustomerPage(){
        ModelAndView modelAndView = new ModelAndView("User/updateCustomer");
        modelAndView.addObject("customer", new Customer());

        return modelAndView;
    }

    @RequestMapping(value = "createCustomer", method = RequestMethod.POST)
    public ModelAndView createCustomer(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect: /User/createCustomer");

        customerService.createCustomer(customer);

        return modelAndView;
    }
}
