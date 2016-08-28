package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.Gift;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Repository
public class GiftDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createGift(Gift gift) {
        Session session = sessionFactory.getCurrentSession();
        session.save(gift);
        session.flush();
    }

    public List<Gift> getAllGifts() {
        Session session = sessionFactory.getCurrentSession();

        String hql = "from Gift";
        List<Gift> gifts = session.createQuery(hql).list();

        return gifts;
    }

    public void removeGift(Gift gift){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(gift);
        session.flush();
    }

    public void updateGift(Gift gift){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(gift);
        session.flush();
    }

    public Gift findGiftById(int giftID){
        Session session = this.sessionFactory.getCurrentSession();

        Gift gift = (Gift)session.get(Gift.class, giftID);
        return gift;
    }

    public List<Gift> findGiftByType(String type){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Gift where giftType = '" + type +"'";
        List<Gift> giftList = session.createQuery(hql).list();

        return giftList;
    }

    public List<Gift> findGiftByOrderId(String orderId){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Gift where orderID = '" + orderId + "'";

        List<Gift> giftList = session.createQuery(hql).list();

        return giftList;
    }
}
