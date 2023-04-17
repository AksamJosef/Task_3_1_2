package study.nigmat.boot.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.nigmat.boot.springboot.dao.UserDao;
import study.nigmat.boot.springboot.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);

    }

    @Transactional
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }


    @Transactional
    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }


    @Transactional
    @Override
    public void update(int id, User user) {

        User userToUpdate = userDao.getById(id);

        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setSalary(user.getSalary());

        userDao.update(userToUpdate);
    }


    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getById(id);
    }
}
