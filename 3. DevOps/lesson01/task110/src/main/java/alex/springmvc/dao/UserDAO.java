package alex.springmvc.dao;

import java.util.List;

import alex.springmvc.entity.User;

public interface UserDAO {

    public List <User> getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
