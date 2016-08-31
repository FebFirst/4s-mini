package CarSaleManagerSystem.Bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by HFQ on 2016/8/28.
 */
public class SalesPlan {
    private int planID;
    private String garage;
    private String brand;
    private String sfx;
    private String color;
    private int number;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planTime; //
    private float carCost;
    private float carPrice;
    private float carDiscount;
    private float carPayback;

    private float exchangeCost;
    private float exchangePrice;
    private float exchangeDiscount;
    private float exchangeSaturate;

    private float giftCost;
    private float giftPrice;
    private float giftDiscount;
    private float giftSaturate;

    private float insuranceCost;
    private float insurancePrice;
    private float insuranceDiscount;
    private float insuranceSaturate;

    private float financeCost;
    private float financePrice;
    private float financeDiscount;
    private float financeSaturate;

    private float serviceCost;
    private float servicePrice;
    private float serviceDiscount;
    private float serviceSaturate;

    private float rebookInsuranceCost;
    private float rebookInsurancePrice;
    private float rebookInsuranceDiscount;
    private float rebookInsuranceSaturate;

    private float vipCost;
    private float vipPrice;
    private float vipDiscount;
    private float vipSaturate;

    private float renderCost;
    private float renderPrice;
    private float renderDiscount;
    private float renderSaturate;

    private String valid;

    public float getCarPayback() {
        return carPayback;
    }

    public void setCarPayback(float carPayback) {
        this.carPayback = carPayback;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    public float getCarCost() {
        return carCost;
    }

    public void setCarCost(float carCost) {
        this.carCost = carCost;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }

    public float getCarDiscount() {
        return carDiscount;
    }

    public void setCarDiscount(float carDiscount) {
        this.carDiscount = carDiscount;
    }

    public float getExchangeCost() {
        return exchangeCost;
    }

    public void setExchangeCost(float exchangeCost) {
        this.exchangeCost = exchangeCost;
    }

    public float getExchangePrice() {
        return exchangePrice;
    }

    public void setExchangePrice(float exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    public float getExchangeDiscount() {
        return exchangeDiscount;
    }

    public void setExchangeDiscount(float exchangeDiscount) {
        this.exchangeDiscount = exchangeDiscount;
    }

    public float getExchangeSaturate() {
        return exchangeSaturate;
    }

    public void setExchangeSaturate(float exchangeSaturate) {
        this.exchangeSaturate = exchangeSaturate;
    }

    public float getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(float giftCost) {
        this.giftCost = giftCost;
    }

    public float getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(float giftPrice) {
        this.giftPrice = giftPrice;
    }

    public float getGiftDiscount() {
        return giftDiscount;
    }

    public void setGiftDiscount(float giftDiscount) {
        this.giftDiscount = giftDiscount;
    }

    public float getGiftSaturate() {
        return giftSaturate;
    }

    public void setGiftSaturate(float giftSaturate) {
        this.giftSaturate = giftSaturate;
    }

    public float getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(float insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public float getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(float insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public float getInsuranceDiscount() {
        return insuranceDiscount;
    }

    public void setInsuranceDiscount(float insuranceDiscount) {
        this.insuranceDiscount = insuranceDiscount;
    }

    public float getInsuranceSaturate() {
        return insuranceSaturate;
    }

    public void setInsuranceSaturate(float insuranceSaturate) {
        this.insuranceSaturate = insuranceSaturate;
    }

    public float getFinanceCost() {
        return financeCost;
    }

    public void setFinanceCost(float financeCost) {
        this.financeCost = financeCost;
    }

    public float getFinancePrice() {
        return financePrice;
    }

    public void setFinancePrice(float financePrice) {
        this.financePrice = financePrice;
    }

    public float getFinanceDiscount() {
        return financeDiscount;
    }

    public void setFinanceDiscount(float financeDiscount) {
        this.financeDiscount = financeDiscount;
    }

    public float getFinanceSaturate() {
        return financeSaturate;
    }

    public void setFinanceSaturate(float financeSaturate) {
        this.financeSaturate = financeSaturate;
    }

    public float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public float getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(float servicePrice) {
        this.servicePrice = servicePrice;
    }

    public float getServiceDiscount() {
        return serviceDiscount;
    }

    public void setServiceDiscount(float serviceDiscount) {
        this.serviceDiscount = serviceDiscount;
    }

    public float getServiceSaturate() {
        return serviceSaturate;
    }

    public void setServiceSaturate(float serviceSaturate) {
        this.serviceSaturate = serviceSaturate;
    }

    public float getRebookInsuranceCost() {
        return rebookInsuranceCost;
    }

    public void setRebookInsuranceCost(float rebookInsuranceCost) {
        this.rebookInsuranceCost = rebookInsuranceCost;
    }

    public float getRebookInsurancePrice() {
        return rebookInsurancePrice;
    }

    public void setRebookInsurancePrice(float rebookInsurancePrice) {
        this.rebookInsurancePrice = rebookInsurancePrice;
    }

    public float getRebookInsuranceDiscount() {
        return rebookInsuranceDiscount;
    }

    public void setRebookInsuranceDiscount(float rebookInsuranceDiscount) {
        this.rebookInsuranceDiscount = rebookInsuranceDiscount;
    }

    public float getRebookInsuranceSaturate() {
        return rebookInsuranceSaturate;
    }

    public void setRebookInsuranceSaturate(float rebookInsuranceSaturate) {
        this.rebookInsuranceSaturate = rebookInsuranceSaturate;
    }

    public float getVipCost() {
        return vipCost;
    }

    public void setVipCost(float vipCost) {
        this.vipCost = vipCost;
    }

    public float getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(float vipPrice) {
        this.vipPrice = vipPrice;
    }

    public float getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(float vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    public float getVipSaturate() {
        return vipSaturate;
    }

    public void setVipSaturate(float vipSaturate) {
        this.vipSaturate = vipSaturate;
    }

    public float getRenderCost() {
        return renderCost;
    }

    public void setRenderCost(float renderCost) {
        this.renderCost = renderCost;
    }

    public float getRenderPrice() {
        return renderPrice;
    }

    public void setRenderPrice(float renderPrice) {
        this.renderPrice = renderPrice;
    }

    public float getRenderDiscount() {
        return renderDiscount;
    }

    public void setRenderDiscount(float renderDiscount) {
        this.renderDiscount = renderDiscount;
    }

    public float getRenderSaturate() {
        return renderSaturate;
    }

    public void setRenderSaturate(float renderSaturate) {
        this.renderSaturate = renderSaturate;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
