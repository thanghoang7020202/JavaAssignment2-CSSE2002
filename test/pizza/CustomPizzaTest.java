package pizza;

import exceptions.TooManyToppingsException;
import gui.Display;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import pizza.ingredients.Bases;
import pizza.ingredients.Cheeses;
import pizza.ingredients.Sauces;
import pizza.ingredients.Topping;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomPizzaTest {

    @Rule
    public Timeout timeout = Timeout.seconds(10);

    @Test (expected = IllegalArgumentException.class)
    public void addEmptyToppingList() throws TooManyToppingsException {
        List<Topping> toppings = null;
        CustomPizza pizza = new CustomPizza(Bases.BaseSize.MEDIUM, Sauces.Sauce.TOMATO, Cheeses.Cheese.MOZZARELLA);
        pizza.add(toppings);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addIndividualToppingNull() throws TooManyToppingsException {
        Topping.resetToppings();
        CustomPizza pizza = new CustomPizza(Bases.BaseSize.MEDIUM, Sauces.Sauce.TOMATO, Cheeses.Cheese.MOZZARELLA);
        pizza.add((List<Topping>) null);
    }

    @Test (expected = TooManyToppingsException.class)
    public void addOverIndividualTopping() throws TooManyToppingsException {
        Topping.resetToppings();
        Topping.createTopping("a",true);
        Topping.createTopping("b",false);
        Topping.createTopping("c",true);
        Topping.createTopping("d",false);
        Topping.createTopping("e",true);
        Topping.createTopping("f",false);
        CustomPizza pizza = new CustomPizza(Bases.BaseSize.MEDIUM, Sauces.Sauce.TOMATO, Cheeses.Cheese.MOZZARELLA);
        for (int i = 0; i < Topping.values().length; i++) {
            pizza.add(Topping.values()[i]);
        }
    }

    @Test (expected = TooManyToppingsException.class)
    public void testAddList() throws TooManyToppingsException {
        Topping.resetToppings();
        Topping.createTopping("a",true);
        Topping.createTopping("b",false);
        Topping.createTopping("c",true);
        Topping.createTopping("d",false);
        Topping.createTopping("e",true);
        Topping.createTopping("f",false);
        List<Topping> testTopping = new ArrayList<>();
        for (int i = 0; i < Topping.values().length; i++) {
            testTopping.add(Topping.values()[i]);
        }
        CustomPizza pizza = new CustomPizza(Bases.BaseSize.MEDIUM, Sauces.Sauce.TOMATO, Cheeses.Cheese.MOZZARELLA);
        for (int i = 0; i < Topping.values().length; i++) {
            pizza.add(testTopping);
        }
    }

    @Test
    public void remove2ndElement() throws TooManyToppingsException {
        Topping.resetToppings();
        Topping.createTopping("a",true);
        Topping.createTopping("b",false);
        Topping.createTopping("c",true);
        Topping.createTopping("d",false);
        CustomPizza pizza = new CustomPizza(Bases.BaseSize.MEDIUM, Sauces.Sauce.TOMATO, Cheeses.Cheese.MOZZARELLA);
        for (int i = 0; i < Topping.values().length; i++) {
            pizza.add(Topping.values()[i]);
        }
        pizza.remove(Topping.values()[1]);
        // remove Topping name "b" located at 2nd position in a Topping list
        assertEquals(pizza.getToppings().size(), 3);
    }
}