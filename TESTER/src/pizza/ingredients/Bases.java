package pizza.ingredients;

/**
 * Base interface for managing the types of base sizes available
 */
public interface Bases {

    /**
     * Set (Bases) utilises an enum with all the types of Bases available for the Bases Type.
     * BaseSize being (SMALL, MEDIUM, LARGE)
     * @param size enum Type depicting the sizes of each Pizza base type
     */
    void set(Bases.BaseSize size);

    /**
     * enum containing the sizes available for the pizza Bases type
     */
    public enum BaseSize {

        /**
         * LARGE diameter of 12 inches
         */
        LARGE,

        /**
         * MEDIUM diameter of 9 inches
         */
        MEDIUM,

        /**
         * SMALL diameter of 6 inches
         */
        SMALL;

        /**
         * Returns the price of this base
         * @return the price of the base
         */
        public double getPrice() {
            switch (this) {
                case LARGE -> {
                    return 7;
                }
                case MEDIUM -> {
                    return 5;
                }
                default -> {
                    return 3;
                }
            }
        }
    }
}
