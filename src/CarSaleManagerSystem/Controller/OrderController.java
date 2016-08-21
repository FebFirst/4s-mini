package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.*;
import com.mongodb.util.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by googo on 16/8/10.
 */

@Controller
@RequestMapping(value = "/Order")
public class OrderController {
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CarService carService;
    @Autowired
    private GiftService giftService;
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private  AdditionalProductService additionalProductService;

    @RequestMapping(value = "/detail/{carID}", method = RequestMethod.GET)
    public ModelAndView orderDetailPage(@PathVariable String carID){
        ModelAndView modelAndView = new ModelAndView("Order/orderDetail");
        Car car = carService.findCarById(carID);
        Order order = orderService.findOrderByCar(carID);
        modelAndView.addObject("car", car);
        modelAndView.addObject("order", order);
        return modelAndView;
    }

//    @RequestMapping(value = "/detailByGarage",method = RequestMethod.POST)
//    public ModelAndView orderDetailByGarage(HttpServletRequest request){
//        ModelAndView modelAndView = new ModelAndView("Order/orderDetail");
//        String garage = request.getParameter("garage");
//
//        List<Car> allCars = carService.getAllCars();
//
//        List<Car> cars = carService.CarGarageBrandFilter(allCars,garage);
//       // CarTypeID carTypeID = new CarTypeID(garage,brand,sfx,color);
//        //Map<Car,Integer> carList = carService.getCarAgeListByCarType(carTypeID);
//        modelAndView.addObject("cars",cars);
//        return modelAndView;
//    }

