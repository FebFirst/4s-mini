package CarSaleManagerSystem.Bean;

import java.util.Date;

/**
 * Created by HFQ on 2016/8/5.
 */
public class Car {
    private String carID;
    private String garage;
    private String brand;
    private String sfx;
    private String color;
    private String carNumber;
    private float cost;
    private Date predictedTime;//����
    private Date purchasedTime;//��;
    private Date inGarageTime;//�ڿ�
    private Date outGarageTime;//����
    private Date submitTime;//����
    private float price;
    private float discount;
    private String normal;
    private float payback;
    private String stockStatus;
    private String valid;
    private int planID;

    public Car(Car car){
        this.carID = car.carID;
        this.garage = car.garage;
        this.brand = car.brand;
        this.sfx = car.sfx;
        this.color = car.color;
        this.carNumber = car.carNumber;
        this.cost = car.cost;
        this.predictedTime = car.predictedTime;
        this.purchasedTime = car.purchasedTime;
        this.inGarageTime = car.inGarageTime;
        this.outGarageTime = car.outGarageTime;
        this.submitTime = car.submitTime;
        this.price = car.price;
        this.discount = car.discount;
        this.normal = car.normal;
        this.payback = car.payback;
        this.stockStatus = car.stockStatus;
        this.valid = car.valid;
        this.planID = car.planID;
    }

    public Car() {
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public Date getInGarageTime() {
        return inGarageTime;
    }

    public void setInGarageTime(Date inGarageTime) {
        this.inGarageTime = inGarageTime;
    }

    public Date getOutGarageTime() {
        return outGarageTime;
    }

    public void setOutGarageTime(Date outGarageTime) {
        this.outGarageTime = outGarageTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public float getPayback() {
        return payback;
    }

    public void setPayback(float payback) {
        this.payback = payback;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getPredictedTime() {
        return predictedTime;
    }

    public void setPredictedTime(Date predictedTime) {
        this.predictedTime = predictedTime;
    }

    public Date getPurchasedTime() {
        return purchasedTime;
    }

    public void setPurchasedTime(Date purchasedTime) {
        this.purchasedTime = purchasedTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }
}
