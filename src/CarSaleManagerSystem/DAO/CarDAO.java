package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/7.
 */
@Repository
public class CarDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCar(Car car){
        Session session = sessionFactory.getCurrentSession();
        session.save(car);
        session.flush();
    }

    public List<Car> getAllCars(){
        Session session = sessionFactory.getCurrentSession();

        /** to be implemented*/
        String hql = "from Car";
        List<Car> cars = session.createQuery(hql).list();
        return cars;
    }

    public void removeCar(Car car){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(car);
    }

    public void updateCar(Car car){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(car);
    }

    public Car findCarById(String carID){
        Session session = this.sessionFactory.getCurrentSession();
        Car car = null;
        car = (Car)session.get(Car.class, carID);
        return car;
    }

}
