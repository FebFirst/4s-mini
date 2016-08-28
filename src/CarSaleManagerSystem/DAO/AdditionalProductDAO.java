package CarSaleManagerSystem.DAO;


import CarSaleManagerSystem.Bean.AdditionalProduct;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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


    public List<AdditionalProduct> additionalProductTypeFilter(List<AdditionalProduct> additionalProductList, String type){
        if(additionalProductList == null){
            return null;
        }

        List<AdditionalProduct> additionalProducts = new ArrayList<>();

        for(int i = 0; i < additionalProductList.size(); i++){
            if(additionalProductList.get(i).getAdditionalProductType().equals("type"));
            additionalProducts.add(additionalProductList.get(i));
        }

        return additionalProducts;
    }

    public void updateAdditionalProductByJSON(String data){
        JSONArray ja ;
        JSONObject jo;

        ja = JSONArray.fromObject(data);
        for(int i = 0; i<ja.size(); i++){
            jo = ja.getJSONObject(i);
            int id = jo.getInt("key");
            float value = Float.parseFloat(jo.getString("value"));
            AdditionalProduct additionalProduct = findAdditionalProductById(id);
            additionalProduct.setActualGetMoney(value);
            updateAdditionalProduct(additionalProduct);
        }

    }
}
