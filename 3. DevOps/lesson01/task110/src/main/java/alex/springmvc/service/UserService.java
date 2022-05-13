package alex.springmvc.service;
import java.util.List;

import alex.springmvc.entity.User;

public interface UserService {

    public List <User> getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

}
