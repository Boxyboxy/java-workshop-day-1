package workshopd1;

import java.util.*;
import java.io.*;

public class Cart {
  List<String> shoppingCart = new ArrayList<String>();
  HashSet<String> set = new HashSet();

  public String listCart() {
    if (this.shoppingCart.isEmpty()) {
      return "Your cart is empty";
    } else {
      for (int i = 0; i < this.shoppingCart.size(); i++) {
        System.out.println(i + 1 + ". " + shoppingCart.get(i));
      }
      return " ";
    }
  }

  public String addToCart(String item) {
    if (this.set.contains(item)) {
      return "You have" + item + " in your cart";
    } else {
      this.set.add(item);
      this.shoppingCart.add(item);
      return item + " added to cart";
    }
  }

  public String removeFromCart(int i) {
    String item = this.shoppingCart.get(i - 1);
    if (this.set.contains(item)) {
      this.shoppingCart.remove(item);
      this.set.remove(item);
      return item + " removed from cart";
    } else {
      return "Incorrect item index";
    }
  }

  public static void main(String[] args) {
    Cart cart = new Cart();
    Console cons = System.console();

    // System.out.println(sc.next());
    boolean running = true;
    while (running) {
      System.out.print("Please enter a line >>");
      Scanner sc = new Scanner(cons.readLine());
      String cmd = sc.next();
      if (cmd.equals("list")) {
        String message = cart.listCart();
        System.out.println(message);
        // if cart is empty, print appropriate message
        // list the contents of your cart
        // contents of cart should be numbered when you are listing them
      } else if (cmd.equals("add")) {
        sc.useDelimiter(",");
        while (sc.hasNext()) {
          String message1 = cart.addToCart(sc.next());
          System.out.println(message1);
        }

        // add one or more items to the cart. Multiple items are separated by comma
        // if item is in cart, print appropriate message
      } else if (cmd.equals("delete")) {
        String message4 = cart.removeFromCart(sc.nextInt());
        System.out.println(message4);
        // // delete an item from the cart based on item's index
      } else if (cmd.equals("checkout")) {
        running = false;
      }
      // else {
      // System.out.println("Please enter a valid input.");
      // }
    }
  }
}
