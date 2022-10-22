package menu;

/**
 * Represents an item that can be ordered from the menu.
 */
public interface MenuItem {

    /**
     * Returns the price of a menu item.
     * @return the price of the menu item
     */
    public double getTotalPrice();
    /**
     * Registers this item with the Menu singleton class.
     * This method should be called in the constructor of each implementing class.
     */
    public default void registerMenuItem(){

    }

    /**
     * Returns the name of this menu item.
     * @return name of this menu item
     */
    public String getName();

    /**
     * A functional interface to allow a lambda function to be passed to an Order.
     */
    public static interface Discount {

        /**
         * Apply a discount to the given price.
         * @param price the input price
         * @return the discounted price
         */
        double applyDiscount(double price);
    }
}
