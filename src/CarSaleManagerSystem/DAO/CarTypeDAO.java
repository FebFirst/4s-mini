package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.CarType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/11.
 */

@Repository
public class CarTypeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCarType(CarType carType){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(carType);
        session.flush();
    }


    public List<CarType> getAllCarType(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarType";
//        System.out.print(hql);
        List<CarType> carTypes = session.createQuery(hql).list();
//        System.out.println(hql);
        return carTypes;
    }

    public void removeCarType(CarType carType){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(carType);
        session.flush();
    }

    public void updateCarType(CarType carType){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(carType);
        session.flush();
    }

    public List<CarType> findCarTypeByGarageBrand(String garageBrand){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarType where garageBrand = '" + garageBrand + "'";
        List<CarType> carTypes = session.createQuery(hql).list();
        return carTypes;
    }

    public List<CarType> findCarTypeByBrand(String brand){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarType where brand = '" + brand + "'";
        List<CarType> carTypes = session.createQuery(hql).list();
        return carTypes;
    }

    public List<CarType> findCarTypeBySFX(String SFX){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarType where sfx = '" + SFX + "'";
        List<CarType> carTypes = session.createQuery(hql).list();
        return carTypes;
    }

    public List<CarType> findCarTypeByColor(String color){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarType where color = '" + color + "'";
        List<CarType> carTypes = session.createQuery(hql).list();
        return carTypes;
    }
}
