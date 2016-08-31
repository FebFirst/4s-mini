package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.SalesPlan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/29.
 */
@Repository
public class SalesPlanDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void createSalesPlan(SalesPlan salesPlan){
        Session session = this.sessionFactory.getCurrentSession();

        session.save(salesPlan);
        session.flush();
    }

    public List<SalesPlan> getAllSalesPlans(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from SalesPlan";
        List<SalesPlan> salesPlans = session.createQuery(hql).list();

        return salesPlans;
    }

    public void removeSalesPlan(SalesPlan salesPlan){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(salesPlan);
        session.flush();
    }

    public void updateSalesPlan(SalesPlan salesPlan){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(salesPlan);
        session.flush();
    }

    public SalesPlan findSalesPlanById(int salesPlanId){
        Session session = this.sessionFactory.getCurrentSession();

        SalesPlan result = (SalesPlan)session.get(SalesPlan.class, salesPlanId);
        return result;
    }
}
