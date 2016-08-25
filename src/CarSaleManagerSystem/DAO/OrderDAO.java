package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Repository
public class OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createOrder(Order order){
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
        session.flush();
    }

    public List<Order> getAllOrders(){
        Session session = sessionFactory.getCurrentSession();


        String hql = "from Order";
        List<Order> orders = session.createQuery(hql).list();
        return orders;
    }

    public void removeOrder(Order order){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(order);
        session.flush();
    }

    public void updateOrder(Order order){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(order);
        session.flush();
    }

    public Order findOrderById(String orderID){
        Session session = this.sessionFactory.getCurrentSession();
        Order order = (Order)session.get(Order.class, orderID);
        return order;
    }


    public Order findOrderByCar(String carID){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Order where carID = '" + carID + "'";
        List<Order> orders = session.createQuery(hql).list();
        //Order order = (Order)session.get(Order.class, carID);
        return orders.get(0);
    }


    public List<Order> findOrderByCustomer(int customerID){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Order where customerID = " + customerID;
        List<Order> orders = session.createQuery(hql).list();

        return orders;
    }
}
