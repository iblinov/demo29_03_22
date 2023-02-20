package com.example.demo29_03_22.dao.mapper;

import com.example.demo29_03_22.entity.Item;

import java.sql.ResultSet;
import java.util.Optional;

public non-sealed class ItemMapper implements Mapper<Item> {
    @Override
    public Optional<Item> map(ResultSet resultSet) {
        return Optional.empty();
    }
}
