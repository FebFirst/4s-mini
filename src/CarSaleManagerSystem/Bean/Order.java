package CarSaleManagerSystem.Bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/5.
 */
public class Order {
    private String orderID;
    private int customerID;
    private int salesmanID;
    private String carID;
//    private Set<Gift> giftSet = new HashSet<>();
//    private Set<Insurance> insuranceSet = new HashSet<>();
//    private Set<AdditionalProduct> additionalProductSet = new HashSet<>();
    private float salePrice;
    private float actualGetMoney;
    private Date date;//create time
    private Date predicted_pay_time;
    private Date actual_pay_time;
    private String finish_status; // is finished?
    private String remark;
//    private String valid;


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getSalesmanID() {
        return salesmanID;
    }

    public void setSalesmanID(int salesmanID) {
        this.salesmanID = salesmanID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getActualGetMoney() {
        return actualGetMoney;
    }

    public void setActualGetMoney(float actualGetMoney) {
        this.actualGetMoney = actualGetMoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPredicted_pay_time() {
        return predicted_pay_time;
    }

    public void setPredicted_pay_time(Date predicted_pay_time) {
        this.predicted_pay_time = predicted_pay_time;
    }

    public Date getActual_pay_time() {
        return actual_pay_time;
    }

    public void setActual_pay_time(Date actual_pay_time) {
        this.actual_pay_time = actual_pay_time;
    }

    public String getFinish_status() {
        return finish_status;
    }

    public void setFinish_status(String finish_status) {
        this.finish_status = finish_status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
