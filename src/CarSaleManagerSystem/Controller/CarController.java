package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.CarService;
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
 * Created by HFQ on 2016/8/7.
 */
@Controller
@RequestMapping(value = "/Car")
public class CarController {
    @Autowired
    private CarService carService;

    private LoginFilter loginFilter = new LoginFilter();

    @RequestMapping(value = "/createStock",method = RequestMethod.GET)
    public ModelAndView createStockPage(){
        ModelAndView modelAndView = new ModelAndView("Car/carStockRegister");
        List<?> garageList = carService.getAllGarages();
        List<?> carBrandList = carService.getAllCarBrands();
        List<?> colorList = carService.getAllColors();
        List<?> statusList = carService.getAllStockStatus();
        List<?> sfxList = carService.getAllCarSFX();
        modelAndView.addObject("garages",garageList);
        modelAndView.addObject("carBrands",carBrandList);
        modelAndView.addObject("colors",colorList);
        modelAndView.addObject("statusList",statusList);
        modelAndView.addObject("sfxList",sfxList);
        modelAndView.addObject("car",new Car());
        return modelAndView;
    }

    @RequestMapping(value = "/createStock",method = RequestMethod.POST)
    public ModelAndView createStock(@ModelAttribute Car car){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/list");
        carService.createCar(car);
        return modelAndView;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView listCar(HttpSession session) {
//        ModelAndView modelAndView = loginFilter.adminLogin(session);
//        if (modelAndView != null)
//            return modelAndView;
        ModelAndView modelAndView = new ModelAndView("Car/carList");
//        List<?> carList = carService.getAllCars();
        Map<Car, Integer> carList = carService.getCarAgeList();
        modelAndView.addObject("cars",carList);
        return modelAndView;
    }

    @RequestMapping(value = "/setCost/{carID}",method = RequestMethod.GET)
    public ModelAndView setCarCostPage(@PathVariable String carID,@ModelAttribute Car car){
        ModelAndView modelAndView = new ModelAndView("Car/carSetPrice");
        car = carService.findCarById(carID);
        if(car != null){
            modelAndView.addObject("car",car);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/setCost/{carID}",method = RequestMethod.POST)
    public ModelAndView setCarCost(@PathVariable String carID,@ModelAttribute Car car){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/list");
        Car stockCar = carService.findCarById(carID);
        if(stockCar != null){
            stockCar.setCost(car.getCost());
            stockCar.setPrice(car.getPrice());
            stockCar.setDiscount(car.getDiscount());
            stockCar.setPayback(car.getPayback());
            carService.updateCar(stockCar);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/setStockStatus/{carID}",method = RequestMethod.GET)
    public ModelAndView setStockStatusPage(@PathVariable String carID){
        ModelAndView modelAndView = new ModelAndView("Car/setStockStatus");
        Car car = carService.findCarById(carID);
        if(car != null){
            modelAndView.addObject("car",car);
            List<?> statusList = carService.getAllStockStatus();
            modelAndView.addObject("statusList",statusList);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/setStockStatus/{carID}",method = RequestMethod.POST)
    public ModelAndView setCarStockStatus(@PathVariable String carID,@ModelAttribute Car car){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/list");
        Car stockCar = carService.findCarById(carID);
        if(stockCar != null){
            stockCar.setStockStatus(car.getStockStatus());
            carService.updateCar(stockCar);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/createGarage",method = RequestMethod.GET)
    public ModelAndView createGaragePage(){
        ModelAndView modelAndView = new ModelAndView("Car/createGarage");
        modelAndView.addObject("garage",new Garage());
        return modelAndView;
    }

    @RequestMapping(value = "/createGarage",method = RequestMethod.POST)
    public ModelAndView createGarage(@ModelAttribute Garage garage){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createGarage(garage);
        return modelAndView;
    }

    @RequestMapping(value = "/createCarBrand",method = RequestMethod.GET)
    public ModelAndView createCarBrandPage(){
        ModelAndView modelAndView = new ModelAndView("Car/createCarBrand");
        List<Garage> garageList = carService.getAllGarages();
        modelAndView.addObject("carBrand",new CarBrand());
        modelAndView.addObject("garages",garageList);
        return modelAndView;
    }

    @RequestMapping(value = "/createCarBrand",method = RequestMethod.POST)
    public ModelAndView createCarBrand(@ModelAttribute CarBrand carBrand){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createCarBrand(carBrand);
        return modelAndView;
    }

    @RequestMapping(value = "/createColor",method = RequestMethod.GET)
    public ModelAndView createColorPage(){
        ModelAndView modelAndView = new ModelAndView("Car/createColor");
        modelAndView.addObject("color",new CarColor());
        return modelAndView;
    }

    @RequestMapping(value = "/createColor",method = RequestMethod.POST)
    public ModelAndView createColor(@ModelAttribute CarColor carColor){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createColor(carColor);
        return modelAndView;
    }

    @RequestMapping(value = "/createStockStatus",method = RequestMethod.GET)
    public ModelAndView createStockStatusPage(){
        ModelAndView modelAndView = new ModelAndView("Car/createStockStatus");
        modelAndView.addObject("stockStatus",new StockStatus());
        return modelAndView;
    }

    @RequestMapping(value = "/createStockStatus",method = RequestMethod.POST)
    public ModelAndView createStockStatus(@ModelAttribute StockStatus stockStatus){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createStockStatus(stockStatus);
        return modelAndView;
    }

    @RequestMapping(value = "/createSFX",method = RequestMethod.GET)
    public ModelAndView createSFXPage(){
        ModelAndView modelAndView = new ModelAndView("Car/createSFX");
        modelAndView.addObject("SFX",new CarSFX());
        return modelAndView;
    }

    @RequestMapping(value = "/createSFX",method = RequestMethod.POST)
    public ModelAndView createSFX(@ModelAttribute CarSFX carSFX){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createCarSFX(carSFX);
        return modelAndView;
    }

    @RequestMapping(value = "/createCarByCarType",method = RequestMethod.POST)
    public ModelAndView createCarByCarType(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("Car/carTypeCreateStock");
        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String sfx = request.getParameter("sfx");
        List<?> statusList = carService.getAllStockStatus();
        modelAndView.addObject("garage",garage);
        modelAndView.addObject("brand",brand);
        modelAndView.addObject("color",color);
        modelAndView.addObject("sfx",sfx);
        modelAndView.addObject("statusList",statusList);
        return modelAndView;
    }

    @RequestMapping(value = "/carListByCarType",method = RequestMethod.POST)
    public ModelAndView carListByCarType(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("Car/carList");
        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String sfx = request.getParameter("sfx");
        CarTypeID carTypeID = new CarTypeID(garage,brand,sfx,color);
        Map<Car,Integer> carList = carService.getCarAgeListByCarType(carTypeID);
        modelAndView.addObject("cars",carList);
        return modelAndView;
    }

    /*
    *CarType controller
     */

    @RequestMapping(value = "/createCarType",method = RequestMethod.GET)
    public ModelAndView createCarTypePage(){
        ModelAndView modelAndView = new ModelAndView("Car/createCarType");
        List<?> garageList = carService.getAllGarages();
        List<?> carBrandList = carService.getAllCarBrands();
        List<?> colorList = carService.getAllColors();
        List<?> sfxList = carService.getAllCarSFX();
        modelAndView.addObject("garages",garageList);
        modelAndView.addObject("carBrands",carBrandList);
        modelAndView.addObject("colors",colorList);
        modelAndView.addObject("sfxes",sfxList);
        modelAndView.addObject("car",new Car());
        return modelAndView;
    }

    @RequestMapping(value = "/createCarType",method = RequestMethod.POST)
    public ModelAndView createCarType(@ModelAttribute CarType carType){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carTypeList");
        carService.createCarType(carType);
        return modelAndView;
    }
    @RequestMapping(value = "/carTypeList",method = RequestMethod.GET)
    public ModelAndView listCarType(HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("Car/carTypeList");
        List<?> carTypeList = carService.getAllCarType();
        modelAndView.addObject("carTypes",carTypeList);
        return modelAndView;
    }
    @RequestMapping(value = "/deleteCarType",method = RequestMethod.POST)
    public ModelAndView removeCarType(HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carTypeList");
        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String sfx = request.getParameter("sfx");
        CarTypeID carTypeID = new CarTypeID(garage,brand,sfx,color);
        CarType carType = carService.getCarTypeByID(carTypeID);
//        carTypeList = carService.BrandFilter(carTypeList, request.getParameter("brand"));
//        carTypeList = carService.ColorFilter(carTypeList,request.getParameter("color"));
//        carTypeList = carService.SFXFilter(carTypeList,request.getParameter("sfx"));
        if(carType != null) {
            carService.removeCarType(carType);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/updateCarTypePlanPage",method = RequestMethod.POST)
    public ModelAndView updateCarTypePlanPage(HttpServletRequest request,@ModelAttribute CarType carType){
        ModelAndView modelAndView = new ModelAndView("/Car/carTypePlan");
        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String sfx = request.getParameter("sfx");
        CarTypeID carTypeID = new CarTypeID(garage,brand,sfx,color);
        carType = carService.getCarTypeByID(carTypeID);
        modelAndView.addObject("carType",carType);
        return modelAndView;
    }

    @RequestMapping(value = "/updateCarTypePlan",method = RequestMethod.POST)
    public ModelAndView updateCarPlanType(@ModelAttribute CarType carType){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carTypeList");
        CarTypeID carTypeID = new CarTypeID(carType.getGarage(),carType.getBrand(),carType.getCarSfx(),carType.getCarColor());
        CarType stock = carService.getCarTypeByID(carTypeID);
        if(stock != null){
            stock.setPlan(carType.getPlan());
            carService.updateCarType(stock);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/selectCarBrand")
    public @ResponseBody
    Map<String,Object> selectCarBrand(HttpServletRequest request) throws IOException {
        System.out.println(request.getParameter("garage"));
        Map<String,Object> map = new HashMap<String,Object>();

        String garage = request.getParameter("garage");
        List<CarBrand> brands = carService.getCarBrandsByGarage(garage);
        for (int i =0; i < brands.size(); i ++) {
            map.put(String.valueOf(i),brands.get(i).getBrand());
        }
        return map;
    }

    @RequestMapping(value = "/carTypeExists")
    public @ResponseBody
    Map<String, Object> carTypeExists(HttpServletRequest request) throws IOException{
        Map<String,Object> map = new HashMap<String,Object>();

        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");
        String sfx = request.getParameter("sfx");
        String color = request.getParameter("color");

        // System.out.println(garage + brand + "11111");
        CarTypeID carTypeID = new CarTypeID(garage,brand,sfx,color);
        // System.out.println(garage + brand + "22222");
        if(!carService.carTypeExist(carTypeID)){
            System.out.println("hahaha");
            map.put("message","false");
        }else {
            System.out.println("yaoyaoqiekenao");
            map.put("message","true");
        }
        return map;
    }

    @RequestMapping(value = "/brandExists")
    public @ResponseBody
    Map<String, Object> brandExists(HttpServletRequest request) throws IOException{
        Map<String,Object> map = new HashMap<String,Object>();

        String brand = request.getParameter("brand");
        String garage = request.getParameter("garage");
        // System.out.println(garage + brand + "11111");

        if(!carService.brandExist(garage,brand)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }

    @RequestMapping(value = "/colorExists")
    public @ResponseBody
    Map<String, Object> colorExists(HttpServletRequest request) throws IOException{
        Map<String,Object> map = new HashMap<String,Object>();

        String color = request.getParameter("color");

        if(!carService.colorExist(color)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }


    @RequestMapping(value = "/garageExists")
    public @ResponseBody
    Map<String, Object> garageExists(HttpServletRequest request) throws IOException{
        Map<String,Object> map = new HashMap<String,Object>();

        String garage = request.getParameter("brand");

        if(!carService.garageExist(garage)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }

    @RequestMapping(value = "/sfxExists")
    public @ResponseBody
    Map<String, Object> sfxExists(HttpServletRequest request) throws IOException{
        Map<String,Object> map = new HashMap<String,Object>();

        String sfx = request.getParameter("sfx");

        if(!carService.sfxExist(sfx)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }

    @RequestMapping(value = "/stockStatusExists")
    public @ResponseBody
    Map<String, Object> stockStatusExists(HttpServletRequest request) throws IOException{
        Map<String,Object> map = new HashMap<String,Object>();

        String status = request.getParameter("status");

        if(!carService.stockStatusExist(status)){

            map.put("message","false");
        }else {

            map.put("message","true");
        }
        return map;
    }



}
