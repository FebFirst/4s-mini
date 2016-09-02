package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.Gift;
import CarSaleManagerSystem.Bean.GiftBrand;
import CarSaleManagerSystem.Bean.GiftType;
import CarSaleManagerSystem.DAO.GiftBrandDAO;
import CarSaleManagerSystem.DAO.GiftDAO;
import CarSaleManagerSystem.DAO.GiftTypeDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Service
@Transactional
public class GiftService {
    @Autowired
    private GiftDAO giftDAO;

    @Autowired
    private GiftTypeDAO giftTypeDAO;

    @Autowired
    private GiftBrandDAO giftBrandDAO;

    public void createGift(Gift gift){
        if(giftExist(gift.getGiftID())){
            return;
        }
        if(giftDAO.findGiftById(gift.getGiftID()) != null){
            gift.setValid("Y");
            giftDAO.updateGift(gift);
            return;
        }
        gift.setValid("Y");
        giftDAO.createGift(gift);
    }

    public List<Gift> getAllGifts(){
        return giftDAO.getAllGifts();
    }

    public void removeGift(Gift gift){
        if(giftExist(gift.getGiftID())){
            gift.setValid("N");
            giftDAO.updateGift(gift);
        }
//        giftDAO.removeGift(gift);
    }

    public void updateGift(Gift gift){giftDAO.updateGift(gift);}

    public Gift findGiftById(int giftID){return  giftDAO.findGiftById(giftID);}


    public void createGiftType(GiftType giftType){
        if(giftTypeExist(giftType.getType())){
            return;
        }
        if(giftTypeDAO.findGiftTypeById(giftType.getType()) != null){
            giftType.setValid("Y");
            giftTypeDAO.updateGiftType(giftType);
            return;
        }
        giftType.setValid("Y");
        giftTypeDAO.createGiftType(giftType);
    }

    public GiftType findGiftTypeById(String type){
        return giftTypeDAO.findGiftTypeById(type);
    }

    public List<GiftType> getAllGiftTypes(){
        return giftTypeDAO.getAllGiftTypes();
    }


    public void createGiftBrand(GiftBrand giftBrand){
        if(giftBrandExist(giftBrand.getType(),giftBrand.getGiftBrand())){
            return;
        }
        if(giftBrandDAO.findGiftBrandById(giftBrand.getType(),giftBrand.getGiftBrand()) != null){
            giftBrand.setValid("Y");
            giftBrandDAO.updateGiftBrand(giftBrand);
            return;
        }
        giftBrand.setValid("Y");
        giftBrandDAO.createGiftBrand(giftBrand);
    }

    public GiftBrand findGiftBrandById(String type, String brand){
        return giftBrandDAO.findGiftBrandById(type,brand);
    }

    public List<GiftBrand> getAllGiftBrands(){
        return giftBrandDAO.getAllGiftBrands();
    }



    public List<Gift> findGiftByOrderId(String orderId){
        List<Gift> gifts = getAllGifts();
        if(gifts == null){
            return null;
        }
        List<Gift> result = new ArrayList<>();
        if(orderId == null){
            return gifts;
        }
        for(int i = 0;i < gifts.size();i++){
            if(gifts.get(i).getOrderID() != null) {
                if (gifts.get(i).getOrderID().equals(orderId)) {
                    result.add(gifts.get(i));
                }
            }
        }
        return result;
    }

    public boolean giftExist(int giftID){
        Gift gift = giftDAO.findGiftById(giftID);
        if(gift == null){
            return false;
        }
        if(gift.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public boolean giftTypeExist(String giftTypeId){
        GiftType giftType = giftTypeDAO.findGiftTypeById(giftTypeId);
        if(giftType == null){
            return false;
        }
        if(giftType.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public boolean giftBrandExist(String giftType, String giftBrandId){
        GiftBrand giftBrand = giftBrandDAO.findGiftBrandById(giftType,giftBrandId);
        if(giftBrand == null){
            return false;
        }
        if(giftBrand.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public List<Gift> findGiftByType(String type){
        return giftDAO.findGiftByType(type);
    }

    public List<Gift> giftTypeNameFilter(String type, String name){
        List<Gift> giftList = findGiftByType(type);

        List<Gift> result = new ArrayList<>();
       for(Gift gift:giftList){
           if(gift.getOrderID() == null) {
               if (gift.getValid().equals("Y")) {
//                   if (gift.getName().equals(name)) {
                       result.add(gift);
//                   }
               }
           }
       }

       return result;
    }


    public void createGiftListByJSONOrderCreateHelper(String giftList, String orderId){
        JSONArray JAgifts = new JSONArray();
        JAgifts = JSONArray.fromObject(giftList);

        for (int i = 0; i < JAgifts.size(); i++) {
            JSONObject jo = JAgifts.getJSONObject(i);
            String type = jo.getString("type");
            String name = jo.getString("name");
            Gift gift = giftTypeNameFilter(type, name).get(0);
            gift.setOrderID(orderId);
            gift.setValid("N");
            giftDAO.createGift(gift);
        }
    }

    public void updateGiftListByJSONWaitressHelper(String giftList){
        JSONArray ja;
        JSONObject jo;
        ja = JSONArray.fromObject(giftList);
        for(int i = 0; i < ja.size(); i ++){
            jo = ja.getJSONObject(i);
            int giftId = Integer.valueOf(jo.getString("giftId"));
            Gift gift = giftDAO.findGiftById(giftId);
            gift.setActualGetMoney(Float.parseFloat(jo.getString("money")));
            giftDAO.updateGift(gift);
        }
    }

}