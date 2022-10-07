package exceptions;

/**
 * Exception thrown when too many toppings
 * are attempted to be added to a pizza
 */
public class TooManyToppingsException extends Throwable {

    /**
     * Constructs a TooManyToppingsException that contains
     * a helpful detail message explaining why the exception occurred.
     * @param message message to be displayed
     * @param lineNum int line number of error
     */
    public TooManyToppingsException(String message,
                                    int lineNum) {
        System.out.println(message + ", " + lineNum);
    }

    /**
     * Constructs a TooManyToppingsException that contains
     * a helpful detail message explaining why the exception occurred.
     * @param message
     */
    public TooManyToppingsException(String message) {
        System.out.println(message);
    }

    /**
     * Constructs a TooManyToppingsException that stores
     * the underlying cause of the exception.
     * @param cause
     */
    public TooManyToppingsException(Throwable cause) {
        System.out.println(cause);
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
        System.out.println(message + ", " + cause);
    }
}
