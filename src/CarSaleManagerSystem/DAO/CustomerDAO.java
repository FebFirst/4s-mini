package CarSaleManagerSystem.DAO;


import CarSaleManagerSystem.Bean.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by googo on 16/8/10.
 */
@Repository
public class CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCustomer(Customer customer){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(customer);
        session.flush();
    }

    public List<Customer> getAllCustomer(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Customer";
        List<Customer> customers = session.createQuery(hql).list();
        return customers;
    }

    public void removeCustomer(Customer customer){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(customer);
        session.flush();
    }

    public void updateCustomer(Customer customer){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
        session.flush();
    }

    public Customer findCustomerById(int customerID){
        Session session = this.sessionFactory.getCurrentSession();

        Customer customer = null;

        customer = (Customer)session.get(Customer.class, customerID);

        return customer;
    }

    public Customer findCustomerByName(String name){
        List<Customer> customerList = getAllCustomer();

        if(customerList == null){
            return null;
        }

        for(Customer customer : customerList){
            if(customer.getName().equals(name))
                return customer;
        }

        return null;
    }
}
