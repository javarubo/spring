package am.basic.web.repository;

import am.basic.web.model.User;
import am.basic.web.util.HibernateUtil;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;


@Repository
@Scope("singleton")
public class UserrepositoryImpl implements UserRepository {

    @PostConstruct
    public void init() {
        System.out.println("Userepositoryimpl");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Userepositoryimpl");
    }


    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(isolation = Isolation.DEFAULT)
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

    }

    @Transactional(rollbackFor = Throwable.class,noRollbackFor = IndexOutOfBoundsException.class,readOnly = true)

    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);


    }

    @Override
    public void delete(long id) throws SQLException {

    }

    @Override
    public User getByUsernameAndPassword(String username, String password) throws SQLException {
        return null;
    }

    @Transactional
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);


    }

//    public User getByUsernameAndPassword(String username, String password) throws SQLException {
//
//
//        return user;
//    }

    public User getByUsername(String username) {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery("SELECT * FROM user WHERE username = ?", User.class);
        query.setParameter(1, username);
        return query.uniqueResult();


    }

    public User getbyId(long id) {
        Session session = sessionFactory.openSession();
        return session.get(User.class, id);
    }


}
