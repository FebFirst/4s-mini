package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.Insurance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Repository
public class InsuranceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createInsurance(Insurance insurance){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(insurance);
        session.flush();
    }

    public List<Insurance> getAllInsurances(){
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from Insurance";
        List<Insurance> insurances = session.createQuery(hql).list();
        return insurances;
    }

    public void removeInsurance(Insurance insurance){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(insurance);
        session.flush();
    }

    public void updateInsurance(Insurance insurance){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(insurance);
        session.flush();
    }

    public Insurance findInsuranceById(int insuranceID){
        Session session = this.sessionFactory.getCurrentSession();

        Insurance insurance = (Insurance)session.get(Insurance.class, insuranceID);

        return insurance;
    }

    public List<Insurance> findInsuranceByType(String type){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Insurance where type = '" + type +"'";
        List<Insurance> insuranceList = session.createQuery(hql).list();

        return insuranceList;
    }

    public List<Insurance> findInsuranceByOrderId(String orderId){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Insurance where orderID = '" + orderId +"'";
        List<Insurance> insuranceList = session.createQuery(hql).list();

        return insuranceList;
    }
}

