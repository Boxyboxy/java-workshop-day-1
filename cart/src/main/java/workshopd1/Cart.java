package workshopd1;

import java.util.*;
import java.io.*;

public class Cart {

  ArrayList<String> shoppingCart = new ArrayList<String>();

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
    if (this.shoppingCart.contains(item)) {
      return "You have " + item + " in your cart";
    } else {
      this.shoppingCart.add(item);
      return item + " added to cart";
    }
  }

  public void removeFromCart(int i) {
    if (i <= 0 || i > this.shoppingCart.size()) {
      System.out.println("Incorrect item index");
    } else {
      String item = this.shoppingCart.get(i - 1);
      this.shoppingCart.remove(item);
      System.out.println(item + " removed from cart");
    }
  }

  public static void main(String[] args) {
    System.out.println("Please use only the following commands: ");
    System.out.println(" add <item>");
    System.out.println(" delete <position of item>");
    System.out.println(" list");
    System.out.println(" checkout");
    System.out.println("Welcome to your shopping cart");

    Cart cart = new Cart();
    Console cons = System.console();

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
          String message1 = cart.addToCart(sc.next().trim());
          System.out.println(message1);
        }

        // add one or more items to the cart. Multiple items are separated by comma
        // if item is in cart, print appropriate message
      } else if (cmd.equals("delete")) {
        if (!sc.hasNextInt()) {
          System.out.println("Please use delete with an integer, i.e.:");
          System.out.println(" delete <position of item>");
        } else {
          cart.removeFromCart(sc.nextInt());
        }
        // // delete an item from the cart based on item's index
      } else if (cmd.equals("checkout")) {
        running = false;
      } else {
        System.out.println("Please enter a valid input.");
      }
    }

  }

}

/*
 * public Optional<Item> getItem(int i){
 * if (i is out of range){
 * return Optional.isempty();
 * 
 * }
 * Item item = ...
 * return Optional.of(item);
 * }
 * 
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/
 * Optional.html
 */

/*
 * console works on terminal
 * scanner more flexible.
 * 
 * In general, use scanner over console unless you are doing console
 * programming.
 * console can pass the line to scanner.
 */

/*
 * Your code must be testable, all about functionality. E.g. if all logic and
 * code is in one class, you canno test it.
 */