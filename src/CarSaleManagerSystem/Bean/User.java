package CarSaleManagerSystem.Bean;

import java.util.Date;
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

    protected String apartment;
    protected String job;
    protected String level;
    protected String job_status;
    protected String cellphone;
    protected String gender;
    protected Date birthday;
    protected int bean;
    protected String name;

    private String valid;

//    protected Set<Role> roleSet = new HashSet<Role>();
//    protected Set<Order>orderSet = new HashSet<Order>();


    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJob_status() {
        return job_status;
    }

    public void setJob_status(String job_status) {
        this.job_status = job_status;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getBean() {
        return bean;
    }

    public void setBean(int bean) {
        this.bean = bean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
