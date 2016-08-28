package CarSaleManagerSystem.Bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/11.
 */
public class CarSFX implements Serializable{
    private String garage;
    private String brand;
    private String sfx;
    private String valid;
//    private Set<CarType> carTypeSet = new HashSet<>();


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

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getSfx() {
        return sfx;
    }

    public void setSfx(String sfx) {
        this.sfx = sfx;
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
        if (!(o instanceof CarSFX)) return false;

        CarSFX carSFX = (CarSFX) o;

        if (!garage.equals(carSFX.garage)) return false;
        if (!brand.equals(carSFX.brand)) return false;
        return sfx.equals(carSFX.sfx);

    }

    @Override
    public int hashCode() {
        int result = garage.hashCode();
        result = 31 * result + brand.hashCode();
        result = 31 * result + sfx.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return sfx;
    }
}
