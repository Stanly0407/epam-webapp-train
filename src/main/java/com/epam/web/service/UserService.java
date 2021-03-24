package com.epam.web.service;

import com.epam.web.entities.User;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> login(String email, String password) throws ServiceException {
      //  return "admin".equals(username) && "admin".equals(login) ? Optional.of(new User("Svetlana")) : Optional.empty();
try{
    return userDao.findUserByEmailAndPassword(email, password);
} catch (DaoException | SQLException e) {
  throw new ServiceException((DaoException) e);
}

    }

}
