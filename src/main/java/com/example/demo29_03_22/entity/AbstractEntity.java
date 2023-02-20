package com.example.demo29_03_22.entity;

public sealed class AbstractEntity permits User, Item {
    private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "AbstractEntity{" +
            "id=" + id +
            '}';
  }
}
