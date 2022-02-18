class User {
  String name;

  User(String name) {
    this.name = name;
  }

  // コンストラクタ
  User() {
    // this.name = "Me!";
    this("Me!");
  }

  void sayHi() {
    System.out.println("Hi! " + this.name);
  }

}

class AdminUser extends User {
  AdminUser(String name) {
    super(name);
  }

  @Override
  void sayHi() {
    System.out.println("[Admin]Hi! " + this.name);
  }

  void sayHello() {
    System.out.println("Hello! " + this.name);
  }

}

public class MyApp {
  public static void main(String[] args) {

    User tom = new User("Tom");
    System.out.println(tom.name);
    tom.sayHi();


    AdminUser Bob = new AdminUser("Bob");
    System.out.println(Bob.name);
    Bob.sayHi();
    Bob.sayHello();

  }
}