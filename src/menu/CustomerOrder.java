package menu;

import exceptions.TooManyToppingsException;

import javax.swing.*;

/**
 * Customer Ordering class used for creating multiple types of pizzas,
 * and storing Orders in an order object, to be returned by a calling class.
 * It maintains the order number ID represented by a Universal Unique Identifier (UUID)
 * as described in the Order class. The name, UUID, time and date are taken,
 * and attached to each order. The customer name is required, but not filtered.
 * Such that any string value is accepted for a customer name.
 * But if a value is not provided through the constructor,
 * a name is requested through a GUI prompt in the requestName() method.
 * This calls a simple JOptionPane.
 */
public class CustomerOrder {

    /**
     * order of a customer
     */
    private Order order;

    /**
     * Default Constructor to create a pizza Since no name supplied,
     * this constructor sends GUI prompt to the customer for their name
     * through by calling requestName().
     * and passes on the name to the String signature constructor.
     */
    public CustomerOrder() {
        try {
            this.order = createOrder();
            this.order.setName(this.requestName());
        } catch (TooManyToppingsException e) {
            order = null;
        }
    }

    /**
     * Constructor taking customer name as the parameter.
     * Creates a unique order/customer ID, stores the customer name gets the current date and time,
     * and calls createOrder().
     * @param customerName String donating the name of the customer
     */
    public CustomerOrder(String customerName) {
        try {
            order = createOrder();
            order.setName(customerName);
        } catch (TooManyToppingsException e) {
            order = null;
        }
    }

    /**
     * Creates a test customer order to connect with a future GUI
     * @return Order containing the entire order of the customer,
     *  which includes the unique order/customer identifier, data and time.
     * @throws TooManyToppingsException when attempting to add toppings
     * to Pizza or any class extending Pizza
     */
    public Order createOrder()
            throws TooManyToppingsException {
        Order order = new Order();
        return order;
    }

    /**
     * Returns human-readable string representation of a Customer order.
     * This is:
     *
     * Customer Order {`order`}
     * Where `order` is the Order.toString().
     * @return string representation of this Customer Order
     */
    @Override
    public String toString() {
        try {
            return "Customer Order {"
                    + createOrder().toString() + "}";
        } catch (TooManyToppingsException e) {
            System.exit(4);
        }
        return null;
    }

    /**
     * Prompts the user for their name, following an attempt to instantiate the order without one.
     * The expectation is to use a JOptionPane to request the name through a GUI medium.
     * @return String from the input field donating the customers name.
     */
    protected String requestName() {
        String a = new String();
        JOptionPane.showInputDialog("Please input your name: ", a);
        return a;
    }
}
