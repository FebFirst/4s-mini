package CarSaleManagerSystem.Bean;

import java.io.Serializable;

/**
 * Created by HFQ on 2016/8/17.
 */
public class GiftBrand implements Serializable{
    private String giftBrand;
    private String type;
    private String valid;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGiftBrand() {
        return giftBrand;
    }

    public void setGiftBrand(String giftBrand) {
        this.giftBrand = giftBrand;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GiftBrand)) return false;

        GiftBrand giftBrand1 = (GiftBrand) o;

        if (!giftBrand.equals(giftBrand1.giftBrand)) return false;
        return type.equals(giftBrand1.type);

    }

    @Override
    public int hashCode() {
        int result = giftBrand.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
