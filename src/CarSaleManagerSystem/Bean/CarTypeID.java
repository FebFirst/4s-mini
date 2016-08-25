package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/12.
 */
public class CarTypeID {
    private String garage;
    private String brand;
    private String sfx;
    private String color;

    public CarTypeID(String garage, String brand, String sfx, String color) {
        this.garage = garage;
        this.brand = brand;
        this.sfx = sfx;
        this.color = color;
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

    public String getSfx() {
        return sfx;
    }

    public void setSfx(String sfx) {
        this.sfx = sfx;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
