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
    private static List<Topping> toppings = new ArrayList<>();
    private String name;
    private boolean isVegan;


    private Topping(String name, boolean isVegan) {

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
        ;
        Topping[] output = {};
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
    public boolean isVegan() {
        return this.isVegan;
    }

}
