package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.InsuranceType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/11.
 */
@Repository
public class InsuranceTypeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createInsuranceType(InsuranceType insuranceType){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(insuranceType);
        session.flush();
    }

    public List<InsuranceType> getAllInsuranceTypes(){
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from InsuranceType";
        List<InsuranceType> insuranceTypes = session.createQuery(hql).list();
        return insuranceTypes;
    }

    public void removeInsuranceType(InsuranceType insuranceType){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(insuranceType);
        session.flush();
    }

    public void updateInsuranceType(InsuranceType insuranceType){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(insuranceType);
        session.flush();
    }

    public InsuranceType findInsuranceTypeById(String insuranceTypeID){
        Session session = this.sessionFactory.getCurrentSession();

        InsuranceType insuranceType = (InsuranceType)session.get(InsuranceType.class, insuranceTypeID);

        return insuranceType;
    }
}

