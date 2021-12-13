package workshopd1;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CartTest {
    /**
     * Rigorous Test :-)
     */
    // @Test
    // public void shouldAnswerWithTrue()
    // {
    // assertTrue( true );
    // }
    //

    @Test
    public void testAdd() {
        Cart cart = new Cart();
        cart.addToCart("apple");
        String item = cart.shoppingCart.get(0);
        assertTrue(item.equals("apple"));
    }

    @Test
    public void testDelete() {
        Cart cart = new Cart();
        cart.addToCart("apple");
        cart.addToCart("grape");
        cart.addToCart("mango");
        cart.removeFromCart(1);
        System.out.println(cart.shoppingCart.size());
        assertTrue(cart.shoppingCart.size() == 2);
    }

}
