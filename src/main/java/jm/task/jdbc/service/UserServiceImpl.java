package jm.task.jdbc.service;

import jm.task.jdbc.dao.UserDaoHibernateImpl;
import jm.task.jdbc.dao.UserDaoJDBCImpl;
import jm.task.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoHibernateImpl userdao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userdao.createUsersTable();
    }

    public void dropUsersTable() {
        userdao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userdao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userdao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userdao.getAllUsers();
    }

    public void cleanUsersTable() {
        userdao.cleanUsersTable();
    }
}