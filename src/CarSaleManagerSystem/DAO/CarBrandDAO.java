package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.CarBrand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/10.
 */
@Repository
public class CarBrandDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCarBrand(CarBrand carBrand){
        Session session = sessionFactory.getCurrentSession();
        session.save(carBrand);
    }

    public List<CarBrand> getAllCarBrands(){
        Session session = sessionFactory.getCurrentSession();

        /** to be implemented*/
        String hql = "from CarBrand";
        List<CarBrand> carBrands = session.createQuery(hql).list();
        return carBrands;
    }

    public void removeCarBrand(CarBrand carBrand){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(carBrand);
    }

    public void updateCarBrand(CarBrand carBrand){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(carBrand);
    }

    public CarBrand findCarBrandByBrand(String brand){
        Session session = this.sessionFactory.getCurrentSession();
        CarBrand carBrand = null;
        carBrand = (CarBrand)session.get(CarBrand.class, brand);
        return carBrand;
    }
}
