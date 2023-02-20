package com.example.demo29_03_22.dao.mapper;

import com.example.demo29_03_22.entity.AbstractEntity;

import java.sql.ResultSet;
import java.util.Optional;

public sealed interface Mapper<T extends AbstractEntity> permits SubMapper, UserMapper, ItemMapper {
    Optional<T> map(ResultSet resultSet);
}
