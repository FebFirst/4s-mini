package CarSaleManagerSystem.Controller;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by HFQ on 2016/8/5.
 */
public class LoginFilter {
    public ModelAndView userLogin(HttpSession session)
    {
        ModelAndView modelAndView = null;
        if(session.getAttribute("userID") == null)
        {
            modelAndView = new ModelAndView("redirect:/User/login");
            modelAndView.addObject("message","Please login first");
            return modelAndView;
        }
        return modelAndView;
    }

    public ModelAndView adminLogin(HttpSession session)
    {
        ModelAndView modelAndView = null;
        if(session.getAttribute("userID") == null)
        {
            modelAndView = new ModelAndView("redirect:/User/login");
            modelAndView.addObject("message","Please login first");
            return modelAndView;
        }
        if(session.getAttribute("admin") == null )
        {
            modelAndView = new ModelAndView("Site/Forbidden");
            return modelAndView;
        }
        return modelAndView;
    }
}
