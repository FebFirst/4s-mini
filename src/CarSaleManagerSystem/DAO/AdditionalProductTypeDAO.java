package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.AdditionalProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by googo on 16/8/14.
 */
@Repository
public class AdditionalProductTypeDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createAdditionalProductType(AdditionalProductType additionalProductType){
        Session session = this.sessionFactory.getCurrentSession();

        session.save(additionalProductType);
        session.flush();
    }

    public List<AdditionalProductType> getAllAdditionalProductType(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from AdditionalProductType";
        List<AdditionalProductType> additionalProductTypes = session.createQuery(hql).list();
        return additionalProductTypes;
    }

    public void removeAdditionalProductType(AdditionalProductType additionalProductType){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(additionalProductType);
        session.flush();
    }

    public void updateAdditonalProductType(AdditionalProductType additionalProductType){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(additionalProductType);
        session.flush();
    }

    public AdditionalProductType findAdditionalProductTypeById(String type){
        Session session = this.sessionFactory.getCurrentSession();

        AdditionalProductType additionalProductType = (AdditionalProductType)session.get(AdditionalProductType.class,type);

        return additionalProductType;
    }
}
