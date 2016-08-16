package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.CarSFX;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/11.
 */
@Repository
public class SFXDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCarSFX(CarSFX carSFX){
        Session session = sessionFactory.getCurrentSession();
        session.save(carSFX);
        session.flush();
    }

    public List<CarSFX> getAllCarSFXs(){
        Session session = sessionFactory.getCurrentSession();

        /** to be implemented*/
        String hql = "from CarSFX";
        List<CarSFX> carSFXs = session.createQuery(hql).list();
        return carSFXs;
    }

    public void removeCarSFX(CarSFX carSFX){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(carSFX);
    }

    public void updateCarSFX(CarSFX carSFX){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(carSFX);
    }

    public CarSFX findCarSFXById(String carSFXID){
        Session session = this.sessionFactory.getCurrentSession();
        CarSFX carSFX = null;
        carSFX = (CarSFX)session.get(CarSFX.class, carSFXID);
        return carSFX;
    }
}
