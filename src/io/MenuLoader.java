package io;

import exceptions.PizzaFormatException;
import exceptions.TooManyToppingsException;
import menu.Menu;
import menu.MenuItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
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

    static final String PATH = "./src/assets/";
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
            reader = new BufferedReader(new FileReader(filename));
            getMenu(reader);
        }
        catch (FileNotFoundException e){
            System.exit(1);
        }
        catch (PizzaFormatException e2){
            System.exit(2);
        }
        /*catch (TooManyToppingsException e3){
            System.exit(4);
        }*/

        return Menu.getInstance();
    }

    /**
     * Used by the load method to manage the parsing of the loaded data.
     * The PizzaMenu.txt file content consists of the following formatted text:
     * The first-string token is a string with no spaces and must be the name of the file (excluding the .txt file type)
     * i.e. if the file is called PizzaMenu.txt then the first string would be PizzaMenu.
     * On the same line separated by a space is a number (an integer value)
     * representing the number of pizza menu items that are available within the given file.
     * This number reflects the number of lines the file reader will read to obtain all the pizzas provided.
     * Then, following the first line, is an empty line.
     * Each subsequent pizza menu item is provided on its own line.
     * A line is a string of text that is separated by the carriage return or separated by an empty line.
     * For each pizza menu item, a line of text is formatted in the following style:
     * ‘Pizza Name’ which can include spaces and is written with a Title Format.
     * A title format means that each new word starts with a capital letter and is followed by lowercase letters.
     * This will not be tested for programmatically, but is expected for style paints when marked.
     *
     * For example: Title Format String Of Words.
     * The menu item pizza name is followed by a space and an opening square bracket `[`.
     * This is then followed by a list of pizza toppings separated by commas, and finally a closing square bracket `]`.
     * The next menu pizza item is listed on the next line, and so on.
     * The list of toppings is provided in lower case.
     * However, care must be taken to read the text-file with any character-case type provided.
     * The following is an example of a menu text file called PizzaMenu.txt that contains two menu items:
     *          PizzaMenu 2
     *
     *          Flaming Hot [chillies, jalapenos, habanero, carolina reapers, red onions]
     *          Meat Feast [bacon, pepperoni, sausage, beef, chicken]
     *
     * Given the importance of the menu, within the confines of the Pizza company
     * If the menu loading mechanism experiences a failure in loading or parsing,
     * then the application is to exit, by providing an appropriate exit integer code
     * stored in an anonymous class within MenuLoader called Because.
     * This is not mandatory but provides a developer friendly mechanism for debugging.
     * Here is an example for the constant variable names:
     * These values will assist you with the expected exit codes
     * in the load(String) method exit specification.
     *          COULD_NOT_OPEN_FILE = 1
     *          FILE_FORMAT_ERROR = 2
     *          TOO_MANY_TOPPINGS = 4
     *          MISSING_NUMBER_OF_PIZZAS = 5
     *          CANNOT_READ_LINE = 6
     * @param reader BufferedReader used to read file
     * @return Menu item that has loaded all the pizza's from the file
     * @throws PizzaFormatException  if the text file reading is malformed, such as if there are no lines in the file,
     * or the file does not begin with the filename provided, if the space is missing after the name,
     * or if the initial filename is incorrect, or if the number of pizzas is missing,
     * or if the line space separating the first line and the pizzas is missing,
     * or if the second line has information other than an empty line,
     * or if the topping cannot be added to the Toppings list,
     * or if the number of toppings found exceed the maximum allowable toppings
     * as defined by the static variable Pizza.MAX_TOPPINGS,
     * or if the reader could not read a line. or generally any issue that inhibits the text file to be parsed.
     */
    public static Menu getMenu(BufferedReader reader)
            throws PizzaFormatException {
        if(reader.equals(null)) System.exit(1);
        String content = "";
        Scanner string = new Scanner(reader.toString());
        Pattern pattern = Pattern.compile("Pizza [0-9]", Pattern.CASE_INSENSITIVE);

        content = string.nextLine();
        Matcher matcher = pattern.matcher(content);
        Boolean found = matcher.find();
        if(string.hasNext() == false || !found) {
            throw new PizzaFormatException("file have no line!",118);
        }

        // Take second parameter of content split by blank space (the number of Pizza)
        int numOfPizza = Integer.parseInt(Arrays.stream(content.split(" ")).toArray()[1].toString());
        content = string.nextLine();
        if(content != "") {
            throw new PizzaFormatException("second line is not empty string",132);
        }
        for (int i = 0 ; i < numOfPizza; i++) {
            if(string.hasNext()) {
                content = string.nextLine();
                // iterate though each pizza
            } else {
                throw new PizzaFormatException("missing pizza!",136);
            }
        }
        return Menu.getInstance();
    }
    private void helper(String content) throws PizzaFormatException {
        String[] words = content.split(" \\p{Punct}");
        //Arrays.stream(words).peek(System.out::print);
        words[1]= words[1].substring(0,words[1].length() -1);

        if (words.length < 2) {
            throw new PizzaFormatException("incorrect pizza declaration",2);
            //System.out.println("word < 2");
        }
        String name = words[0];
        String[] ingedients = words[1].split(", ");

    }
}
