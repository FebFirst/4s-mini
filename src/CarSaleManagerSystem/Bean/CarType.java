package CarSaleManagerSystem.Bean;

import java.io.Serializable;

/**
 * Created by HFQ on 2016/8/11.
 */
public class CarType implements Serializable{


//    private CarBrand carBrand = new CarBrand();
    private String carColor;
    private String carSfx;
    private String garage;

    private String brand;
//    private String color;
//    private String sfx;
//    private String garage;

    private int plan;
    private int stock;
    private int order;
    private float price;
    private float cost;
    private float discount;
    private String valid;

    private int requestNumber;

//    private Set<Car> carSet = new HashSet<>();
//    private Set<Gift> giftSet = new HashSet<>();


    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarSfx() {
        return carSfx;
    }

    public void setCarSfx(String carSfx) {
        this.carSfx = carSfx;
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

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
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
        if (!(o instanceof CarType)) return false;

        CarType carType = (CarType) o;

        if (!carColor.equals(carType.carColor)) return false;
        if (!carSfx.equals(carType.carSfx)) return false;
        if (!garage.equals(carType.garage)) return false;
        return brand.equals(carType.brand);

    }

    @Override
    public int hashCode() {
        int result = carColor.hashCode();
        result = 31 * result + carSfx.hashCode();
        result = 31 * result + garage.hashCode();
        result = 31 * result + brand.hashCode();
        return result;
    }
}
