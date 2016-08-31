package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by googo on 16/8/30.
 */

@Controller
@RequestMapping(value = "/Plan")
public class PlanController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/createSalesPlan",method = RequestMethod.GET)
    public ModelAndView createSalesPlanPage(){
        ModelAndView modelAndView = new ModelAndView("/Plan/createSalesPlan");
        List<Garage> garages = carService.getAllGarages();
        List<CarColor> carColors = carService.getAllColors();
        modelAndView.addObject("garages",garages);
        modelAndView.addObject("colors", carColors);
        modelAndView.addObject("salesPlan", new SalesPlan());
        return modelAndView;
    }

    @RequestMapping(value = "/createSalesPlan", method = RequestMethod.POST)
    public ModelAndView createSalesPlan(@ModelAttribute SalesPlan salesPlan){
        ModelAndView modelAndView = new ModelAndView("redirect:/Plan/createSalesPlan");
        carService.createSalesPlan(salesPlan);
        return modelAndView;
    }

    @RequestMapping(value = "/searchBox", method = RequestMethod.GET)
    public ModelAndView searchBox(){
        ModelAndView modelAndView = new ModelAndView("Plan/planSearchBox");
        return modelAndView;
    }

    @RequestMapping(value = "/carPlan/{year}", method = RequestMethod.GET)
    public ModelAndView salesPlan(@PathVariable int year){
        ModelAndView modelAndView = new ModelAndView("/Plan/carPlanYear");

        HashMap<String, HashMap<String, Integer[]>> carPlan = carService.carPlanNumberByYear(year);
        modelAndView.addObject("carPlans", carPlan);
        return modelAndView;
    }

    @RequestMapping(value = "/valueChain/{year}", method = RequestMethod.GET)
    public ModelAndView valueChain(@PathVariable int year){
        ModelAndView modelAndView = new ModelAndView("/Plan/valueChainYear");

        HashMap<String, HashMap<String, ValueChain>> valueChain = carService.valueChainPlanByYear(year);
        modelAndView.addObject("valueChains", valueChain);
        return modelAndView;
    }

    @RequestMapping(value = "/singleCar/{year}/{month}", method = RequestMethod.GET)
    public ModelAndView singleCarPlan(@PathVariable int year, @PathVariable int month){
        ModelAndView modelAndView = new ModelAndView("/Plan/singleCarProfit");

        HashMap<String, HashMap<String,CarProfit>> singleCar = carService.singleCarTypeProfitByMonth(year, month);
        modelAndView.addObject("salesPlans",singleCar);
        return modelAndView;
    }


    @RequestMapping(value = "/carTypeProfitYear/{year}", method = RequestMethod.GET)
    public ModelAndView carTypeProfitYear(@PathVariable int year){
        ModelAndView modelAndView = new ModelAndView("/Plan/carTypeProfitYear");

        HashMap<String, HashMap<String, CarProfit>> carTypeProfit = carService.carProfitPlanByYear(year);

        modelAndView.addObject("carTypeProfit", carTypeProfit);
        return modelAndView;
    }

    @RequestMapping(value = "/carTypeProfitMonth/{year}/{month}", method = RequestMethod.GET)

    public ModelAndView carTypeProfitMonth(@PathVariable int year, @PathVariable int month){
        ModelAndView modelAndView = new ModelAndView("/Plan/carTypeProfitMonth");

        HashMap<String, HashMap<String, CarProfit>> carTypeProfit = carService.carProfitPlanByMonth(year,month);
        modelAndView.addObject("carTypeProfit", carTypeProfit);
        return modelAndView;

    }
}
