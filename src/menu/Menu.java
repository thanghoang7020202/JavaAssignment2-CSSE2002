package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class which defines a menu that contains items that can be ordered from.
 * All classes that implement MenuItem must be registered with this Menu,
 * which will allow them to be ordered in the simulation.
 *
 * A Menu starts as empty but will grow over the programs run time.
 */
public class Menu {

    /**
     * Farm Favourites contains [bacon, beef, ham, chicken, sweetcorn]
     */
    static final int FARM_FAVOURITES = 4;

    /**
     * Hawaiian contains [pineapple, ham]
     */
    static final int HAWAIILAN = 2;

    /**
     * Margarita contains nothing but good old cheese
     */
    static final int MARGARITA = 6;

    /**
     * Meat Feast contains [bacon, pepperoni, sausage, beef, chicken]
     */
    static final int MEAT_FEAST = 0;

    /**
     * Spicy Italian contains [pepperoni, jalapeno, peppers]
     */
    static final int SPICY_ITALIAN = 3;

    /**
     * Spicy Vegan contains [tomatoes, peppers, onions, sweetcorn, jalapeno]
     */
    static final int SPICY_VEGAN = 5;

    /**
     * Vegetarian contains [tomatoes, mushroom, peppers, onions, olives]
     */
    static final int VEGETARIAN = 1;

    /**
     * List of items inside the menu
     */
    private List<MenuItem> Items;

    private static Menu menu;
    private Menu() {
        Items = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of the menu.
     * @return singleton instance
     */
    public static Menu getInstance() {
        if(menu == null) menu = new Menu();
        return menu;
    }

    /**
     * Registers a menu item with this menu.
     * The menu will only register item's that it has not seen before.
     *
     * The menu has not seen an item if the Menu does not contain any item (existingItem)
     * such that Objects.equals(item,existingItem) == true.
     * @param item a menu item to be registered to the menu
     */
    public void registerMenuItem(MenuItem item) {
        boolean flag = false;
        for (MenuItem i : Items) {
            if( i.equals(item)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            this.Items.add(item);
        }
    }

    /**
     * Returns a menu item from the list of loaded menu items
     * @param index the index of the item in the list
     * @return The item that has been found.
     * @throws IndexOutOfBoundsException if index does not exist or array is null
     */
    public MenuItem get(int index)
            throws IndexOutOfBoundsException {
        MenuItem output = null;
        return output;
    }

    /**
     * Returns the items that have been registered with the Menu.
     * Adding or removing elements from the returned list should NOT affect the original list.
     * @return the items on the menu.
     */
    public List<MenuItem> getItems() {
        List<MenuItem> items = new ArrayList<>();
        return items;
    }
}
