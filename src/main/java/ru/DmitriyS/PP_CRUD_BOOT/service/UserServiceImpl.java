package ru.DmitriyS.PP_CRUD_BOOT.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.DmitriyS.PP_CRUD_BOOT.dao.UserDao;
import ru.DmitriyS.PP_CRUD_BOOT.model.User;

import java.util.List;
// Класс сервиса. Внедряем зависимость от UserDao c помощью конструктора. Аннотации @Transactional
// ставим только в методах, где идет по изменению/удалению  значений из БД
@Service
public class UserServiceImpl  implements UserService{
    private UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User userInfo(int id) {
        return userDao.userInfo(id);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

}
