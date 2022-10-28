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

    @Test
    public void addOverToppingList() throws TooManyToppingsException {
        List<Topping> toppings = new ArrayList<>();
        Topping.createTopping("a",true);
        Topping.createTopping("b",false);
        Topping.createTopping("c",true);
        Topping.createTopping("d",false);
        Topping.createTopping("e",true);
        Topping.createTopping("f",false);
        CustomPizza pizza = new CustomPizza(Bases.BaseSize.MEDIUM, Sauces.Sauce.TOMATO, Cheeses.Cheese.MOZZARELLA);
        for (int i= 0 ; i < toppings.size(); i++) {
            System.out.println(toppings.get(i));
        }
        pizza.add(toppings);
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void remove() {
    }
}