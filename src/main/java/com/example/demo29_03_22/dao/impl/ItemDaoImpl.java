package com.example.demo29_03_22.dao.impl;

import com.example.demo29_03_22.dao.BaseDao;
import com.example.demo29_03_22.dao.ItemDao;
import com.example.demo29_03_22.entity.Item;
import com.example.demo29_03_22.exception.DaoException;

import java.util.List;


public class ItemDaoImpl extends BaseDao<Item> implements ItemDao {
    @Override
    public boolean insert(Item item) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Item item) throws DaoException {
        return false;
    }

    @Override
    public List<Item> findAll() throws DaoException {
        return null;
    }

    @Override
    public Item update(Item item) throws DaoException {
        return null;
    }
}
