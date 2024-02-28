package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void add(User user);

    List<User> showUser(String model, int series);
}
