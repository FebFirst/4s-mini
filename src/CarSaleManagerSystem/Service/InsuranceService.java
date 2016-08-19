package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.Insurance;
import CarSaleManagerSystem.Bean.InsuranceType;
import CarSaleManagerSystem.DAO.InsuranceDAO;
import CarSaleManagerSystem.DAO.InsuranceTypeDAO;
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
public class InsuranceService {
    @Autowired
    private InsuranceDAO insuranceDAO;

    @Autowired
    private InsuranceTypeDAO insuranceTypeDAO;

    public void createInsurance(Insurance insurance){
        if(insuranceExist(insurance.getInsuranceID())){
            return;
        }
        if(insuranceDAO.findInsuranceById(insurance.getInsuranceID()) != null){
            insurance.setValid("Y");
            insuranceDAO.updateInsurance(insurance);
            return;
        }
        insurance.setValid("Y");
        insuranceDAO.createInsurance(insurance);
    }

    public List<Insurance> getAllInsurance(){
        return insuranceDAO.getAllInsurances();
    }

    public void removeInsurance(Insurance insurance){
        if(insuranceExist(insurance.getInsuranceID())){
            insurance.setValid("N");
            insuranceDAO.updateInsurance(insurance);
        }
//        insuranceDAO.removeInsurance(insurance);
    }

    public void updateInsurance(Insurance insurance){insuranceDAO.updateInsurance(insurance);}

    public Insurance findInsuranceById(int insuranceID){return insuranceDAO.findInsuranceById(insuranceID);}

    public void createInsuranceType(InsuranceType insuranceType){
        if(insuranceTypeExist(insuranceType.getType())){
            return;
        }
        if(insuranceTypeDAO.findInsuranceTypeById(insuranceType.getType()) != null){
            insuranceType.setValid("Y");
            insuranceTypeDAO.updateInsuranceType(insuranceType);
            return;
        }
        insuranceType.setValid("Y");
        insuranceTypeDAO.createInsuranceType(insuranceType);
    }

    public List<InsuranceType> getAllInsuranceType(){
        return insuranceTypeDAO.getAllInsuranceTypes();
    }

    public boolean insuranceExist(int insuranceID){
        Insurance insurance = insuranceDAO.findInsuranceById(insuranceID);
        if(insurance == null){
            return false;
        }
        if(insurance.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public boolean insuranceTypeExist(String type){
        InsuranceType insuranceType = insuranceTypeDAO.findInsuranceTypeById(type);
        if(insuranceType == null){
            return false;
        }
        if(insuranceType.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public List<Insurance> findInsuranceByType(String type){
        return insuranceDAO.findInsuranceByType(type);
    }


    public List<Insurance> insuranceTypeNameFilter(String type, String name){
        List<Insurance> insuranceList = findInsuranceByType(type);

        List<Insurance> result = new ArrayList<>();

       for(Insurance insurance : insuranceList){
           if(insurance.getOrderID() == null) {
               if(insurance.getValid().equals("Y")) {
                   if (insurance.getName().equals(name)) {
                       result.add(insurance);
                   }
               }
           }
       }

       return result;
    }

    public List<Insurance> findInsuranceByOrderId(String orderID){
        List<Insurance> insuranceList = getAllInsurance();
        List<Insurance> result = new ArrayList<>();

        for(Insurance insurance : insuranceList){
            if(insurance.getOrderID().equals(orderID)){
                result.add(insurance);
            }
        }

        return result;
    }
}
