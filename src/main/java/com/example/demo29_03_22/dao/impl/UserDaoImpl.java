package com.example.demo29_03_22.dao.impl;

import com.example.demo29_03_22.dao.BaseDao;
import com.example.demo29_03_22.dao.UserDao;
import com.example.demo29_03_22.entity.User;
import com.example.demo29_03_22.exception.DaoException;
import com.example.demo29_03_22.pool.ConnectionPool;
import com.example.demo29_03_22.pool.ProxyConnection;

import java.sql.*;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

  private static final String SELECT_LOGIN_PASSWORD = "SELECT password FROM users WHERE lastname = ?";
  private static UserDaoImpl instance = new UserDaoImpl();

  private UserDaoImpl() {
  }

  public static UserDaoImpl getInstance() {
    return instance;
  }

  @Override
  public boolean insert(User user) {
    return false;
  }

  @Override
  public boolean delete(User user) {
    throw new UnsupportedOperationException("delete unsupported");
  }

  @Override
  public List<User> findAll() {
    return null;
  }

  @Override
  public User update(User user) {
    return null;
  }


  @Override
  public boolean authenticate(String login, String password) throws DaoException {
    var match = false;

    try (var connection = ConnectionPool.getInstance().getConnection();
         var statement = connection.prepareStatement(SELECT_LOGIN_PASSWORD)) {
      statement.setString(1, login);
      try (var resultSet = statement.executeQuery()) {
        String passFromDb;
        if (resultSet.next()) {
          passFromDb = resultSet.getString(1);
          match = password.equals(passFromDb);
        }
      }
    } catch (SQLException e) {
      throw new DaoException(e);
    }
    return match;
  }
}
