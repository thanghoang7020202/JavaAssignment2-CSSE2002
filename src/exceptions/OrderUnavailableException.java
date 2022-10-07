package exceptions;


/**
 * Exception thrown if an order request is not able to be completed.
 */
public class OrderUnavailableException {

    /**
     * Constructs a OrderUnavailableException with no detail message.
     */
    public OrderUnavailableException() {

    }

    /**
     * Constructs a OrderUnavailableException that contains
     * a helpful detail message explaining why the exception occurred.
     */
    public OrderUnavailableException(String message) {
        System.out.println(message);
    }

}
