package jm.task.jdbc;

import jm.task.jdbc.model.User;
import jm.task.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User us1 = new User("Domian", "Alyakna", (byte) 23);
        User us2 = new User("Ax", "Leve", (byte) 34);
        User us3 = new User("Aduard", "Leve", (byte) 20);
        User us4 = new User("Alissi", "Leve", (byte) 25);
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser(us1.getName(), us1.getLastName(), us1.getAge());
        userService.saveUser(us2.getName(), us2.getLastName(), us2.getAge());
        userService.saveUser(us3.getName(), us3.getLastName(), us3.getAge());
        userService.saveUser(us4.getName(), us4.getLastName(), us4.getAge());
        List<User> list = userService.getAllUsers();
        list.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}