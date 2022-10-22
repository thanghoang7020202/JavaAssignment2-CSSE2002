package menu;

import pizza.Pizza;

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

    private int Discounttype;

    public Order() {
        pizzas = new ArrayList<>();
        Discounttype = 0;
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
        if(this.pizzas.size() > 6) Discounttype = 2;
        else if(this.pizzas.size() > 3) Discounttype = 1;
    }

    public String toString() {
        String pattern = "HH:mm:ss";
        int TotalPrice = 0;
        String output;

        output = "Customer Order [ \n" +
                " Date: " + this.date
                + "\n Time: " + this.time.format(DateTimeFormatter.ofPattern("HH:mm"))
                + "\n Customer: " + this.name
                + "\n Order number: " + this.uuid
                + "\n Order:";
        //add more later;
        for(int i = 0 ; i < pizzas.size(); i++) {
            TotalPrice += pizzas.get(i).getTotalPrice();
            output += "\n" + (i+1) + " - " + pizzas.get(i).toString();
        }

        if(Discounttype != 0) {
            output += "\n\n Multi item discount applied of "
                    + TotalPrice + " applied, new Total: $";
            output += (Discounttype == 1)?
                    DISCOUNT_10.applyDiscount(TotalPrice): DISCOUNT_25.applyDiscount(TotalPrice);
        } else {
            // this one is unsure!!!!!!
            output += "\n\n Total: &" + TotalPrice;
        }
        return output;
    }
}

