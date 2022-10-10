package exceptions;

/**
 * Exception thrown if an order is not processed correctly.
 */
public class OrderInOutException extends Exception {

    /**
     * Constructs a OrderInOutException with no detail message.
     */
    public OrderInOutException() {
        super();
    }

    /**
     * Constructs a OrderInOutException that contains
     * a helpful detail message explaining why the exception occurred.
     */
    public OrderInOutException(String message) {
        super(message);
    }
}
