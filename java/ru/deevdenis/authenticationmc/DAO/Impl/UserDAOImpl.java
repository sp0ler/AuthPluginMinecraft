package ru.deevdenis.authenticationmc.DAO.Impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.deevdenis.authenticationmc.Configuration.HibernateUtil;
import ru.deevdenis.authenticationmc.DAO.UserDAO;
import ru.deevdenis.authenticationmc.Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Transaction transaction = null;

    @Override
    public void save(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User where name = :name");
            query.setParameter("name", name);
            List<User> list = query.list();
            transaction.commit();

            return list;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return new ArrayList<User>();
    }
}
