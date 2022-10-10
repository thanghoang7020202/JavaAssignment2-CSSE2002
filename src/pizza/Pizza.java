package pizza;

import exceptions.TooManyToppingsException;
import pizza.ingredients.*;

import java.util.List;

/**
 * Pizza combines the required basic elements of a pizza, being the base, sauce and cheese, and 5 additional toppings.
 * This is the Pizza template to be extended for more rewarding pizza toppings
 */
public abstract class Pizza /*implements Bases, Sauces, Cheeses */{
    static final int MAX_TOPPINGS = 5;

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
     * @throws TooManyToppingsException when attempting to add toppings to Pizza or any class extending Pizza
     */
    public Pizza() throws TooManyToppingsException {
        this.cheese = Cheeses.Cheese.MOZZARELLA;
        this.sauce = Sauces.Sauce.TOMATO;
        this.size = Bases.BaseSize.MEDIUM;
        this.name = "Dr Java's Pizza";
    }

    /**
     * Creating the base requirements of the pizza with no toppings.
     * This pizza should be called "Dr Java's Pizza" unless/until another name is set.
     * @param size The size of the pizza base as defined by Bases
     * @param sauce The sauce on the pizza as defined by Sauces
     * @param cheese The cheese on the pizza as defined by Cheeses
     * @throws TooManyToppingsException when attempting to add toppings to Pizza or any class extending Pizza
     */
    public Pizza(Bases.BaseSize size, Sauces.Sauce sauce, Cheeses.Cheese cheese)
            throws TooManyToppingsException {
        this.size = size;
        this.sauce = sauce;
        this.cheese = cheese;
        this.name = "Dr Java's Pizza";
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
    public Pizza(Bases.BaseSize size,
                 Sauces.Sauce sauce,
                 Cheeses.Cheese cheese,
                 List<Topping> toppings)
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
        return this.toppings;
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

    public String toString() {
        String output = new String();
        output += this.name + ": is a "
                + this.size + " sized base with "
                + this.sauce + " sauce and "
                + this.cheese + " cheese ";
        if(!this.toppings.isEmpty()) {
            output += "- Toppings: " + this.toppings;
        }
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
