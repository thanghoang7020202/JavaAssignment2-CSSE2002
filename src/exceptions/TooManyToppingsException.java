package exceptions;

/**
 * Exception thrown when too many toppings
 * are attempted to be added to a pizza
 */
public class TooManyToppingsException extends Exception {

    /**
     * Constructs a TooManyToppingsException that contains
     * a helpful detail message explaining why the exception occurred.
     * @param message message to be displayed
     * @param lineNum int line number of error
     */
    public TooManyToppingsException(String message,
                                    int lineNum) {
        super(message + ", " + lineNum);
    }

    /**
     * Constructs a TooManyToppingsException that contains
     * a helpful detail message explaining why the exception occurred.
     * @param message
     */
    public TooManyToppingsException(String message) {
        super(message);
    }

    /**
     * Constructs a TooManyToppingsException that stores
     * the underlying cause of the exception.
     * @param cause
     */
    public TooManyToppingsException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a TooManyToppingsException that contains
     * a helpful detail message explaining why the exception occurred
     * and the underlying cause of the exception.
     * @param message
     * @param cause
     */
    public TooManyToppingsException(String message,
                                    Throwable cause) {
        super(message + ", " + cause);
    }
}
