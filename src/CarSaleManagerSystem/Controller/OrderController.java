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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    @RequestMapping(value = "/detail/{carID}", method = RequestMethod.GET)
    public ModelAndView orderDetailPage(@PathVariable String carID){
        ModelAndView modelAndView = new ModelAndView("Order/orderDetail");
        Car car = carService.findCarById(carID);
        Order order = orderService.findOrderByCar(carID);
        //Customer customer = order.getCustomer();
//        List<Gift> giftSet = giftService.findGiftByOrderId(order.getOrderID());
//        List<Insurance> insurances = null;
        System.out.println(car.getCarID());
        System.out.println(order.getOrderID() + "hehe");
        modelAndView.addObject("car", car);
        modelAndView.addObject("order", order);
//        modelAndView.addObject("gifts", giftSet);
//        modelAndView.addObject("insurances", insurances);
        //modelAndView.addObject("customer", customer);
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
//            System.out.println(JAgifts.getJSONObject(0).getString("type"));
//            System.out.println(insurances);

            return modelAndView;
        }catch(Exception e){
            e.printStackTrace();
            return modelAndView;
        }
    }

}
