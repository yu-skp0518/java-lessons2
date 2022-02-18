public class MyApp {
  public static void main(String[] args) {

  int[] sales = {700, 400, 500};



    // for (int i = 0; i < sales.length; i++) {
    //   System.out.println(sales[i]);
    // }

    for (int sale : sales) {
      System.out.println(sale);
    }

  }
}