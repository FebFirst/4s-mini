package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/11.
 */
public class InsuranceType {
    private String type;
    private String valid;


//    private Set<Insurance> insuranceSet = new HashSet<>();

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Set<Insurance> getInsuranceSet() {
//        return insuranceSet;
//    }
//
//    public void setInsuranceSet(Set<Insurance> insuranceSet) {
//        this.insuranceSet = insuranceSet;
//    }
}
