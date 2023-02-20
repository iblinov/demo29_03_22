package com.example.demo29_03_22.dao.mapper;

import com.example.demo29_03_22.entity.User;

import java.sql.ResultSet;
import java.util.Optional;

public final class UserMapper implements Mapper<User> {
    @Override
    public Optional<User> map(ResultSet resultSet) {

        return Optional.empty();
    }

}
