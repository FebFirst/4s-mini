package CarSaleManagerSystem.Bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by HFQ on 2016/8/20.
 */
public class CarPlan {
    private int planID;
    private String carColor;
    private String carSfx;
    private String garage;

    private String brand;

    private int number;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date predictedTime;//订货

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date purchasedTime;//在途

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inGarageTime;//在库

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date outGarageTime;//出库

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date submitTime;//交车

    private float discount;
    private float defaultPrice;
    private String valid;



    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
