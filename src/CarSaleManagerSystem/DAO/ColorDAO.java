package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.CarColor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/8.
 */
@Repository
public class ColorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createColor(CarColor carColor){
        Session session = sessionFactory.getCurrentSession();
        session.save(carColor);
    }

    public List<CarColor> getAllColors(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "from CarColor";
        List<CarColor> carColors = session.createQuery(hql).list();
        return carColors;
    }

    public void removeColor(CarColor carColor){
        Session session = sessionFactory.getCurrentSession();
        session.delete(carColor);
    }

    public void updateColor(CarColor carColor){
        Session session = sessionFactory.getCurrentSession();
        session.update(carColor);
    }

    public CarColor getColorByID(String color){
        Session session = sessionFactory.getCurrentSession();
        CarColor carColor = null;
        carColor = (CarColor)session.get(CarColor.class,color);
        return carColor;
    }
}