    @RequestMapping(value = "/detail/{carID}", method = RequestMethod.POST)
    public void listOrder(@PathVariable String carID, HttpServletResponse response){
       // JSONObject orderInfo = budgetService.getOrderInfo(carID);
//
//        PrintWriter printWriter;
//        try {
//            printWriter = response.getWriter();
//            printWriter.write(orderInfo.toString());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }

    @RequestMapping(value = "/addCarToOrder/{carID}",method = RequestMethod.GET)
    public ModelAndView addCarToOrderPage(@PathVariable String carID){
        ModelAndView modelAndView = new ModelAndView("Order/addCarToOrderPage");
        Car car = carService.findCarById(carID);
        modelAndView.addObject("car",car);
        modelAndView.addObject("order",new Order());
        return modelAndView;
    }

    @RequestMapping(value = "/addCarToOrder",method = RequestMethod.POST)
    public ModelAndView addCarToOrder(@ModelAttribute Order order){
        ModelAndView modelAndView = new ModelAndView("Order/addCarToOrderPage");
        orderService.createOrder(order);
        return modelAndView;
    }



    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public ModelAndView carListByCarType(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("Order/orderDetail");
        try {
            String orderId = request.getParameter("orderId");
            String carId = request.getParameter("carId");
            String customer = request.getParameter("customer");
            String predictDate = request.getParameter("predictDate");
            String gifts = request.getParameter("gifts");
            String insurances = request.getParameter("insurances");

            Car car = carService.findCarById(carId);
            car.setValid("N");
            carService.updateCar(car);

            Order order = new Order();
            float price = car.getPrice();


            order.setOrderID(orderId);
            order.setCarID(carId);
            order.setCustomerID(Integer.valueOf(customer));
            //int userId = (Integer)session.getAttribute("userId");
            if (session.getAttribute("userId") != null) {
                order.setSalesmanID((Integer) session.getAttribute("userId"));
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date date = sdf.parse(predictDate);
            order.setPredicted_pay_time(date);
            order.setFinish_status("N");
            order.setDate(new Date());



            JSONArray JAgifts = new JSONArray();
            JSONArray JAinsurances = new JSONArray();
            List<Gift> giftList = new ArrayList<>();
            List<Insurance> insuranceList = new ArrayList<>();

            JAgifts = JSONArray.fromObject(gifts);
            JAinsurances = JSONArray.fromObject(insurances);

            for (int i = 0; i < JAgifts.size(); i++) {
                JSONObject jo = JAgifts.getJSONObject(i);
                String type = jo.getString("type");
                String name = jo.getString("name");
                Gift gift = giftService.giftTypeNameFilter(type, name).get(0);
                gift.setOrderID(orderId);
                price += gift.getDefault_price();
                giftList.add(gift);
            }

            for (int i = 0; i < JAinsurances.size(); i++) {
                JSONObject jo = JAinsurances.getJSONObject(i);
                String type = jo.getString("type");
                String name = jo.getString("name");
                Insurance insurance = insuranceService.insuranceTypeNameFilter(type, name).get(0);
                insurance.setOrderID(orderId);
                price += insurance.getDefault_price();
                insuranceList.add(insurance);
            }

            order.setSalePrice(price);
            orderService.createOrder(order);

            for(Gift gift : giftList){
                giftService.updateGift(gift);
            }

            for(Insurance insurance: insuranceList){
                insuranceService.updateInsurance(insurance);
            }


            return modelAndView;
        }catch(Exception e){
            e.printStackTrace();
            return modelAndView;
        }
    }


    @RequestMapping(value = "/orderExists")
    public @ResponseBody
    Map<String, Object> orderExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String orderId = request.getParameter("orderId");

        if(!orderService.orderExists(orderId)){
            map.put("message","false");
        }else {
            map.put("message","true");
        }
        return map;
    }


    @RequestMapping(value = "/orderSaleImpl/{orderID}", method = RequestMethod.GET)
    public ModelAndView orderSaleImplPage(@PathVariable String orderID){
        ModelAndView modelAndView = new ModelAndView("Order/orderSaleImpl");

        Order order = orderService.findOrderById(orderID);
        Car car = carService.findCarById(order.getCarID());

        List<AdditionalProduct> additionalProducts = additionalProductService.findAdditionalProductByOrderId(orderID);
        List<AdditionalProduct> secondHand = additionalProductService.additionalProductTypeFilter(additionalProducts,"二手车");

        modelAndView.addObject("car", car);
        modelAndView.addObject("order", order);
        modelAndView.addObject("secondHand",secondHand);

        return modelAndView;
    }

    @RequestMapping(value = "/orderSaleImpl",method = RequestMethod.POST)
    public ModelAndView orderSaleImpl(HttpServletRequest request) {
        String orderId = request.getParameter("orderId");
        String carId = request.getParameter("carId");
        String actaulGetMoney = request.getParameter("actualGetMoney");
        String secondCar = request.getParameter("secondCar");
        System.out.println( orderId);
        Order order = orderService.findOrderById(orderId);
        order.setActualGetMoney(Float.parseFloat(actaulGetMoney));

        orderService.updateOrder(order);

        if(Float.parseFloat(secondCar) != 0){
            List<AdditionalProduct> additionalProducts = additionalProductService.findAdditionalProductByOrderId(orderId);
            List<AdditionalProduct> additionalProductList = additionalProductService.additionalProductTypeFilter(additionalProducts,"二手车");
            if(additionalProductList != null){
                AdditionalProduct additionalProduct = additionalProductList.get(0);

                additionalProduct.setActualGetMoney(Float.parseFloat(secondCar));

                additionalProductService.updateAdditionalProduct(additionalProduct);
            }
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carSold" );
        return modelAndView;
    }

    @RequestMapping(value = "/orderSaleManagerImpl/{orderID}", method = RequestMethod.GET)
    public ModelAndView managerImpl(@PathVariable String orderID){
        ModelAndView modelAndView = new ModelAndView("Order/orderSaleManagerImpl");
        Order order = orderService.findOrderById(orderID);
        Car car = carService.findCarById(order.getCarID());
        List<AdditionalProduct> additionalProducts = additionalProductService.findAdditionalProductByOrderId(orderID);

        List<AdditionalProduct> longTerm = additionalProductService.additionalProductTypeFilter(additionalProducts,"延保");

        List<AdditionalProduct> VIP = additionalProductService.additionalProductTypeFilter(additionalProducts,"VIP");

        List<AdditionalProduct> rent = additionalProductService.additionalProductTypeFilter(additionalProducts,"租赁");

        List<AdditionalProduct> card = additionalProductService.additionalProductTypeFilter(additionalProducts,"上牌");

        List<AdditionalProduct> present = additionalProductService.additionalProductTypeFilter(additionalProducts,"赠送");

        List<AdditionalProduct> hire = additionalProductService.additionalProductTypeFilter(additionalProducts,"佣金");

        List<AdditionalProduct> finance = additionalProductService.additionalProductTypeFilter(additionalProducts,"金融");


        if(finance.size() != 0) {
            modelAndView.addObject("finance", finance.get(0));
            modelAndView.addObject("financeMsg","YES");
        }else{
            modelAndView.addObject("financeMsg", "NO");
        }

        if(longTerm.size() != 0) {
            modelAndView.addObject("longTerm", longTerm.get(0));
            modelAndView.addObject("longTermMsg","YES");
        }else {
            modelAndView.addObject("longTerm", null);
            modelAndView.addObject("longTermMsg","NO");
        }

        if(VIP.size() != 0){
            modelAndView.addObject("VIP",VIP.get(0));
            modelAndView.addObject("VIPMsg","YES");
        }else{
            modelAndView.addObject("VIP",null);
            modelAndView.addObject("VIPMsg","NO");
        }


        if(rent.size() != 0) {
            modelAndView.addObject("rent", rent.get(0));
            modelAndView.addObject("rentMsg","YES");
        }else {
            modelAndView.addObject("rent", null);
            modelAndView.addObject("rentMsg","NO");
        }

        if(card.size() != 0) {
            modelAndView.addObject("card", card.get(0));
            modelAndView.addObject("cardMsg","YES");
        }else{
            modelAndView.addObject("card", null);
            modelAndView.addObject("cardMsg","NO");
        }

        if(present.size() != 0) {
            modelAndView.addObject("present", present.get(0));
            modelAndView.addObject("presentMsg","YES");
        }else{
            modelAndView.addObject("present",null);
            modelAndView.addObject("presentMsg","NO");
        }

        if(hire.size() != 0) {
            modelAndView.addObject("hire", hire.get(0));
            modelAndView.addObject("hireMsg","YES");
        }else {
            modelAndView.addObject("hire", null);
            modelAndView.addObject("hireMsg","NO");
        }
        modelAndView.addObject("car", car);
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @RequestMapping(value = "/orderSaleManagerImpl",method = RequestMethod.POST)
    public ModelAndView managerImpl(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carSold" );

        String orderId = request.getParameter("orderId");
        String finance = request.getParameter("finance");
        String card = request.getParameter("card");
        String VIP = request.getParameter("VIP");
        String rent = request.getParameter("rent");
        String hire = request.getParameter("hire");
        String longTerm = request.getParameter("longTerm");

        JSONArray ja;
        JSONObject jo;


        if(finance != null && JSONArray.fromObject(finance).size() != 0){
            additionalProductService.updateAdditionalProductByJSON(finance);
        }

        if(card != null && JSONArray.fromObject(card).size() != 0){
            additionalProductService.updateAdditionalProductByJSON(card);
        }


        if(VIP != null && JSONArray.fromObject(VIP).size() != 0){
            additionalProductService.updateAdditionalProductByJSON(VIP);
        }

        if(rent != null && JSONArray.fromObject(rent).size() != 0){
            additionalProductService.updateAdditionalProductByJSON(rent);
        }

        if(hire != null && JSONArray.fromObject(hire).size() != 0){
            additionalProductService.updateAdditionalProductByJSON(hire);
        }

        if(longTerm != null){
            ja = JSONArray.fromObject(longTerm);
            for(int i = 0; i < ja.size(); i ++){
                jo = ja.getJSONObject(i);
                additionalProductService.updateAdditionalProductByJSON(jo.toString());
            }

        }
        return modelAndView;
    }

    @RequestMapping(value = "/orderWaitressImpl/{orderID}", method = RequestMethod.GET)
    public ModelAndView waitressImplPage(@PathVariable String orderID){
        ModelAndView modelAndView = new ModelAndView("Order/orderWaitressImpl");
        Order order = orderService.findOrderById(orderID);
        Car car = carService.findCarById(order.getCarID());
        List<Gift> gifts = giftService.findGiftByOrderId(orderID);
        List<Insurance> insurances = insuranceService.findInsuranceByOrderId(orderID);


        modelAndView.addObject("gifts",gifts);
        modelAndView.addObject("insurances",insurances);
        modelAndView.addObject("car", car);
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @RequestMapping(value = "/orderWaitressImpl",method = RequestMethod.POST)
    public ModelAndView waitressImpl(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carSold" );

        String orderId = request.getParameter("orderId");
        String carId = request.getParameter("carId");
        String gifts = request.getParameter("gifts");
        String insurances = request.getParameter("insurances");

        JSONArray ja;
        JSONObject jo;

        if(gifts != null){
            ja = JSONArray.fromObject(gifts);
            for(int i = 0; i < ja.size(); i ++){
                jo = ja.getJSONObject(i);
                int giftId = Integer.valueOf(jo.getString("giftId"));

                Gift gift = giftService.findGiftById(giftId);

                gift.setActualGetMoney(Float.parseFloat(jo.getString("money")));

                giftService.updateGift(gift);
            }

        }

        if(insurances != null){
            ja = JSONArray.fromObject(insurances);
            for(int i = 0; i < ja.size(); i ++){
                jo = ja.getJSONObject(i);
                //System.out.println(jo.get("giftId").toString());
                int insuranceId = Integer.valueOf(jo.getString("insuranceId"));

                Insurance insurance = insuranceService.findInsuranceById(insuranceId);

                insurance.setActualGetMoney(Float.parseFloat(jo.getString("money")));

                insuranceService.updateInsurance(insurance);

            }

        }
        return modelAndView;
    }
}
