package CarSaleManagerSystem.Bean;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by HFQ on 2016/8/5.
 */
public class OrderList {
    private Date data;
    private ArrayList<Order> orders;
    private String status;  // is valid?

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
