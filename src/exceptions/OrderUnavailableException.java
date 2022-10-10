package exceptions;


/**
 * Exception thrown if an order request is not able to be completed.
 */
public class OrderUnavailableException extends Exception {

    /**
     * Constructs a OrderUnavailableException with no detail message.
     */
    public OrderUnavailableException() {
        super();
    }

    /**
     * Constructs a OrderUnavailableException that contains
     * a helpful detail message explaining why the exception occurred.
     */
    public OrderUnavailableException(String message) {
        super(message);
    }

}
