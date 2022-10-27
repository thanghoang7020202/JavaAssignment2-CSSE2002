package pizza;

import exceptions.TooManyToppingsException;
import pizza.ingredients.Bases;
import pizza.ingredients.Cheeses;
import pizza.ingredients.Sauces;
import pizza.ingredients.Topping;
import menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Pizza combines the required basic elements of a pizza,
 * being the base, sauce and cheese, and 5 additional toppings.
 * This is the Pizza template to be extended for more rewarding pizza toppings
 */
public abstract class Pizza implements Bases, Sauces, Cheeses, MenuItem {

    /**
     * The maximum number of toppings that can be placed on a pizza. (5)
     */
    public static final int MAX_TOPPINGS = 5;

    /**
     * The size of the pizza base as defined by Bases
     */
    private Bases.BaseSize size;

    /**
     * The sauce on the pizza as defined by Sauces
     */
    private Sauces.Sauce sauce;

    /**
     * The cheese on the pizza as defined by Cheeses
     */
    private Cheeses.Cheese cheese;

    /**
     * The list of toppings on the Pizza, List of Toppings
     */
    private List<Topping> toppings;

    /**
     * The name of the pizza
     */
    private String name;

    /**
     * Default constructor which creates a medium cheese pizza with tomato sauce.
     * A cheese pizza has a tomato sauce base, mozzarella cheese and no additional toppings.
     * This pizza should be called "Dr Java's Pizza" unless/until another name is set.
     * @throws TooManyToppingsException when attempting to add toppings to Pizza
     * or any class extending Pizza
     */
    public Pizza() {
        this.cheese = Cheeses.Cheese.MOZZARELLA;
        this.sauce = Sauces.Sauce.TOMATO;
        this.size = Bases.BaseSize.MEDIUM;
        this.name = "Dr Java's Pizza";
        this.toppings = new ArrayList<>();
    }

    /**
     * Creating the base requirements of the pizza with no toppings.
     * This pizza should be called "Dr Java's Pizza" unless/until another name is set.
     * @param size The size of the pizza base as defined by Bases
     * @param sauce The sauce on the pizza as defined by Sauces
     * @param cheese The cheese on the pizza as defined by Cheeses
     * @throws TooManyToppingsException when attempting to add toppings to Pizza
     * or any class extending Pizza
     */
    public Pizza(Bases.BaseSize size, Sauces.Sauce sauce, Cheeses.Cheese cheese) {
        this.size = size;
        this.sauce = sauce;
        this.cheese = cheese;
        this.name = "Dr Java's Pizza";
        this.toppings = new ArrayList<>();
    }

    /**
     * Creating a Pizza with a set base size, sauce, cheese and list of toppings.
     * @param size The size of the pizza base as defined by Bases
     * @param sauce The sauce on the pizza as defined by Sauces
     * @param cheese  The cheese on the pizza as defined by Cheeses
     * @param toppings The list of toppings on the Pizza, List of Toppings
     * @throws TooManyToppingsException if toppings.size() > 5
     *  when attempting to add toppings to Pizza or any class extending Pizza
     */
    public Pizza(Bases.BaseSize size, Sauces.Sauce sauce,
                 Cheeses.Cheese cheese, List<Topping> toppings)
            throws TooManyToppingsException {
        if (toppings.size() > 5) {
            throw new TooManyToppingsException("The number of topping is "
                    + toppings.size() + " > 5");
        }
        this.size = size;
        this.sauce = sauce;
        this.cheese = cheese;
        this.toppings = toppings;
        this.name = "Dr Java's Pizza";
    }

    /**
     * Returns the list of toppings that are on this pizza.
     * Adding or removing elements from the returned list should NOT affect the original list.
     * @return the list of toppings on this pizza.
     */
    public List<Topping> getToppings() {
        List<Topping> output = new ArrayList<Topping>(this.toppings);
        return output;
    }

    /**
     * Returns the price of the pizza base size,
     * defined in the BaseSize enum, and adds the price of each topping on the pizza.
     * @return the price of the pizza.
     */
    public double getTotalPrice() {
        Double total = 0.0;
        if (this.toppings.isEmpty()) {
            return this.size.getPrice();
        } else {
            return this.size.getPrice() + this.toppings.size() * 2;
        }
    }

    /**
     * Returns the name of this pizza.
     * @return a String name of this pizza
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the pizza.
     * @param name String providing a replacement name of the pizza
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the size of this pizza base.
     * @param size the size of this pizza base.
     */
    public void set(Bases.BaseSize size) {
        this.size = size;
    }

    /**
     * Set the sauce on this pizza.
     * @param sauce the sauce on this pizza
     */
    public void set(Sauces.Sauce sauce) {
        this.sauce = sauce;
    }

    /**
     * Set the cheese on this pizza.
     * @param cheese the cheese on this pizza
     */
    public void set(Cheeses.Cheese cheese) {
        this.cheese = cheese;
    }

    /**
     * Returns the hash code of this pizza.
     * Two pizzas' that are equal according to the equals(Object) method
     * should have the same hash code.
     * @return hash code of this pizza.
     */
    public int hashCode() {
        return this.name.hashCode()
                + this.cheese.hashCode()
                + this.size.hashCode()
                + this.sauce.hashCode()
                + this.toppings.hashCode();
    }

    /**
     * Returns true if and only if this pizza is equal to the other given object.
     * For two pizzas' to be equal, they must have the same base size, sauce, cheese and toppings
     * @param other the reference object with which to compare
     * @return true if this pizza is the same as the other argument; false otherwise
     */
    public boolean equals(Object other) {
        return this.hashCode() == other.hashCode();
    }

    /**
     * Returns the human-readable string representation of this Pizza.
     * The format of the string to return is:
     * $Name: is a '`BaseSize`' sized base with '`Sauce`' sauce and '`Cheese`'
     *      cheese`Toppings` $`Price`
     * Where:
     * `Name` is the name of the pizza
     * `BaseSize` is the base size of the pizza
     * `Sauce` is the Sauce on the pizza
     * `Cheese` is the Cheese on the pizza
     * `Toppings` is:
     * The empty string if there are no toppings
     * " - Toppings: `Tops`" if there are toppings.
     * Where `Tops` is the string representation of the list of toppings
     * `Price` is the price of the pizza formatted to two decimal places
     * For example:
     * Dr Java's Pizza: is a 'MEDIUM' sized base with 'BBQ' sauce and 'MOZZARELLA' cheese $5.00
     * OR, on a pizza with toppings
     * Dr Java's Pizza: is a 'MEDIUM' sized base with 'BBQ' sauce and 'MOZZARELLA' cheese
     *  - Toppings: [BACON, PEPPERONI, HAM] $11.00
     * @return string representation of this Pizza
     */
    public String toString() {
        String output = new String();
        output += this.name + ": is a "
                + this.size + " sized base with "
                + this.sauce + " sauce and "
                + this.cheese + " cheese ";
        if (!this.toppings.isEmpty()) {
            output += "- Toppings: " + this.toppings;
        }
        output += " $" + this.getTotalPrice();
        return output;
    }

    /**
     * Returns the list of toppings that are on this pizza.
     * This method is used by subclasses to interface with the toppings on this pizza.
     *
     * Adding or removing elements from the returned list should affect the original list.
     * @return the list of toppings on this pizza.
     */
    protected List<Topping> accessToppings() {
        return this.toppings;
    }
}
