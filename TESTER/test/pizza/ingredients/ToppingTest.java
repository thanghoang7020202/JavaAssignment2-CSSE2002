package pizza.ingredients;

import gui.Display;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class ToppingTest {
    @Rule
    public Timeout timeout = Timeout.seconds(5);

    @Test (expected = IllegalArgumentException.class)
    public void createToppingNullName() {
        Topping.createTopping(null,false);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createToppingEmptyName() {
        Topping.createTopping("",false);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createToppingDupplicate() {
        Topping.createTopping("bacon",true);
        Topping.createTopping("bacon",false);
    }

    @Test
    public void valueOf() {
        Topping.resetToppings();
        Topping.createTopping("bacon",true);
        assertEquals(Topping.valueOf("bacon").toString(),"BACON");
        Topping.resetToppings();
    }


    @Test (expected = NullPointerException.class)
    public void valueOfNullName() {
        Topping.resetToppings();
        Topping.valueOf(null);

    }

    @Test (expected = IllegalArgumentException.class)
    public void valueOfNotExsit() {
        Topping.resetToppings();
        Topping.valueOf("Csse2002");
        Topping.resetToppings();
    }

    @Test
    public void resetToppings() {
        Topping.resetToppings();
        assertEquals(Topping.values().length,0);
    }


    @Test
    public void isVegan() {
        Topping.resetToppings();
        Topping.createTopping("bacon",false);
        assertEquals(Topping.values()[0].isVegan(), false);
        Topping.resetToppings();
    }
}