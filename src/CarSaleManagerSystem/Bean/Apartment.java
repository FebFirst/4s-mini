package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/17.
 */
public class Apartment {
    private String apartment;
    private String valid;

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return apartment;
    }
}
