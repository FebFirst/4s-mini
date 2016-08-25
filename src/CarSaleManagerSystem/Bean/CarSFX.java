package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/11.
 */
public class CarSFX {
    private String sfx;
    private String valid;
//    private Set<CarType> carTypeSet = new HashSet<>();

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

        return sfx.equals(carSFX.sfx);

    }

    @Override
    public int hashCode() {
        return sfx.hashCode();
    }

    @Override
    public String toString() {
        return sfx;
    }
}
