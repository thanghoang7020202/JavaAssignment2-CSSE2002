package exceptions;

/**
 * Exception thrown when an error is thrown
 * while parsing the text file using MenuLoader.
 */
public class PizzaFormatException extends Exception {

    /**
     * Constructs a PizzaFormatException that contains
     *      * a helpful detail message explaining why the exception occurred.
     * @param message message to be displayed
     * @param lineNum int line number of error
     */
    public PizzaFormatException(String message,
                                int lineNum) {
        //not sure about the format --> need to be fixed later
        super(message + " = " + lineNum);
    }

    /**
     * Constructs a PizzaFormatException that contains
     * a helpful detail message explaining why the exception occurred.
     * @param message message to be displayed
     * @param lineNum int line number of error
     * @param cause throwable that caused this exception
     */
    public PizzaFormatException(String message,
                                int lineNum,
                                Throwable cause) {
        super(message + ", " + lineNum + ", " + cause);
    }

    /**
     * Constructs a PizzaFormatException that contains
     * a helpful detail message explaining why the exception occurred.
     * Additionally, the debug code defined in the MenuLoader anonymous class named
     * Because is supplied the error message.
     * @param message
     * @param lineNum
     * @param debugCode
     */
    public PizzaFormatException(String message,
                                int lineNum,
                                int debugCode) {
        super(message + ", " + lineNum + ", " + debugCode);
    }
}
