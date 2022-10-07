package menu;

import pizza.Pizza;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

/**
 * Object model to manage an individual order.
 */
public class Order {

    /**
     * The name of customer
     */
    private String name;

    /**
     * A UUID (universally unique identifier) of customer
     */
    private UUID uuid;

    /**
     * Order's creation date
     */
    LocalDate date;

    /**
     * Order's creation time
     */
    LocalTime time;

    Pizza pizza;


    public Order() {

    }

    /**
     * Mutator method to modify the customer name
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mutator method to modify the orders UUID
     * A UUID (universally unique identifier) is a 128-bit label used for information purposes in computer systems.
     * The Java default library provides a UUID class, which enables a random UUID to be generated.
     * It allows a unique random number for each given order. Please review the Java API for further information.
     * @param uuid UUID
     */
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Mutator method to modify the order's creation date
     * LocalDate is an immutable date-time object that represents a date, often viewed as year-month-day.
     * See the Java API LocalDate for further information
     * @param date Local date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Mutator method to modify the order's creation time
     * LocalTime is an immutable date-time object that represents a time, often viewed as hour-minute-second.
     * LocalTime for further information
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Adds a completed pizza to the order list
     * @param pizza a pizza to add to this order
     */
    public void add(Pizza pizza) {
        this.pizza = pizza;
    }

    /**
     * Method used to display the order, for order confirmation.
     */
    public void show() {

    }

    public String toString() {
        String output = new String();
        output = "Customer Order [ \n" +
                " Date: " + this.date
                + "\n Time: " + this.time
                + "\n Customer: " + this.name
                + "\n Order number: " + this.uuid
                + "\n Order:\n";
        //add more later;

        return output;
    }
}

