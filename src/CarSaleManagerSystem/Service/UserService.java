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
    private LevelDAO levelDAO;

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

    public void createJob(Job job){
        if(jobExist(job.getJob())){
            return;
        }
        if(jobDAO.findJobById(job.getJob()) != null){
            job.setValid("Y");
            jobDAO.updateJob(job);
            return;
        }
        job.setValid("Y");
        jobDAO.createJob(job);
    }

    public List<Job> getAllJobs(){
        return jobDAO.getAllJobs();
    }

    public boolean jobExist(String jobID){
        Job job = jobDAO.findJobById(jobID);
        if(job == null){
            return false;
        }
        if(job.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public void createJobStatus(JobStatus jobStatus){
        if(jobStatusExist(jobStatus.getJobStatus())){
            return;
        }
        if(jobStatusDAO.findJobStatusById(jobStatus.getJobStatus()) != null){
            jobStatus.setValid("Y");
            jobStatusDAO.updateJobStatus(jobStatus);
            return;
        }
        jobStatus.setValid("Y");
        jobStatusDAO.createJobStatus(jobStatus);
    }

    public boolean jobStatusExist(String jobStatusID){
        JobStatus jobStatus = jobStatusDAO.findJobStatusById(jobStatusID);
        if(jobStatus == null){
            return false;
        }
        if(jobStatus.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public List<JobStatus> getAllJobStatus(){
        return jobStatusDAO.getAllJobStatuses();
    }

    public void createApartment(Apartment apartment){
        if(apartmentExist(apartment.getApartment())){
            return;
        }
        if(apartmentDAO.findApartmentById(apartment.getApartment()) != null){
            apartment.setValid("Y");
            apartmentDAO.updateApartment(apartment);
            return;
        }
        apartment.setValid("Y");
        apartmentDAO.createApartment(apartment);
    }

    public boolean apartmentExist(String apartmentID){
        Apartment apartment = apartmentDAO.findApartmentById(apartmentID);
        if(apartment == null){
            return false;
        }
        if(apartment.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public List<Apartment> getAllApartment(){
        return apartmentDAO.getAllApartments();
    }

    public void createLevel(Level level){
        if(levelExist(level.getLevel())){
            return;
        }
        if(levelDAO.findLevelById(level.getLevel()) != null){
            level.setValid("Y");
            levelDAO.updateLevel(level);
            return;
        }
        level.setValid("Y");
        levelDAO.createLevel(level);
    }

    public boolean levelExist(String levelID){
        Level level = levelDAO.findLevelById(levelID);
        if(level == null){
            return false;
        }
        if(level.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public List<Level> getAllLevels(){
        return levelDAO.getAllLevels();
    }


     /**
      *
      *
      * **/
}
