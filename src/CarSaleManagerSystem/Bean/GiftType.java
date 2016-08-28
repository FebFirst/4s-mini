package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/11.
 */
public class GiftType {
    private String type;
    private String valid;
//    private Set<Gift> giftSet = new HashSet<>();

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

//    public Set<Gift> getGiftSet() {
//        return giftSet;
//    }
//
//    public void setGiftSet(Set<Gift> giftSet) {
//        this.giftSet = giftSet;
//    }
}
