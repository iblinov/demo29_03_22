package com.example.demo29_03_22.service;

import com.example.demo29_03_22.exception.ServiceException;

public interface UserService {
     boolean authenticate(String login, String password) throws ServiceException;
}
