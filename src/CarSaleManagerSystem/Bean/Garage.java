package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/5.
 */
public class Garage {
    private String brand;
    private String valid;

//    private Set<Car> carSet = new HashSet<>();

//    private Set<CarBrand> carBrandSet = new HashSet<>();

//    private Set<CarType> carTypeSet = new HashSet<>();

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    public Set<Car> getCarSet() {
//        return carSet;
//    }
//
//    public void setCarSet(Set<Car> carSet) {
//        this.carSet = carSet;
//    }
//
//    public Set<CarType> getCarTypeSet() {
//        return carTypeSet;
//    }
//
//    public void setCarTypeSet(Set<CarType> carTypeSet) {
//        this.carTypeSet = carTypeSet;
//    }
//
//    public Set<CarBrand> getCarBrandSet() {
//        return carBrandSet;
//    }
//
//    public void setCarBrandSet(Set<CarBrand> carBrandSet) {
//        this.carBrandSet = carBrandSet;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garage)) return false;

        Garage garage = (Garage) o;

        return brand.equals(garage.brand);

    }

    @Override
    public int hashCode() {
        return brand.hashCode();
    }

    @Override
    public String toString() {
        return brand;
    }
}
