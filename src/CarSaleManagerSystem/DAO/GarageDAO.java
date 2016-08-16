package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.Garage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/7.
 */
@Repository
public class GarageDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createGarage(Garage garage){
        Session session = sessionFactory.getCurrentSession();
        session.save(garage);
    }

    public List<Garage> getAllGarages(){
        Session session = sessionFactory.getCurrentSession();

        /** to be implemented*/
        String hql = "from Garage";
        List<Garage> garages = session.createQuery(hql).list();
        return garages;
    }

    public void removeGarage(Garage garage){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(garage);
    }

    public void updateGarage(Garage garage){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(garage);
    }

    public Garage findGarageByBrand(String brand){
        Session session = this.sessionFactory.getCurrentSession();
        Garage garage = null;
        garage = (Garage)session.get(Garage.class, brand);
        return garage;
    }
}
