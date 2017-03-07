package by.masarnovsky.dao;

import by.masarnovsky.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public List<User> listUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from users").list();
        return userList;
    }

    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));
        return u;
    }

    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));
        if (u != null){
            session.delete(u);
        }
    }
}
