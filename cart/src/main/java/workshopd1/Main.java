package workshopd1;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Please use only the following commands: ");
    System.out.println("  add <item>");
    System.out.println("  delete <position of item>");
    System.out.println("  list");
    System.out.println("  checkout");
    System.out.println("Welcome to your shopping cart");

    Cart cart = new Cart();
    // option 1
    // Console cons = System.console();

    Scanner sc = new Scanner(System.in);
    String cmd = sc.next().trim();
    String selected = sc.nextLine().trim();

    boolean running = true;
    while (running) {
      // option 1
      // System.out.print("Please enter a line >>");
      // Scanner sc = new Scanner(cons.readLine());
      // String cmd = sc.next();

      if (cmd.equals("list")) {
        cart.listCart();

        // if cart is empty, print appropriate message
        // list the contents of your cart
        // contents of cart should be numbered when you are listing them
      } else if (cmd.equals("add")) {
        if (selected.isEmpty()) {
          System.out.println("Please enter a valid input.");
        } else {
          String[] item = selected.trim().split(",");
          for (int i = 0; i < item.length; i++) {
            String message1 = cart.addToCart(item[i].trim());
            System.out.println(message1);
          }
        }

        /*
         * sc.useDelimiter(",");
         * while (sc.hasNext()) {
         * String message1 = cart.addToCart(sc.next());
         * System.out.println(message1);
         * }
         */

        // add one or more items to the cart. Multiple items are separated by comma
        // if item is in cart, print appropriate message
      } else if (cmd.equals("delete")) {
        try {
          int index = Integer.parseInt(selected);
          cart.removeFromCart(index);
        } catch (NumberFormatException e) {
          System.out.println("Please use delete with an integer, i.e.:");
          System.out.println("delete <position of item>");
        }
        // option 1
        /*
         * if (!selected.hasNextInt()) {
         * System.out.println("Please use delete with an integer, i.e.:");
         * System.out.println(" delete <position of item>");
         * } else {
         * cart.removeFromCart(sc.nextInt());
         * }
         */
        // // delete an item from the cart based on item's index
      } else if (cmd.equals("checkout")) {
        running = false;
      } else {
        System.out.println("Please enter a valid input.");
      }
      cmd = sc.next().trim();
      selected = sc.nextLine().trim();

    }
    sc.close();

  }

}
