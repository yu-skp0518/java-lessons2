package com.dotinstall.myapp.model;

public class User {
  protected String name;

  public User(String name) {
    this.name = name;
  }

  // コンストラクタ
  public User() {
    // this.name = "Me!";
    this("Me!");
  }

  public void sayHi() {
    System.out.println("Hi! " + this.name);
  }

}