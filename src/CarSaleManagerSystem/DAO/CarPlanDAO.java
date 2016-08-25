package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.Car;
import CarSaleManagerSystem.Bean.CarPlan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/20.
 */
@Repository
public class CarPlanDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCarPlan(CarPlan carPlan){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(carPlan);
        session.flush();
    }


    public List<CarPlan> getAllCarPlan(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarPlan";
//        System.out.print(hql);
        List<CarPlan> carPlans = session.createQuery(hql).list();
//        System.out.println(hql);
        return carPlans;
    }

    public void removeCarPlan(CarPlan carPlan){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(carPlan);
        session.flush();
    }

    public void updateCarPlan(CarPlan carPlan){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(carPlan);
        session.flush();
    }

    public List<CarPlan> findCarPlanByGarageBrand(String garageBrand){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarPlan where garage = '" + garageBrand + "'";
        List<CarPlan> carPlans = session.createQuery(hql).list();
        return carPlans;
    }

    public List<CarPlan> findCarPlanByBrand(String brand){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarPlan where brand = '" + brand + "'";
        List<CarPlan> carPlans = session.createQuery(hql).list();
        return carPlans;
    }

    public List<CarPlan> findCarPlanBySFX(String SFX){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarPlan where carSfx = '" + SFX + "'";
        List<CarPlan> carPlans = session.createQuery(hql).list();
        return carPlans;
    }

    public List<CarPlan> findCarPlanByColor(String color){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CarPlan where carColor = '" + color + "'";
        List<CarPlan> carPlans = session.createQuery(hql).list();
        return carPlans;
    }

    public CarPlan getCarPlanByID(int planID){
        Session session = this.sessionFactory.getCurrentSession();
        CarPlan carPlan = (CarPlan)session.get(CarPlan.class,planID);
        return carPlan;
    }
}