package CarSaleManagerSystem.DAO;


import CarSaleManagerSystem.Bean.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by googo on 16/8/18.
 */
@Repository
public class JobDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void createJob(Job job){
        Session session = this.sessionFactory.getCurrentSession();

        session.save(job);
        session.flush();
    }

    public List<Job> getAllJobs(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Job";
        List<Job> jobs = session.createQuery(hql).list();

        return jobs;
    }

    public void removeJob(Job job){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(job);
        session.flush();
    }

    public void updateJob(Job job){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(job);
        session.flush();
    }

    public Job findJobById(String job){
        Session session = this.sessionFactory.getCurrentSession();

        Job result = (Job)session.get(Job.class, job);
        return result;
    }
}

