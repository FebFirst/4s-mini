package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HFQ on 2016/8/5.
 */
@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public List<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();

        /** to be implemented*/
        String hql = "from User";
        List<User> users = session.createQuery(hql).list();
        return users;
    }

    public void removeUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void updateUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User findUserById(int userID){
        Session session = this.sessionFactory.getCurrentSession();
        User user = null;
        user = (User)session.get(User.class, userID);
        return user;
    }

    public User findUserByUsername(String username){
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from User where username = ?";
        Query query = session.createQuery(hql);
        query.setString(0,username);
        User user = null;
        List<User> result = query.list();
        if(result.size() == 0){
            return null;
        }
        user = result.get(0);
        return user;
    }
}
