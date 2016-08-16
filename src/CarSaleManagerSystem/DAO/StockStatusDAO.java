package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.StockStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/8.
 */
@Repository
public class StockStatusDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createStockStatus(StockStatus stockStatus){
        Session session = sessionFactory.getCurrentSession();
        session.save(stockStatus);
    }

    public List<StockStatus> getAllStockStatus(){
        Session session = sessionFactory.getCurrentSession();

        /** to be implemented*/
        String hql = "from StockStatus";
        List<StockStatus> stockStatusList = session.createQuery(hql).list();
        return stockStatusList;
    }

    public void removeStockStatus(StockStatus stockStatus){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(stockStatus);
    }

    public void updateStockStatus(StockStatus stockStatus){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(stockStatus);
    }

    public StockStatus getStockStatusByID(String stock){
        Session session = sessionFactory.getCurrentSession();
        StockStatus stockStatus = null;
        stockStatus = (StockStatus)session.get(StockStatus.class,stock);
        return stockStatus;
    }
}
