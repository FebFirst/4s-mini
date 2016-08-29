package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.AdditionalProduct;
import CarSaleManagerSystem.Bean.AdditionalProductType;
import CarSaleManagerSystem.Bean.Order;
import CarSaleManagerSystem.DAO.AdditionalProductDAO;
import CarSaleManagerSystem.DAO.AdditionalProductTypeDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.asm.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by googo on 16/8/14.
 */
@Service
@Transactional
public class AdditionalProductService {
    @Autowired
    private AdditionalProductDAO additionalProductDAO;

    @Autowired
    private AdditionalProductTypeDAO additionalProductTypeDAO;
    /*
    *additionalProduct Service
    */
    public boolean additionalProductExist(int additionalProductId){
        AdditionalProduct additionalProduct = additionalProductDAO.findAdditionalProductById(additionalProductId);

        if(additionalProduct == null){
            return false;
        }else if(additionalProduct.getValid().equals("N")){
            return false;
        }
        return true;
    }


    public void createAdditionalProduct(AdditionalProduct additionalProduct){
        if(additionalProductExist(additionalProduct.getAdditionalProductID())){
            return;
        }
        if(additionalProductDAO.findAdditionalProductById(additionalProduct.getAdditionalProductID()) != null){
            additionalProduct.setValid("Y");
            additionalProductDAO.updateAdditionalProduct(additionalProduct);
            return;
        }
        additionalProduct.setValid("Y");
        additionalProductDAO.createAdditionalProduct(additionalProduct);
    }


    public List<AdditionalProduct> getAllAdditionalProducts() {
        return additionalProductDAO.getAllAdditionalProduct();
    }

    public void removeAdditionalProduct(AdditionalProduct additionalProduct){
        if(additionalProductExist(additionalProduct.getAdditionalProductID())){
            additionalProduct.setValid("N");
            additionalProductDAO.updateAdditionalProduct(additionalProduct);
        }
    }

    public void updateAdditionalProduct(AdditionalProduct additionalProduct){
        additionalProductDAO.updateAdditionalProduct(additionalProduct);
    }

    public AdditionalProduct findAdditionalProductById(int id){
        return additionalProductDAO.findAdditionalProductById(id);
    }


    public List<AdditionalProduct> additionalProductTypeFilter(List<AdditionalProduct> additionalProducts, String type){
        return additionalProductDAO.additionalProductTypeFilter(additionalProducts,type);
    }


/*
*additionalProductType Service
 */
    public boolean additionalProductTypeExist(String type){
        AdditionalProductType additionalProductType = additionalProductTypeDAO.findAdditionalProductTypeById(type);

        if(additionalProductType ==null){
            return false;
        }else if(additionalProductType.getValid().equals("N")){
            return false;
        }

        return true;
    }

    public void createAdditionalProductType(AdditionalProductType additionalProductType){
        if(additionalProductTypeExist(additionalProductType.getType())){
            return;
        }
        if(additionalProductTypeDAO.findAdditionalProductTypeById(additionalProductType.getType()) != null){
            additionalProductType.setValid("Y");
            additionalProductTypeDAO.updateAdditonalProductType(additionalProductType);
            return;
        }

        additionalProductType.setValid("Y");
        additionalProductTypeDAO.createAdditionalProductType(additionalProductType);
    }

    public AdditionalProductType findAdditionalProductTypeById(String type){
        return additionalProductTypeDAO.findAdditionalProductTypeById(type);
    }

    public List<AdditionalProductType> getAllAdditionalProductType(){
        return additionalProductTypeDAO.getAllAdditionalProductType();
    }


    public List<AdditionalProduct> findAdditionalProductByOrderId(String orderId){
        List<AdditionalProduct> additionalProducts = getAllAdditionalProducts();

        if(additionalProducts == null){
            return null;
        }
        List<AdditionalProduct> result = new ArrayList<>();

        if(orderId == null){
            return additionalProducts;
        }

        for(AdditionalProduct additionalProduct : additionalProducts){
            if(additionalProduct.getOrderID().equals(orderId)){
                result.add(additionalProduct);
            }
        }

        return result;
    }

    public void updateAdditionalProductByJSON(String data){
        additionalProductDAO.updateAdditionalProductByJSON(data);
    }

}
