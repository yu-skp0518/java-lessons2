package com.dotinstall.myapp.model;

public class AdminUser extends User {
  public AdminUser(String name) {
    super(name);
  }

  @Override
  public void sayHi() {
    System.out.println("[Admin]Hi! " + this.name);
  }

  public void sayHello() {
    System.out.println("Hello! " + this.name);
  }

}