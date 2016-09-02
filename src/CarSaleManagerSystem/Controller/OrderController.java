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

    @Autowired
    private CustomerService customerService;


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

//    @RequestMapping(value = "/detail/{carID}", method = RequestMethod.POST)
//    public void listOrder(@PathVariable String carID, HttpServletResponse response){
//       // JSONObject orderInfo = budgetService.getOrderInfo(carID);
////
////        PrintWriter printWriter;
////        try {
////            printWriter = response.getWriter();
////            printWriter.write(orderInfo.toString());
////        }catch (IOException e){
////            e.printStackTrace();
////        }
//    }

    @RequestMapping(value = "/addCarToOrder/{carID}",method = RequestMethod.GET)
    public ModelAndView addCarToOrderPage(@PathVariable String carID){
        ModelAndView modelAndView = new ModelAndView("Order/addCarToOrderPage");
        Car car = carService.findCarById(carID);
        List<Customer> customerList = customerService.getAllCustomer();
        modelAndView.addObject("car",car);
        modelAndView.addObject("customers",customerList);
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
    public ModelAndView createOrder(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("redirect: /Car/carSold");
        try {
            String orderId = request.getParameter("orderId");
            String carId = request.getParameter("carId");
            String customer = request.getParameter("customer");
            String predictDate = request.getParameter("predictDate");
            String gifts = request.getParameter("gifts");
            String insurances = request.getParameter("insurances");
            String userId = (String)session.getAttribute("userId");

            String secondCar = request.getParameter("secondCar");
            String finance = request.getParameter("finance");
            String card = request.getParameter("card");
            String VIP = request.getParameter("VIP");
            String rent = request.getParameter("rent");
            String longTerm = request.getParameter("long");
            orderService.beginAnOrder(orderId, carId, customer, predictDate, gifts, insurances, userId,
                    secondCar,finance,card,VIP,rent,longTerm);


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
        List<AdditionalProduct> secondHand = additionalProductService.additionalProductTypeFilter(additionalProducts,"���ֳ�");

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
        orderService.orderSaleImpl(orderId,actaulGetMoney, secondCar);

        ModelAndView modelAndView = new ModelAndView("redirect:/Car/carSold" );
        return modelAndView;
    }

    @RequestMapping(value = "/orderSaleManagerImpl/{orderID}", method = RequestMethod.GET)
    public ModelAndView managerImpl(@PathVariable String orderID){
        ModelAndView modelAndView = new ModelAndView("Order/orderSaleManagerImpl");
        Order order = orderService.findOrderById(orderID);
        Car car = carService.findCarById(order.getCarID());
        List<AdditionalProduct> additionalProducts = additionalProductService.findAdditionalProductByOrderId(orderID);

        List<AdditionalProduct> longTerm = additionalProductService.additionalProductTypeFilter(additionalProducts,"�ӱ�");

        List<AdditionalProduct> VIP = additionalProductService.additionalProductTypeFilter(additionalProducts,"VIP");

        List<AdditionalProduct> rent = additionalProductService.additionalProductTypeFilter(additionalProducts,"����");

        List<AdditionalProduct> card = additionalProductService.additionalProductTypeFilter(additionalProducts,"����");

        List<AdditionalProduct> present = additionalProductService.additionalProductTypeFilter(additionalProducts,"����");

        List<AdditionalProduct> hire = additionalProductService.additionalProductTypeFilter(additionalProducts,"Ӷ��");

        List<AdditionalProduct> finance = additionalProductService.additionalProductTypeFilter(additionalProducts,"����");


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

        orderService.orderSaleManager(finance,card,VIP,rent,hire,longTerm);
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
           giftService.updateGiftListByJSONWaitressHelper(gifts);
        }
        if(insurances != null){
            insuranceService.updateInsuranceByJSONWaitressHelper(insurances);

        }
        return modelAndView;
    }
}
