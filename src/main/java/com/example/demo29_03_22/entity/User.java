package com.example.demo29_03_22.entity;

public non-sealed class User extends AbstractEntity{
  private String lastname;

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @Override
  public String toString() {
    return "User{" +
            "lastname='" + lastname + '\'' +
            "} " + super.toString();
  }
}
