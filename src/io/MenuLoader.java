package io;

import exceptions.PizzaFormatException;
import exceptions.TooManyToppingsException;
import menu.Menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
     * Constructor for Menuloader class
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
     * @param filename
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
        return Menu.getInstance();
    }

    public static void displayFileContent(String filename) {
        Scanner output = new Scanner(filename);
        while (output.hasNext()){
            System.out.print(output.next());
        }
    }
}
