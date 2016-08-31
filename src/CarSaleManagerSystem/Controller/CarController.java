package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by HFQ on 2016/8/7.
 */
@Controller
@RequestMapping(value = "/Car")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GiftService giftService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AdditionalProductService additionalProductService;

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

//        System.out.println(car.toString());
        car.setPlanID(-1);
        car.setValid("Y");
        car.setCost(0);
        car.setNormal("Y");

        car.setPredictedTime(new Date());
        car.setPurchasedTime(new Date());

        carService.createCar(car);
        return modelAndView;
    }

    @RequestMapping(value = "/carStock",method = RequestMethod.POST)
    public ModelAndView updateCarId(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carBookedList");
        String oldId = request.getParameter("oldId");
        String newId = request.getParameter("newId");

        Car oldCar = carService.findCarById(oldId);

        Car newCar = new Car(oldCar);
        newCar.setCarID(newId);
        newCar.setInGarageTime(new Date());
        newCar.setStockStatus("在途");
        carService.removeUpdate(oldCar, newCar);
        return modelAndView;
    }
    @RequestMapping(value = "/createStock/{planID}",method = RequestMethod.POST)
    public ModelAndView createStock(@ModelAttribute Car car,@PathVariable int planID){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carBookedList");

        Date date = new Date();
        car.setCarID("CHEJIAHAO"+ date.toString());
        car.setPlanID(planID);
        car.setValid("Y");
        car.setCost(0);
        car.setNormal("Y");

        car.setPredictedTime(date);
        car.setPurchasedTime(date);

        carService.createCar(car);
        return modelAndView;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView listCar() {

        ModelAndView modelAndView = new ModelAndView("Car/carList");

        Map<Car, Integer> carList = carService.getCarAgeList();
        List<Garage> garages = carService.getAllGarages();
        List<CarBrand> carBrands = carService.getAllCarBrands();
        List<CarColor> carColors = carService.getAllColors();
        List<CarSFX> carSFXes = carService.getAllCarSFX();

        modelAndView.addObject("garages",garages);
        modelAndView.addObject("brands",carBrands);
        modelAndView.addObject("colors",carColors);
        modelAndView.addObject("sfxes",carSFXes);
        modelAndView.addObject("cars",carList);
        return modelAndView;
    }

    @RequestMapping(value = "/carBookedList",method = RequestMethod.GET)
    public ModelAndView bookedCar() {

        ModelAndView modelAndView = new ModelAndView("Car/carInBookList");

        Map<Car, CarPlan> carList = carService.getCarBookedList();
        List<Garage> garages = carService.getAllGarages();
        List<CarBrand> carBrands = carService.getAllCarBrands();
        List<CarColor> carColors = carService.getAllColors();
        List<CarSFX> carSFXes = carService.getAllCarSFX();

        modelAndView.addObject("garages",garages);
        modelAndView.addObject("brands",carBrands);
        modelAndView.addObject("colors",carColors);
        modelAndView.addObject("sfxes",carSFXes);
        modelAndView.addObject("cars",carList);
        return modelAndView;
    }

    @RequestMapping(value = "/carOnTheWayList", method = RequestMethod.GET)
    public ModelAndView onTheWayCar(){
        ModelAndView modelAndView  = new ModelAndView("Car/carOnTheWay");
        Map<Car, CarPlan> carList = carService.getCarOnWayList();
        List<Garage> garages = carService.getAllGarages();
        List<CarBrand> carBrands = carService.getAllCarBrands();
        List<CarColor> carColors = carService.getAllColors();
        List<CarSFX> carSFXes = carService.getAllCarSFX();

        modelAndView.addObject("garages",garages);
        modelAndView.addObject("brands",carBrands);
        modelAndView.addObject("colors",carColors);
        modelAndView.addObject("sfxes",carSFXes);
        modelAndView.addObject("cars",carList);

        return modelAndView;
    }
    @RequestMapping(value = "/carInGarageList", method = RequestMethod.GET)
    public ModelAndView inGarageCar(){
        ModelAndView modelAndView = new ModelAndView("Car/carInGarage");
        Map<Car, CarPlan> carList = carService.getCarInGarage();
        List<Garage> garages = carService.getAllGarages();
        List<CarBrand> carBrands = carService.getAllCarBrands();
        List<CarColor> carColors = carService.getAllColors();
        List<CarSFX> carSFXes = carService.getAllCarSFX();

        modelAndView.addObject("garages",garages);
        modelAndView.addObject("brands",carBrands);
        modelAndView.addObject("colors",carColors);
        modelAndView.addObject("sfxes",carSFXes);
        modelAndView.addObject("cars",carList);

        return modelAndView;

    }

    @RequestMapping(value = "/carOutOfGarageList", method = RequestMethod.GET)
    public ModelAndView outOfGarage(){
        ModelAndView modelAndView = new ModelAndView("Car/carOutOfGarage");
        Map<Car, CarPlan> carList = carService.getCarOutOfGarage();
        List<Garage> garages = carService.getAllGarages();
        List<CarBrand> carBrands = carService.getAllCarBrands();
        List<CarColor> carColors = carService.getAllColors();
        List<CarSFX> carSFXes = carService.getAllCarSFX();

        modelAndView.addObject("garages",garages);
        modelAndView.addObject("brands",carBrands);
        modelAndView.addObject("colors",carColors);
        modelAndView.addObject("sfxes",carSFXes);
        modelAndView.addObject("cars",carList);
        return modelAndView;
    }

    @RequestMapping(value = "/carHandedOut", method = RequestMethod.GET)
    public ModelAndView carHandedOut(){
        ModelAndView modelAndView = new ModelAndView("Car/carSubmit");
        Map<Car, CarPlan> carList = carService.getCarByStatus("交车");
        List<Garage> garages = carService.getAllGarages();
        List<CarBrand> carBrands = carService.getAllCarBrands();
        List<CarColor> carColors = carService.getAllColors();
        List<CarSFX> carSFXes = carService.getAllCarSFX();

        modelAndView.addObject("garages",garages);
        modelAndView.addObject("brands",carBrands);
        modelAndView.addObject("colors",carColors);
        modelAndView.addObject("sfxes",carSFXes);
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
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/list");
        Car car = carService.findCarById(carID);
        try {
            final String BOOK = new String("订车".getBytes("UTF-8"),"UTF-8");
            final String ON_WAY = new String("在途".getBytes("UTF-8"),"UTF-8");
            final String IN_GARAGE = new String("在库".getBytes("UTF-8"),"UTF-8");
            final String OUT_GARAGE = new String("出库".getBytes("UTF-8"),"UTF-8");
            final String SUBMIT = new String("交车".getBytes("UTF-8"),"UTF-8");
            
            if(car != null){
                if(car.getStockStatus().equals(ON_WAY)){
                    car.setStockStatus(IN_GARAGE);
                    car.setInGarageTime(new Date());
                    carService.updateCar(car);
                }
                else if(car.getStockStatus().equals(BOOK)){
                    car.setStockStatus(ON_WAY);
                    car.setPurchasedTime(new Date());
                    carService.updateCar(car);
                }
                else if(car.getStockStatus().equals(IN_GARAGE)){
                    car.setStockStatus(OUT_GARAGE);
                    car.setOutGarageTime(new Date());
                    carService.updateCar(car);
                }

                else if(car.getStockStatus().equals(OUT_GARAGE)){
                    car.setStockStatus(SUBMIT);
                    car.setSubmitTime(new Date());
                    carService.updateCar(car);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return modelAndView;
        }

        System.out.println(car.getStockStatus());
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
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createCarType");
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
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createCarType");
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
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createCarType");
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
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createCarType");
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
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createCarType");
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

    @RequestMapping(value = "/createCarByCarPlan/{planID}",method = RequestMethod.GET)
    public ModelAndView createCarByCarPlan(@PathVariable int planID){
        ModelAndView modelAndView = new ModelAndView("Car/carTypeCreateStock");
        CarPlan carPlan = carService.getCarPlanByID(planID);
        if(carPlan == null){
            return modelAndView;
        }
        String garage = carPlan.getGarage();
        String brand = carPlan.getBrand();
        String color = carPlan.getCarColor();
        String sfx = carPlan.getCarSfx();
        List<?> statusList = carService.getAllStockStatus();
        modelAndView.addObject("garage",garage);
        modelAndView.addObject("brand",brand);
        modelAndView.addObject("color",color);
        modelAndView.addObject("sfx",sfx);
        modelAndView.addObject("statusList",statusList);
        modelAndView.addObject("planID",planID);
        modelAndView.addObject("car",new Car());
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
    public ModelAndView listCarType() {

        ModelAndView modelAndView = new ModelAndView("Car/carTypeList");
        List<?> carTypeList = carService.getAllCarType();
        List<Garage> garages = carService.getAllGarages();
        List<CarBrand> carBrands = carService.getAllCarBrands();
        List<CarColor> carColors = carService.getAllColors();
        List<CarSFX> carSFXes = carService.getAllCarSFX();

        modelAndView.addObject("garages",garages);
        modelAndView.addObject("brands",carBrands);
        modelAndView.addObject("colors",carColors);
        modelAndView.addObject("sfxes",carSFXes);
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
    public ModelAndView updateCarPlanType(@ModelAttribute CarPlan carPlan){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carPlanList");
//        CarPlan carPlan = (CarPlan)carPlan1;
        CarTypeID carTypeID = new CarTypeID(carPlan.getGarage(),carPlan.getBrand(),carPlan.getCarSfx(),carPlan.getCarColor());
        CarType stock = carService.getCarTypeByID(carTypeID);
        if(stock != null){
            int old_plan = stock.getPlan();
            stock.setPlan(carPlan.getNumber() + old_plan);
            carService.updateCarType(stock);
            carService.createCarPlan(carPlan);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/carPlanList",method = RequestMethod.GET)
    public ModelAndView carPlanList(){
        ModelAndView modelAndView = new ModelAndView("Car/carPlanList");
        modelAndView.addObject("plans",carService.getAllCarPlans());
        return modelAndView;
    }

    @RequestMapping(value = "/updateCarTypePrice", method = RequestMethod.POST)
    public ModelAndView updateCarTypePrice(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carTypeList");
        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String sfx = request.getParameter("sfx");
        CarTypeID carTypeID = new CarTypeID(garage,brand,sfx,color);
        CarType carType = carService.getCarTypeByID(carTypeID);
        if(carType != null) {
            String cost = request.getParameter("cost");
            String price = request.getParameter("price");
            String discount = request.getParameter("discount");

            if(!price.equals("null")) {
                carType.setPrice(Float.parseFloat(price));
            }
            if(!cost.equals("null")) {
                carType.setCost(Float.parseFloat(cost));
            }
            if(!discount.equals("null")) {
                carType.setDiscount(Float.parseFloat(discount));
            }

            carService.updateCarType(carType);
        }

        return  modelAndView;

    }
    @RequestMapping(value = "/selectCarBrand")
    public @ResponseBody
    Map<String,Object> selectCarBrand(HttpServletRequest request) throws IOException {
       // System.out.println(request.getParameter("garage"));
        Map<String,Object> map = new HashMap<String,Object>();

        String garage = request.getParameter("garage");
        List<CarBrand> brands = carService.getCarBrandsByGarage(garage);
        for (int i =0; i < brands.size(); i ++) {
            map.put(String.valueOf(i),brands.get(i).getBrand());
        }
        return map;
    }

    @RequestMapping(value = "/selectCarSfx")
    public @ResponseBody
    Map<String, Object> selectCarSfx(HttpServletRequest request) throws IOException{
        Map<String, Object> map = new HashedMap();

        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");

        List<CarSFX> carSFXes = carService.getCarSFXByBrand(garage,brand);

        for(int i = 0; i < carSFXes.size(); i ++){
            map.put(String.valueOf(i), carSFXes.get(i).getSfx());
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


    @RequestMapping(value = "/select")
    public @ResponseBody
    void selectCar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");
        String sfx = request.getParameter("sfx");
        String color = request.getParameter("color");

        List<Car> result = carService.getAllCars();

        if(!garage.equals("empty")){
            result = carService.CarGarageBrandFilter(result, garage);
        }

        if(!brand.equals("empty")){
            result = carService.CarBrandFilter(result, brand);
        }

        if(!sfx.equals("empty")){
            result = carService.CarSFXFilter(result, sfx);
        }

        if(!color.equals("empty")){
            result = carService.CarColorFilter(result, color);
        }

        JSONArray ja = new JSONArray();
        JSONObject jo = new JSONObject();
        int age;
        for(Car car : result){
            age = carService.getCarAge(car.getCarID());
            jo = JSONObject.fromObject(car);
            jo.put("age", age);
            ja.add(jo);
        }

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ja.toString());
        response.getWriter().flush();
    }


    @RequestMapping(value = "/carTypeSelect")
    public @ResponseBody
    void selectCarType(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String garage = request.getParameter("garage");
        String brand = request.getParameter("brand");
        String sfx = request.getParameter("sfx");
        String color = request.getParameter("color");

        List<CarType> result = carService.getValidCarType();

        if(!garage.equals("empty")){
            result = carService.GarageBrandFilter(result, garage);
        }

        if(!brand.equals("empty")){
            result = carService.BrandFilter(result, brand);
        }

        if(!sfx.equals("empty")){
            result = carService.SFXFilter(result, sfx);
        }

        if(!color.equals("empty")){
            result = carService.ColorFilter(result, color);
        }

        JSONArray ja = new JSONArray();
        ja = JSONArray.fromObject(request);

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ja.toString());
        response.getWriter().flush();
    }

    @RequestMapping(value = "/predict")
    public @ResponseBody
    Map<String,Object> predict(HttpServletRequest request) throws IOException{
        Map<String,Object> map = new HashMap<String,Object>();

        String carId = request.getParameter("carId");

        float loss = carService.carWarning(carId);
        int leftDay = carService.remainingProfitDay(carId);

        map.put("loss",loss);
        map.put("day",leftDay);
        return map;
    }
    @RequestMapping(value = "/carSold",method = RequestMethod.GET)
    public ModelAndView carSoldPage(){
        ModelAndView modelAndView = new ModelAndView("/Car/carSoldInfo");

        return modelAndView;
    }

    @RequestMapping(value = "/carSoldInfo")
    public @ResponseBody
    void soldCarInfo(HttpServletResponse response) throws IOException{

        List<Order> orders = orderService.getAllOrders();
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();

        for(Order order : orders){
            Car car = carService.findCarById(order.getCarID());

            List<Gift> gifts = giftService.findGiftByOrderId(order.getOrderID());
            List<Insurance> insurances = insuranceService.findInsuranceByOrderId(order.getOrderID());
            List<AdditionalProduct> additionalProducts = additionalProductService.findAdditionalProductByOrderId(order.getOrderID());

            float get = 0;
            float earn = 0;

            for(Gift gift : gifts){
                get += gift.getActualGetMoney();
                earn += (get - gift.getCost());
            }

            jo.put("giftGet",get);
            jo.put("giftEarn", earn);

            get = 0;
            earn = 0;

            for(Insurance insurance : insurances){
                get += insurance.getActualGetMoney();
                earn += (get - insurance.getCost());
            }
            jo.put("insuranceGet",get);
            jo.put("insuranceEarn", earn);

            get = 0;
            earn = 0;

            List<AdditionalProduct> finance = additionalProductService.additionalProductTypeFilter(additionalProducts,"金融");

            for(AdditionalProduct add : finance){
                get += add.getActualGetMoney();
                earn += (get - add.getCost());
            }

            jo.put("financeGet",get);
            jo.put("financeEarn", earn);

            get = 0;
            earn = 0;

            List<AdditionalProduct> secondHand = additionalProductService.additionalProductTypeFilter(additionalProducts,"二手车");

            for(AdditionalProduct add : secondHand){
                get += add.getActualGetMoney();
                earn += (get - add.getCost());
            }

            jo.put("secondHandCarGet",get);
            jo.put("secondHandCarEarn", earn);

            get = 0;
            earn = 0;


            List<AdditionalProduct> service = additionalProductService.additionalProductTypeFilter(additionalProducts,"服务费");

            for(AdditionalProduct add : service){
                get += add.getActualGetMoney();
                earn += (get - add.getCost());
            }

            jo.put("serviceGet",get);
            jo.put("serviceEarn", earn);

            get = 0;
            earn = 0;

            List<AdditionalProduct> VIP = additionalProductService.additionalProductTypeFilter(additionalProducts,"VIP");

            for(AdditionalProduct add : VIP){
                get += add.getActualGetMoney();
                earn += (get - add.getCost());
            }

            jo.put("VIPGet",get);
            jo.put("VIPEarn", earn);

            get = 0;
            earn = 0;

            List<AdditionalProduct> rent = additionalProductService.additionalProductTypeFilter(additionalProducts,"租赁");

            for(AdditionalProduct add : rent){
                get += add.getActualGetMoney();
                earn += (get - add.getCost());
            }

            jo.put("rentGet",get);
            jo.put("rentEarn", earn);

            /**水平事业毛利*/
            float allEarn = carService.additionalProfit(car.getCarID());
            /**水平事业收入*/
            float allIncome = carService.additionalIncome(car.getCarID());
            /**单车利润*/
            float carEarn = carService.carTotalProfit(car.getCarID());
            /**变动费用*/
            float dynamic = carService.carDynamicFee(car.getCarID(),1);


            jo.put("peripheralGet",allIncome);
            jo.put("peripheralEarn",allEarn);
            jo.put("getMoney", carEarn);
            jo.put("dynamic",dynamic);
            System.out.println(dynamic);

            jo.put("carId", car.getCarID());
            jo.put("brand",car.getBrand());
            jo.put("sfx",car.getSfx());
            jo.put("price",car.getPrice());
            jo.put("discount",car.getDiscount());
            jo.put("cost",car.getCost());
            jo.put("carEarn",car.getPrice() - car.getCost());
            jo.put("payback",car.getPayback());
            
            ja.add(jo);
            jo.clear();

        }

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ja.toString());
        response.getWriter().flush();
//        return modelAndView;
    }

    @RequestMapping(value = "/planPerMonth/{date}", method = RequestMethod.GET)
    public ModelAndView carPlanPerMonth(@PathVariable String date){
        ModelAndView modelAndView = new ModelAndView("Plan/carPlanPerMonth");
        Map<Float,Float> planByMonth = carService.getCarPlanByMonth(date);
        Map<Integer, Float> carSoldPerDay = carService.carSoldPerDay(date);
        Map<Integer, Float> carPurchasedPerDay = carService.carPurchasedPerDay(date);

        modelAndView.addObject("plans", planByMonth);
        modelAndView.addObject("carsSold", carSoldPerDay);
        modelAndView.addObject("carsPurchased", carPurchasedPerDay);
        modelAndView.addObject("date", date);
        return modelAndView;
    }


    @RequestMapping(value = "/carTypeProfit/{year}/{month}", method = RequestMethod.GET)
    public ModelAndView getCarTypeSoldByMonth(@PathVariable int year, @PathVariable int month) throws IOException{
        ModelAndView modelAndView = new ModelAndView("/Car/carSoldInfoByMonth");
        HashMap<String,HashMap<String, CarProfit>> carTypeProfit = carService.getCarTypeSoldByMonth(year, month);
        modelAndView.addObject("carTypeProfit",carTypeProfit);
        return modelAndView;
    }
}


