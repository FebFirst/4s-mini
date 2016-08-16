package CarSaleManagerSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by HFQ on 2016/8/10.
 */
@Controller
@RequestMapping("/Site")
public class SiteController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("Site/home");
        return modelAndView;
    }

    @RequestMapping(value = "/DataManagement",method = RequestMethod.GET)
    public ModelAndView dataManagementPage(){
        ModelAndView modelAndView = new ModelAndView("Site/DataManagement");
        return modelAndView;
    }
}
