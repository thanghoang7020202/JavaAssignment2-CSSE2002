package pizza;

import exceptions.TooManyToppingsException;
import pizza.ingredients.Bases;
import menu.MenuItem;
import pizza.ingredients.Cheeses;
import pizza.ingredients.Sauces;
import pizza.ingredients.Topping;

import java.util.List;

/**
 * Custom Pizza allows the addition of extra toppings for a more delicious Pizza.
 * Unless you're a margarita fan :)
 * The custom pizza can have multiple same toppings added to it.
 */
public class CustomPizza extends Pizza implements MenuItem {

    /**
     * Default constructor which creates a medium cheese pizza.
     * A medium cheese pizza has a tomato sauce base, mozzarella cheese and no additional toppings.
     * This pizza should be called "Custom Pizza" until another name is set.
     * @throws TooManyToppingsException when attempting to add toppings to Pizza or
     * any class extending Pizza
     */
    public CustomPizza() {
        super();
        super.setName("Custom Pizza");
    }

    /**
     * Creating the default requirements of a pizza with no additional toppings.
     * This pizza should be called "Custom Pizza" until another name is set.
     * @param size The size of the pizza base as defined by Bases
     * @param sauce The sauce on the pizza as defined by Sauces
     * @param cheese The cheese on the pizza as defined by Cheeses
     * @throws IllegalArgumentException if size, sauce or cheese is null.
     */
    public CustomPizza(Bases.BaseSize size,
                       Sauces.Sauce sauce,
                       Cheeses.Cheese cheese) throws IllegalArgumentException {
        super(size, sauce, cheese);
        super.setName("Custom Pizza");
    }

    /**
     * The add method allows toppings to be added to the pizza,
     * limited to the maximum permissible amount of 5.
     * This method will only add toppings to the pizza if ALL given toppings can be added.
     * If an exception is thrown then the list of toppings should remain unchanged.
     * @param toppings list of toppings to be added to the pizza
     * @throws TooManyToppingsException if adding the new toppings
     * causes the number oftoppings to exceed the limit of 5
     * OR when attempting to add toppings to Pizza or any class extending Pizza
     */
    public void add(List<Topping> toppings)
            throws TooManyToppingsException {
        if (super.accessToppings().size() + toppings.size() > 5) {
            throw new TooManyToppingsException("The number of topping is "
                   + toppings.size() + " > 5");
        }
        super.accessToppings().addAll(toppings);
    }

    /**
     * The add method allows a single topping to be added to the pizza,
     * limited to the maximum permissible amount of 5.
     * @param topping topping to be added to the pizza
     * @throws TooManyToppingsException if adding the new topping
     * causes the number of toppings to exceed the limit of 5
     */
    public void add(Topping topping)
            throws TooManyToppingsException {
        if (super.accessToppings().size() + 1 > 5) {
            throw new TooManyToppingsException("The number of topping is "
                    + super.accessToppings().size() + 1 + " > 5");
        }
        super.accessToppings().add(topping);
    }

    /**
     * The remove method removes the first occurrence of the specified topping from this pizza,
     * if it is present. If the topping is not on the pizza, it is unchanged.
     * @param topping topping to be removed from the pizza
     */
    public void remove(Topping topping) {
        super.accessToppings().remove(topping);
    }
}
