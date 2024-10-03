package jm.task.jdbc.dao;

import jm.task.jdbc.model.User;
import jm.task.jdbc.util.Util;
import org.hibernate.*;

import javax.persistence.Query;
import java.util.*;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users_1 " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";

        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Error creating users table");
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users_1";

        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Таблица не удалена!");
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Юзер не сохранился");
        }
        System.out.println("User с именем — " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(session.get(User.class, id));
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("User не удалена!");
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

        @Override
        public void cleanUsersTable () {
            try (Session session = Util.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();
                session.createQuery("delete from User").executeUpdate();
                tx.commit();
            } catch (HibernateException e) {
                System.out.println("Не очищена таблица");
            }
        }
    }