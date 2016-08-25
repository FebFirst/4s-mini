package CarSaleManagerSystem.Bean;

import java.io.Serializable;

/**
 * Created by HFQ on 2016/8/10.
 */
public class CarBrand implements Serializable{
    private String garage;
    private String brand;
    private String valid;
//    private Set<CarType> carTypeSet = new HashSet<>();


    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    public Set<CarType> getCarTypeSet() {
//        return carTypeSet;
//    }
//
//    public void setCarTypeSet(Set<CarType> carTypeSet) {
//        this.carTypeSet = carTypeSet;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarBrand)) return false;

        CarBrand carBrand = (CarBrand) o;

        if (!garage.equals(carBrand.garage)) return false;
        return brand.equals(carBrand.brand);

    }

    @Override
    public int hashCode() {
        int result = garage.hashCode();
        result = 31 * result + brand.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return brand;
    }
}
