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
      return " You have" + item + " in your cart";
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

}
