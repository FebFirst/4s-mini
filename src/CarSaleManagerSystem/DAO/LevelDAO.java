package CarSaleManagerSystem.DAO;

import CarSaleManagerSystem.Bean.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by googo on 16/8/18.
 */
@Repository
public class LevelDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void createLevel(Level level){
        Session session = this.sessionFactory.getCurrentSession();

        session.save(level);
        session.flush();
    }

    public List<Level> getAllLevels(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Level";
        List<Level> levels = session.createQuery(hql).list();

        return levels;
    }

    public void removeLevel(Level level){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(level);
        session.flush();
    }

    public void updateLevel(Level level){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(level);
        session.flush();
    }

    public Level findLevelById(String level){
        Session session = this.sessionFactory.getCurrentSession();

        Level result = (Level)session.get(Level.class, level);
        return result;
    }

}
