package io;

import exceptions.PizzaFormatException;
import exceptions.TooManyToppingsException;
import pizza.ingredients.Bases;
import pizza.ingredients.Cheeses;
import pizza.ingredients.Sauces;
import pizza.ingredients.Topping;
import menu.Menu;
import menu.MenuItem;
import pizza.MenuPizza;
import pizza.Pizza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to provide management for the loading, saving
 * and parsing of text data retrieved from the PizzaMenu.txt file,
 * stored in the assets package.
 * The loaded file should be called "PizzaMenu.txt"
 * The save function may be revealed later by the GUI team,
 * should this feature be required.
 */
public class MenuLoader {
    /**
     * Use full path, change back since submit it
     */
    public static final String PATH = "D:\\UQ\\CSSE2002 - Programming in the Large\\ASSIGNMENT2\\src\\assets\\";

    /**
     * Inherited default constructor, not used in this class
     */
    public MenuLoader() {
    }

    /**
     * Creates a BufferedReader, utilizing a FileReader to be parsed by the getMenu method.
     * The file to be loaded is stored within a package
     * called assets under the file called PizzaMenu.txt.
     * This is the supplied file name, as other filenames can be used depending
     * on the 'menu-specials' that can be promoted from time to time.
     * If the load method catches a FileNotFoundException, PizzaFormatException,
     * or a TooManyToppingsException the application should exit with the vales 1, 2,
     * and 4 respectively.
     * @param filename name of file to be read
     * @return
     */
    public static Menu load(String filename){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(PATH + filename));
            Menu menu = getMenu(reader);
            reader.close();
            return menu;
        }
        catch (FileNotFoundException e){
            System.exit(1);
        } catch (PizzaFormatException e){
            System.exit(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TooManyToppingsException e3){
            System.exit(4);
        }
        return null;
    }

    /**
     * Used by the load method to manage the parsing of the loaded data.
     * The PizzaMenu.txt file content consists of the following formatted text:
     * The first-string token is a string with no spaces and must be the string "PizzaMenu".
     * On the same line separated by a space is a number (an integer value)
     * representing the number of pizza menu items that are available within the given file.
     * This number reflects the number of lines the file reader will read to obtain all the pizzas provided.
     * There should not be any extra whitespace after this number.
     *
     * Then, following the first line, is an empty line.
     * After this empty line will follow a comma separated list of non-vegan toppings.
     * On the line following non-vegan toppings will be another comma separated list of vegan toppings.
     * If any topping can not be parsed then an exception should be thrown.
     *
     * Following the list of vegan toppings will be an empty line.
     * Each subsequent pizza menu item is provided on its own line.
     * A line is a string of text that is separated by the carriage return or separated by an empty line.
     * For each pizza menu item, a line of text is formatted in the following style:
     * 'Pizza Name' which can include spaces and is written with a Title Format.
     * A title format means that each new word starts with a capital letter and is followed by lowercase letters.
     * This will not be tested for programmatically, but is expected for style points when marked.
     *
     * For example: Title Format String Of Words.
     * The menu item pizza name is followed by a space and an opening square bracket `[`.
     * This is then followed by a list of pizza toppings separated by commas, and finally a closing square bracket `]`.
     * The next menu pizza item is listed on the next line, and so on.
     * The list of toppings is provided in lower case.
     * However, care must be taken to read the text-file with any character-case type provided.
     * By default all Menu Pizza's will be set as 'MEDIUM' with a 'TOMATO' base and 'MOZZARELLA' cheese.
     * The following is an example of a menu text file called PizzaMenu.txt that contains two menu items:
     *          PizzaMenu 2
     *
     *          bacon, chicken, beef, ham, pepperoni, sausage, prawn
     *          red onions, carolina reapers, peppers, olives, onions, chillies, jalapenos, pineapple
     *
     *          Flaming Hot [chillies, jalapenos, carolina reapers, red onions]
     *          Meat Feast [bacon, pepperoni, sausage, beef, chicken]
     */
    public static Menu getMenu(BufferedReader reader)
            throws PizzaFormatException, TooManyToppingsException, IOException {
        if(reader.equals(null)) {
            System.exit(1);
        }
        int linenum = 0;
        String content = "";
        Pattern pattern = Pattern.compile("PizzaMenu [0-9]", Pattern.CASE_INSENSITIVE);

        content = reader.readLine().toString();
        linenum += 1;
        Matcher matcher = pattern.matcher(content);
        Boolean found = matcher.find();
        if(content == null || !found) {
            throw new PizzaFormatException("file have no line! OR" +
                    "the pattern not match!", linenum);
        }
        // Take second parameter of content split by blank space (the number of Pizza)
        int numOfPizza = Integer.parseInt(Arrays.stream(content.split(" ")).toArray()[1].toString());

        content = reader.readLine();
        linenum += 1;
        if(!content.equals("")) {
            throw new PizzaFormatException("second line is not empty reader (1)", linenum);
        }

        content = reader.readLine();
        linenum += 1;
        addNonVegan(content);
        content = reader.readLine();
        linenum += 1;
        addVegan(content);

        content = reader.readLine();
        if(!content.equals("")) {
            throw new PizzaFormatException("second line is not empty reader (2)", linenum);
        }

        for (int i = 0 ; i < numOfPizza; i++) {
            content = reader.readLine();
            if(content != null) { // iterate though each pizza
                linenum += 1;
                try {
                    Menu.getInstance().registerMenuItem(makePizza(content, linenum));
                }
                catch (PizzaFormatException | TooManyToppingsException e) {
                    throw new PizzaFormatException("The pizza format is incorrect", linenum);
                }
            } else {
                throw new PizzaFormatException("missing pizza!", linenum);
            }
        }
        return Menu.getInstance();
    }

    private static void addNonVegan(String content) {
        String[] words = content.split(",");
        words = Arrays.stream(words).map(x -> x.trim()).toArray(String[]::new);
        for (int i = 0; i < words.length; i++) {
            Topping.createTopping(words[i], false);
        }
    }
    private static void addVegan(String content) {
        String[] words= content.split(",");
        words = Arrays.stream(words).map(x -> x.trim()).toArray(String[]::new);
        for (int i = 0; i < words.length; i++) {
            Topping.createTopping(words[i], true);
        }
    }

    private static MenuItem makePizza(String content, int linenum) throws PizzaFormatException, TooManyToppingsException {
        int pos = content.indexOf("[");
        if(pos == -1) {
            throw new PizzaFormatException("missing [",linenum);
        }
        String[] words = new String[2];
        words[0] = content.substring(0,pos -1);
        words[1] = content.substring(pos+1,content.length() -1);
        //Arrays.stream(words).peek(System.out::print);

        if (words.length < 2 || words.length > 2) {
            throw new PizzaFormatException("incorrect pizza declaration", linenum);
            //System.out.println("word < 2");
        }
        String name = words[0];
        List<String> ingredients= Arrays.asList(words[1].split(", "));
        if(ingredients.size() > Pizza.MAX_TOPPINGS) {
            throw new TooManyToppingsException("To many topping is add in a file");
        }
        List<Topping> toppings = new ArrayList<>();
        for(String str : ingredients) {
            if(Topping.valueOf(str) instanceof Topping) {
                toppings.add(Topping.valueOf(str));
            } else {
                throw new PizzaFormatException("incorrect topping input", linenum);
            }
        }
        MenuPizza pizza = new MenuPizza(Bases.BaseSize.MEDIUM,
                Sauces.Sauce.TOMATO, Cheeses.Cheese.MOZZARELLA,toppings);
        return pizza;
    }
}
// make word uppercase
// trim
//