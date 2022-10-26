package pizza.ingredients;

import java.util.*;

/**
 * The Topping class represents possible toppings that can be placed on a Pizza.
 * Topping's are created using the createTopping(String, boolean) method
 * which in turn calls a private constructor. A Topping's name should be made uppercase such that:
 * createTopping("baCOn",false) would save the topping with a name of "BACON".
 *
 * The Topping class is meant to be a dynamic enum such that given a name the correct Topping is returned
 * by the valueOf(String) method. Similar to createTopping(String, boolean)
 * this method will allow any case of string to match.
 * That is, an input of "bacon", "BaCON", "BACON" would all return the topping with name "BACON".
 *
 * The Topping's that are available in the values() method will be any previously created toppings.
 */
public class Topping {

    /**
     * The price of the topping is 2.0.
     */
    public static final double PRICE = 2.0;

    /**
     * The list of topping to be chosen from
     */
    private static List<Topping> toppings = new ArrayList<>();

    /**
     * name of a topping
     */
    private String name;

    /**
     * Topping for vegan or not
     */
    private boolean isVegan;

    /**
     * private constructor of Topping class
     * This method help to add new topping into the list
     * @param name name of the topping
     * @param isVegan if the topping is vegan or not
     */
    private Topping(String name, boolean isVegan) {
        this.name = name.toUpperCase();
        this.isVegan = isVegan;
    }

    /**
     * Creates a new topping with the specified name and vegan boolean state.
     * This new topping is not returned but rather should be accessed by valueOf(String)
     * @param name name of the topping
     * @param isVegan if the topping is vegan or not
     */
    public static void createTopping(String name,
                                     boolean isVegan) {
        Topping topping = new Topping(name.toUpperCase(), isVegan);
        toppings.add(topping);
    }

    /**
     * Returns a Topping that has previously been defined by this class with the specified name.
     * The string must match exactly an identifier used to match a Topping's name.
     * (Extraneous whitespace characters are not permitted.)
     * @param name the name of the topping to be returned.
     * @return the topping with the specified name
     */
    public static Topping valueOf(String name) {
        if(name == null) throw new NullPointerException();
        for (Topping i : toppings) {
            if(i.name.equals(name.toUpperCase())){
                return i;
            }
        }
        return null;
    }

    /**
     * Returns an array containing the Topping's
     * that have been defined by this class, in the order they are declared.
     * @return an array containing the topping's that have been defined by this class,
     * in the order they are declared.
     */
    public static Topping[] values() {
        Topping[] output = new Topping[toppings.size()];
        for(int i = 0; i < toppings.size(); i ++) {
            output[i] = toppings.get(i);
        }
        return output;
    }

    /**
     * Returns the topping's name
     * @return topping name
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Returns the vegan boolean property value
     * The isSpicy boolean property value was flat out abandoned
     * because there were fierce arguments about what constitutes a spicy topping.
     * Dr Java considered sweetcorn to be spicy, but his team disagreed.
     * The debate was so fierce that Dr Java was forced to concede and abandon the isSpicy property.
     * @return
     */
    public boolean isVegan() {
        return this.isVegan;
    }

}
