package workshopd1;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    // @Test
    // public void shouldAnswerWithTrue()
    // {
    // assertTrue( true );
    // }

    @Test
    public void testAdd() {
        Cart cart = new Cart();

        cart.addToCart("apple");

        String item = cart.shoppingCart.get(0);

        assertTrue(item.equals("apple"));
    }

    @Test
    public void testdelete() {

        Cart cart = new Cart();
        cart.addToCart("apple");
        cart.addToCart("grape");
        cart.addToCart("mango");
        cart.removeFromCart(1);
        ArrayList<String> items = new ArrayList<>();
        items.add("apple");
        items.add("mango");
        assertTrue(cart.shoppingCart.equals(items));

    }
}
