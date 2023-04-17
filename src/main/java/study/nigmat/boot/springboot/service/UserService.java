package study.nigmat.boot.springboot.service;


import study.nigmat.boot.springboot.model.User;

import java.util.List;

public interface UserService {

    void add (User user);

    List<User> getUserList();

    void delete (int id);

    void update (int id, User user);

    User getUserById(int id);
}
