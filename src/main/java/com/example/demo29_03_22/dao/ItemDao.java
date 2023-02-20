package com.example.demo29_03_22.dao;

public interface ItemDao {

}

class Bar extends Foo { //1
  public static void main(String args[]) {
    Integer i = Integer.parseInt("10");
    if (i.toString() == i.toString()) System.out.println("Equal");
    else System.out.println("Not Equal");
  }
}

class Foo { //3
  int sum(int x, int y) {
    return x + y;
  }
}




