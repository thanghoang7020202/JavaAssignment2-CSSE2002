package pizza.ingredients;

public class Bases {

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

        public double getPrice() {
            switch (this) {
                case LARGE -> { return 7;}
                case MEDIUM -> { return 5;}
                default -> { return 3;}
            }
        }


    }
}
