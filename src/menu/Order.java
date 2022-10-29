package menu;

import pizza.Pizza;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Object model to manage an individual order.
 * An order will have an associated date, time and customer name.
 * To make it easy to identify order's they are also given a UUID.
 */
public class Order {

    /**
     * formatting the double.toString() into number with 2 decimal place
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * A constant lambda functional interface to apply a 25% discount
     */
    public static final MenuItem.Discount DISCOUNT_25 = price -> price * 0.75;

    /**
     * A constant lambda functional interface to apply a 10% discount
     */
    public static final MenuItem.Discount DISCOUNT_10 = price -> price * 0.9;

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
    private LocalDate date;

    /**
     * Order's creation time
     */
    private LocalTime time;

    /**
     * The pizza in the order
     */
    private List<Pizza> pizzas;

    /**
     * Type of Discount
     * 0 - No discount
     * 1 - 10% discount
     * 2 - 25% discount
     */
    private int discountType;

    /**
     * Creates an Order. The defaults for an order are given below:
     * Name: "Not Given"
     * Order Number: UUID.randomUUID();
     * Date: LocalDate.now();
     * Time: LocalTime.now();
     * Orders: No default items
     */
    public Order() {
        pizzas = new ArrayList<>();
        discountType = 0;
        this.name = "Not Given";
        this.uuid = UUID.randomUUID();
        this.date = LocalDate.now();
        this.time = LocalTime.now();
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
     * A UUID (universally unique identifier) is a 128-bit label
     * used for information purposes in computer systems.
     * The Java default library provides a UUID class, which enables a random UUID to be generated.
     * It allows a unique random number for each given order. 
     * Please review the Java API for further information.
     * @param uuid UUID
     */
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Mutator method to modify the order's creation date
     * LocalDate is an immutable date-time object that represents a date,
     * often viewed as year-month-day.
     * See the Java API LocalDate for further information
     * @param date Local date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Mutator method to modify the order's creation time
     * LocalTime is an immutable date-time object that represents a time,
     * often viewed as hour-minute-second.
     * LocalTime for further information
     * @param time LocalTime
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Adds a completed pizza to the order list
     * @param pizza a pizza to add to this order
     */
    public void add(Pizza pizza) {
        this.pizzas.add(pizza);
        if (this.pizzas.size() >= 6) {
            discountType = 2;
        } else if (this.pizzas.size() >= 3) {
            discountType = 1;
        }
    }

    /**
     * Object.toString() providing a complete synopsis of the order class
     * including the current assigned date and time; formatted as shown.
     * The time is formatted to provide only the hour and minute.
     * @return String representing the instantiated class
     */
    public String toString() {
        String pattern = "HH:mm:ss";
        Double totalPrice = 0.00;
        String output;

        output = "Date: " + this.date
                + "\nTime: " + this.time.format(DateTimeFormatter.ofPattern("HH:mm"))
                + "\nCustomer: " + this.name
                + "\nOrder number: " + this.uuid
                + "\nOrder:";
        //add more later;
        for (int i = 0; i < pizzas.size(); i++) {
            totalPrice += pizzas.get(i).getTotalPrice();
            output += "\n" + (i + 1) + " - " + pizzas.get(i).toString();
        }

        if (discountType != 0) {
            output += "\n\n Multi item discount applied of &"
                    + totalPrice + " applied, new Total: $";
            output += (discountType == 1)
                    ? DISCOUNT_10.applyDiscount(totalPrice) : DISCOUNT_25.applyDiscount(totalPrice);
        } else {
            // this one is unsure!!!!!!
            output += "\n\n Total: $" + totalPrice;
        }
        return output;
    }
}

