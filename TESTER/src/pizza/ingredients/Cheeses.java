package pizza.ingredients;

/**
 * Cheeses interface for managing the types of Cheese available
 */
public interface Cheeses {

    /**
     * Set (Cheese) utilises an enum with all the types of Cheese available for the Cheese Type.
     * Cheese being (MOZZARELLA, VEGAN, NONE)
     * @param cheese enum Type depicting the cheeses of each Pizza
     */
    void set(Cheeses.Cheese cheese);

    /**
     * enum containing the cheeses available for the pizza cheese type
     */
    public enum Cheese {

        /**
         * Classic shredded Mozzarella cheese
         */
        MOZZARELLA,

        /**
         *
         A special option to represent no cheese
         */
        NONE,

        /**
         * Vegan friendly cheese
         */
        VEGAN
    }
}
