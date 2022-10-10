package menu;

/**
 * Represents an item that can be ordered from the menu.
 */
public interface MenuItem {

    /**
     * Registers this item with the Menu singleton class.
     * This method should be called in the constructor of each implementing class.
     */
    default void registerMenuItem(){

    }
}
