package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.Order;
import CarSaleManagerSystem.DAO.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

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

}
