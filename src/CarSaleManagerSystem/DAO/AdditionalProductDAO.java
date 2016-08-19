package CarSaleManagerSystem.DAO;


import CarSaleManagerSystem.Bean.AdditionalProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by googo on 16/8/14.
 */
@Repository
public class AdditionalProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createAdditionalProduct(AdditionalProduct additionalProduct){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(additionalProduct);
        session.flush();
    }

    public List<AdditionalProduct> getAllAdditionalProduct(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from AdditionalProduct";
        List<AdditionalProduct> additionalProductList = session.createQuery(hql).list();
        return additionalProductList;
    }

    public void removeAdditionalProduct(AdditionalProduct additionalProduct){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(additionalProduct);
        session.flush();
    }

    public void updateAdditionalProduct(AdditionalProduct additionalProduct){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(additionalProduct);
        session.flush();
    }

    public  AdditionalProduct findAdditionalProductById(int additionalProductId){
        Session session = this.sessionFactory.getCurrentSession();

        AdditionalProduct additionalProduct = (AdditionalProduct)session.get(AdditionalProduct.class, additionalProductId);

        return additionalProduct;
    }

    public List<AdditionalProduct> findAdditionalProductByOrderId(String orderId){
        Session session  = this.sessionFactory.getCurrentSession();

        String hql = "from AdditionalProduct where orderID = '" + orderId + "'";

        List<AdditionalProduct> additionalProducts = null;

        additionalProducts = session.createQuery(hql).list();
        return additionalProducts;
    }
}
