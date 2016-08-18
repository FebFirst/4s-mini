package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.JobStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by googo on 16/8/18.
 */
@Repository
public class JobStatusDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void createJobStatus(JobStatus jobStatus){
        Session session = this.sessionFactory.getCurrentSession();

        session.save(jobStatus);
        session.flush();
    }

    public List<JobStatus> getAllJobStatuses(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from JobStatus";
        List<JobStatus> jobStatuses = session.createQuery(hql).list();

        return jobStatuses;
    }

    public void removeJobStatus(JobStatus jobStatus){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(jobStatus);
        session.flush();
    }

    public void updateJobStatus(JobStatus jobStatus){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(jobStatus);
        session.flush();
    }

    public JobStatus findJobStatusById(String jobStatus){
        Session session = this.sessionFactory.getCurrentSession();

        JobStatus result = (JobStatus)session.get(JobStatus.class, jobStatus);
        return result;
    }
}
