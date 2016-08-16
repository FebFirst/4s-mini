package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/5.
 */
public class User {
    protected int userID;
    protected String username;
    protected String password;
    protected String type;

    private String valid;

//    protected Set<Role> roleSet = new HashSet<Role>();
//    protected Set<Order>orderSet = new HashSet<Order>();

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Set<Role> getRoleSet() {
//        return roleSet;
//    }
//
//    public void setRoleSet(Set<Role> roleSet) {
//        this.roleSet = roleSet;
//    }
//
//    public Set<Order> getOrderSet() {
//        return orderSet;
//    }
//
//    public void setOrderSet(Set<Order> orderSet) {
//        this.orderSet = orderSet;
//    }
}
