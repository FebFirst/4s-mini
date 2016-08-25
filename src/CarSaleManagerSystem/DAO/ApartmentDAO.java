package CarSaleManagerSystem.DAO;


import CarSaleManagerSystem.Bean.Apartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by googo on 16/8/18.
 */
@Repository
public class ApartmentDAO{
    @Autowired
    private  SessionFactory sessionFactory;

    public void createApartment(Apartment apartment){
        Session session = this.sessionFactory.getCurrentSession();

        session.save(apartment);
        session.flush();
    }

    public List<Apartment> getAllApartments(){
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Apartment";
        List<Apartment> apartments = session.createQuery(hql).list();
        return apartments;
    }

    public void removeApartment(Apartment apartment){
        Session session = this.sessionFactory.getCurrentSession();

        session.delete(apartment);
        session.flush();
    }


    public void updateApartment(Apartment apartment){
        Session session = this.sessionFactory.getCurrentSession();

        session.update(apartment);
        session.flush();
    }

    public Apartment findApartmentById(String apartment){
        Session session = this.sessionFactory.getCurrentSession();

        Apartment result = (Apartment)session.get(Apartment.class, apartment);
        return result;
    }
}