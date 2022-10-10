package menu;

import exceptions.TooManyToppingsException;

public class CustomerOrder {


    /**
     * Default Constructor to create a pizza Since no name supplied,
     * this constructor sends GUI prompt to the customer for their name through by calling requestName().
     * and passes on the name to the String signature constructor.
     */
    public CustomerOrder() {
        Order order = new Order();
        order.setName(this.requestName());
    }

    /**
     * Constructor taking customer name as the parameter.
     * Creates a unique order/customer ID, stores the customer name
     * gets the current date and time, and calls createOrder().
     */
    public CustomerOrder(String customerName) {
        Order order = new Order();
        order.setName(customerName);

    }

    /**
     * Prompts the user for their name, following an attempt to instantiate the order without one.
     * The expectation is to use a JOptionPane to request the name through a GUI medium.
     * @return String from the input field donating the customers name.
     */
    protected String requestName() {
        String a = new String();
        return a;
    }

    /**
     * Creates a test customer order to connect with a future GUI
     * @return Order containing the entire order of the customer,
     *  which includes the unique order/customer identifier, data and time.
     * @throws TooManyToppingsException when attempting to add toppings to Pizza or any class extending Pizza
     */
    public Order createOrder()
            throws TooManyToppingsException {
        Order order = new Order();
        return order;
    }
}
