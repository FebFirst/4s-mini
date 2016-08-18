package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.DAO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HFQ on 2016/8/5.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JobDAO jobDAO;

    @Autowired
    private ApartmentDAO apartmentDAO;

    @Autowired
    private JobStatusDAO jobStatusDAO;

    @Autowired
    private LeverDAO leverDAO;

    public void createUser(User user){
        if(userExist(user.getUserID())){
            return;
        }
        if(userDAO.findUserById(user.getUserID()) != null){
            user.setValid("Y");
            userDAO.updateUser(user);
            return;
        }
        user.setValid("Y");
        userDAO.createUser(user);
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public void removeUser(User user){
        userDAO.removeUser(user);
    }

    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public User findUserById(int userID){
        return userDAO.findUserById(userID);
    }

    public boolean userExist(int userID){
        User user = userDAO.findUserById(userID);
        if(user == null){
            return false;
        }
        if(user.getValid().equals("N")){
            return false;
        }
        return true;
    }
    public int login(User user){
        User usr = userDAO.findUserByUsername(user.getUsername());
        if(user.getUsername().equals(usr.getUsername()) && user.getPassword().equals(usr.getPassword()))
        {
            return usr.getUserID();
        }
        return -1;
    }


    /*
    * Job Service
     */

    public List<Job> getAllJobs(){
        return jobDAO.getAllJobs();
    }

    /*
    * JobStatus Service
     */

    public List<JobStatus> getAllJobStatus(){
        return jobStatusDAO.getAllJobStatuses();
    }
    /*
    *Apartment Service
     */

    public List<Apartment> getAllApartment(){
        return apartmentDAO.getAllApartments();
    }

    /*
    *Level service
     */

    public List<Level> getAllLevels(){
        return leverDAO.getAllLevels();
    }
}
