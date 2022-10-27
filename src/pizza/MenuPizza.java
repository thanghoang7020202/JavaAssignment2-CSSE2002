package pizza;

import exceptions.TooManyToppingsException;
import pizza.ingredients.Cheeses;
import pizza.ingredients.Sauces;
import pizza.ingredients.Topping;

import java.util.List;

/**
 * MenuPizza provides a selection for ordering pre-organised Pizzas from the menu.
 * The menu pizza's toppings can not be changed.
 */
public class MenuPizza extends Pizza {

    /**
     * Creating a Menu Pizza with a set base size, sauce, cheese and list of toppings.
     * @param size The size of the pizza base as defined by Bases
     * @param sauce The sauce on the pizza as defined by Sauces
     * @param cheese The cheese on the pizza as defined by Cheeses
     * @param toppings The list of toppings on the Pizza, List of Toppings
     * @throws TooManyToppingsException if toppings.size() > 5
     * OR when attempting to add toppings to Pizza or any class extending Pizza
     */
    public MenuPizza(BaseSize size, Sauces.Sauce sauce,
                     Cheeses.Cheese cheese, List<Topping> toppings)
            throws TooManyToppingsException {
        super(size, sauce, cheese, toppings);
    }

    /**
     * Returns the human-readable string representation of this Menu Pizza.
     * The format of the string to return is:
     *      [MenuPizza] `Pizza`
     * Where:
     * `Pizza` toString of the Pizza superclass
     * For example:
     *     [MenuPizza] Hawaiian: is a 'MEDIUM' sized base with 'TOMATO' sauce
     *     and 'MOZZARELLA' cheese - Toppings: [PINEAPPLE, HAM] $9.00
     * @return string representation of this Menu Pizza
     */
    @Override
    public String toString() {
        String output = "[MenuPizza] "
                + super.toString();
        return output;
    }
}
