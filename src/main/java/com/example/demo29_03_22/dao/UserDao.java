package com.example.demo29_03_22.dao;

import com.example.demo29_03_22.exception.DaoException;

public interface UserDao {
    boolean authenticate(String login, String password) throws DaoException;
}
