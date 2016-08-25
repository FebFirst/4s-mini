package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/8.
 */
public class CarColor {
    private String color;

    private String valid;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

//    private Set<CarType> carTypeSet = new HashSet<>();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        if (!(o instanceof CarColor)) return false;

        CarColor carColor = (CarColor) o;

        return color.equals(carColor.color);

    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }

    @Override
    public String toString() {
        return color;
    }
}
