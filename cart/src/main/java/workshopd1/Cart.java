package workshopd1;

import java.util.*;
import java.io.*;

public class Cart {
  List<String> shoppingCart = new ArrayList<String>();
  HashSet<String> set = new HashSet();

  public void listCart() {
    if (this.shoppingCart.isEmpty()) {
      System.out.println("Your cart is empty");

    } else {
      for (int i = 0; i < this.shoppingCart.size(); i++) {
        System.out.println(i + 1 + ". " + shoppingCart.get(i));
      }

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

  public void removeFromCart(int i) {
    if (i <= 0 || i > this.set.size()) {
      System.out.println("Incorrect item index");
    } else {
      String item = this.shoppingCart.get(i - 1);
      this.shoppingCart.remove(item);
      this.set.remove(item);
      System.out.println(item + " removed from cart");
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
        cart.listCart();

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
        cart.removeFromCart(sc.nextInt());

        // // delete an item from the cart based on item's index
      } else if (cmd.equals("checkout")) {
        running = false;
      } else {
        System.out.println("Please enter a valid input.");
      }
    }
  }
}
