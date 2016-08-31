package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.GiftBrand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/19.
 */
@Repository
public class GiftBrandDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createGiftBrand(GiftBrand giftBrand) {
        Session session = sessionFactory.getCurrentSession();
        session.save(giftBrand);
        session.flush();
    }

    public List<GiftBrand> getAllGiftBrands() {
        Session session = sessionFactory.getCurrentSession();

        String hql = "from GiftBrand";
        List<GiftBrand> giftBrands = session.createQuery(hql).list();

        return giftBrands;
    }

    public void removeGiftBrand(GiftBrand giftBrand){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(giftBrand);
        session.flush();
    }

    public void updateGiftBrand(GiftBrand giftBrand){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(giftBrand);
        session.flush();
    }

    public GiftBrand findGiftBrandById(String type, String brand){
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from GiftBrand where type = '" + type +"' and giftBrand = '" + brand + "'";
        List<GiftBrand> giftBrandList = session.createQuery(hql).list();
        if(giftBrandList == null || giftBrandList.size() == 0){
            return null;
        }
        GiftBrand giftBrand = (GiftBrand)giftBrandList.get(0);
        return giftBrand;
    }
}
