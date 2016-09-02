package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.AdditionalProduct;
import CarSaleManagerSystem.Bean.Car;
import CarSaleManagerSystem.Bean.Customer;
import CarSaleManagerSystem.Bean.Order;
import CarSaleManagerSystem.DAO.AdditionalProductDAO;
import CarSaleManagerSystem.DAO.CarDAO;
import CarSaleManagerSystem.DAO.CustomerDAO;
import CarSaleManagerSystem.DAO.OrderDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private AdditionalProductDAO additionalProductDAO;

    @Autowired
    private CarDAO carDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private GiftService giftService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AdditionalProductService additionalProductService;
    public void createOrder(Order order){
        orderDAO.createOrder(order);
    }

    public List<Order> getAllOrders(){
        return orderDAO.getAllOrders();
    }

    public void removeOrder(Order order){
        orderDAO.removeOrder(order);
    }

    public void updateOrder(Order order){
        orderDAO.updateOrder(order);
    }

    public Order findOrderById(String orderID){
        return orderDAO.findOrderById(orderID);
    }

    public List<Order> findOrderByCustomer(int customerID){
        return orderDAO.findOrderByCustomer(customerID);
    }

    public Order findOrderByCar(String carID){
        return orderDAO.findOrderByCar(carID);
    }

    public boolean orderExists(String orderId){
         Order order = orderDAO.findOrderById(orderId);
        if(order == null){
            return false;
        }
//        if(order.getValid().equals("N")){
//            return false;
//        }

        return true;
    }


    public void orderSaleImpl(String orderId, String actualGetMoney, String secondCar){
        Order order = orderDAO.findOrderById(orderId);
        order.setActualGetMoney(Float.parseFloat(actualGetMoney));

        orderDAO.updateOrder(order);

        if(Float.parseFloat(secondCar) != 0){
            List<AdditionalProduct> additionalProducts = additionalProductDAO.findAdditionalProductByOrderId(orderId);
            List<AdditionalProduct> additionalProductList = additionalProductDAO.additionalProductTypeFilter(additionalProducts,"���ֳ�");
            if(additionalProductList != null){
                AdditionalProduct additionalProduct = additionalProductList.get(0);
                additionalProduct.setActualGetMoney(Float.parseFloat(secondCar));
                additionalProductDAO.updateAdditionalProduct(additionalProduct);
            }
        }

    }


    public void orderSaleManager(String finance, String card, String VIP, String rent, String hire, String longTerm){

        JSONArray ja;
        JSONObject jo;


        if(finance != null && JSONArray.fromObject(finance).size() != 0){
            additionalProductDAO.updateAdditionalProductByJSON(finance);
        }

        if(card != null && JSONArray.fromObject(card).size() != 0){
            additionalProductDAO.updateAdditionalProductByJSON(card);
        }


        if(VIP != null && JSONArray.fromObject(VIP).size() != 0){
            additionalProductDAO.updateAdditionalProductByJSON(VIP);
        }

        if(rent != null && JSONArray.fromObject(rent).size() != 0){
            additionalProductDAO.updateAdditionalProductByJSON(rent);
        }

        if(hire != null && JSONArray.fromObject(hire).size() != 0){
            additionalProductDAO.updateAdditionalProductByJSON(hire);
        }

        if(longTerm != null){
            ja = JSONArray.fromObject(longTerm);
            for(int i = 0; i < ja.size(); i ++){
                jo = ja.getJSONObject(i);
                additionalProductDAO.updateAdditionalProductByJSON(jo.toString());
            }

        }
    }


    public void beginAnOrder(String orderId, String carId, String customer, String predictDate, String gifts, String insurances, String userId,
                             String secondCar, String finance, String card, String VIP, String rent, String longTerm){
        try {
            Car car = carDAO.findCarById(carId);
            car.setValid("N");
            carDAO.updateCar(car);

            Order order = new Order();
            order.setOrderID(orderId);
            order.setCarID(carId);
            Customer customer1 = new Customer();
            customer1.setName(customer);
            System.out.println(customer1.getName());
            customerDAO.createCustomer(customer1);

            customer1 = customerDAO.findCustomerByName(customer1.getName());
            if(customer1 != null) {
                order.setCustomerID(customer1.getCustomerID());
            }else{
                System.out.println("cao nimade DJ");
            }

            if (userId != null) {
                order.setSalesmanID(Integer.parseInt(userId));
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date date = sdf.parse(predictDate);
            order.setPredicted_pay_time(date);
            order.setFinish_status("N");
            order.setDate(new Date());
            orderDAO.createOrder(order);

            giftService.createGiftListByJSONOrderCreateHelper(gifts, orderId);
            insuranceService.createInsurancesByJSONOrderCreateHelper(insurances, orderId);


            AdditionalProduct additionalProduct = new AdditionalProduct();
            additionalProduct.setOrderID(orderId);

            additionalProduct.setSelling_price(Float.parseFloat(secondCar));
            additionalProduct.setAdditionalProductType("二手车");
            additionalProductService.createAdditionalProduct(additionalProduct);

            additionalProduct.setSelling_price(Float.parseFloat(finance));
            additionalProduct.setAdditionalProductType("金融");
            additionalProductService.createAdditionalProduct(additionalProduct);

            additionalProduct.setSelling_price(Float.parseFloat(card));
            additionalProduct.setAdditionalProductType("上牌");
            additionalProductService.createAdditionalProduct(additionalProduct);

            additionalProduct.setSelling_price(Float.parseFloat(VIP));
            additionalProduct.setAdditionalProductType("会员");
            additionalProductService.createAdditionalProduct(additionalProduct);

            additionalProduct.setSelling_price(Float.parseFloat(rent));
            additionalProduct.setAdditionalProductType("租赁");
            additionalProductService.createAdditionalProduct(additionalProduct);

            additionalProduct.setSelling_price(Float.parseFloat(longTerm));
            additionalProduct.setAdditionalProductType("延保");
            additionalProductService.createAdditionalProduct(additionalProduct);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
