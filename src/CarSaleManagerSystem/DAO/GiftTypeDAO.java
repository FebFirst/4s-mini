package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.GiftType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/11.
 */
@Repository
public class GiftTypeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createGiftType(GiftType giftType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(giftType);
        session.flush();
    }

    public List<GiftType> getAllGiftTypes() {
        Session session = sessionFactory.getCurrentSession();

        String hql = "from GiftType";
        List<GiftType> giftTypes = session.createQuery(hql).list();

        return giftTypes;
    }

    public void removeGiftType(GiftType giftType){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(giftType);
        session.flush();
    }

    public void updateGiftType(GiftType giftType){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(giftType);
        session.flush();
    }

    public GiftType findGiftTypeById(String type){
        Session session = this.sessionFactory.getCurrentSession();

        GiftType giftType = (GiftType)session.get(GiftType.class, type);
        return giftType;
    }
}
