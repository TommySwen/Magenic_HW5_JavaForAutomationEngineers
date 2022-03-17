package models;

import resources.Inputs;
import utils.UserHelperMethods;
import java.util.*;

/**
 * This is a console application for a movie store
 */
public class MovieStore {

    /**
     * Movie database instance
     */
    MovieDatabase db;

    /**
     * An array list to represent the cart at a movie store
     */
    ArrayList cart;

    /**
     * Creates instance of the movie store
     */
    public MovieStore(){
        // Creates new movie database
        this.db = new MovieDatabase();
        // Creates new cart
        this.cart = new ArrayList();
    }

    /**
     * Returns the current state of the cart for the movie store
     * @return Array list representing the cart
     */
    public ArrayList getCart(){
        return this.cart;
    }

    /**
     * Adds a movie or show to the cart
     * @param media The show or movie to be added to the cart
     */
    public void addToCart(VideoMedia media){
        this.cart.add(media);
    }

    /**
     * Removes a movie or show from the cart at an index
     * @param indexToRemove Index of the movie or show to be removed from the cart
     */
    public void removeFromCart(int indexToRemove){
        this.cart.remove(indexToRemove);
    }

    /**
     * Displays the main menu and handles user choice
     */
    public void mainMenu(){
        String selection = UserHelperMethods.displayOptionsAndWaitForValidOption(Inputs.MAIN_MENU_OPTIONS);
        if (selection.equals("Checkout")){
            checkoutMenu();
        } else if(selection.equals("View Cart")){
            viewCartMenu();
        } else if (selection.equals("Browse")){
            browseMenu();
        } else if(selection.equals("Quit")){
            quit();
        }
    }

    /**
     * Print the current cart to the console
     */
    public void printCart(){
        System.out.println("Current Cart: ");
        UserHelperMethods.printArray(getCart());
        System.out.println();
    }

    /**
     * Display the checkout menu options and handle user choice
     */
    public void checkoutMenu(){
        String selection = UserHelperMethods.displayOptionsAndWaitForValidOption(Inputs.CHECKOUT_OPTIONS);
        if(selection.equals("Confirm")){
            System.out.println("Enjoy the movies. Bye");
        }
        else if(selection.equals("Back")){
            mainMenu();
        }
    }

    /**
     * Displays the cart menu and handles user choice
     */
    public void viewCartMenu(){
        printCart();
        String selection = UserHelperMethods.displayOptionsAndWaitForValidOption(Inputs.VIEWING_CART_OPTIONS);
        if(selection.equals("Remove Movie")){
            int removeSelection = UserHelperMethods.displayMoviesAndWaitForValidOption(this.cart);
            removeFromCart(removeSelection);
            mainMenu();
        }
        else if(selection.equals("Checkout")){
            checkoutMenu();
        }
        else if(selection.equals("Back")){
            mainMenu();
        }
    }

    /**
     * Displays the add movie menu with information about the current movie selected and handles user choice
     * @param movie the movie to be displayed and then added if the user chooses
     */
    public void addMovieMenu(VideoMedia movie){
        System.out.println("Title: " + movie.getTitle());
        System.out.println("length: " + movie.getLength());
        System.out.println("Availability: " + movie.getAvailable());
        if(movie.getAvailable()){
            String selection = UserHelperMethods.displayOptionsAndWaitForValidOption(Inputs.ADD_MOVIE_OPTIONS);
            if(selection.equals("Add Movie")){
                addToCart(movie);
            }
        }
        else {
           System.out.println("Movie Unavailble");
        }
        mainMenu();
    }

    /**
     * Display te browse menu and handle user choice
     */
    public void browseMenu(){
        String selection = UserHelperMethods.displayOptionsAndWaitForValidOption(Inputs.BROWSING_OPTIONS);
        System.out.println("this is search option? " + selection);
        if(selection.equals("Search")){
            searchMenu();
        }
        else if(selection.equals("Random")){
            addMovieMenu(db.random());
        }
        else if(selection.equals("Back")){
            mainMenu();
        }
    }

    /**
     * Search the movie database for a movie which has the given title
     * @param title The title of the movie to search for in the database
     * @return Weather or not the movie is present in the database
     */
    public boolean search(String title){
        return db.contains(title);
    }

    /**
     * Display the search menu and handle user choice
     */
    public void searchMenu(){
        System.out.println("Enter movie name to search: ");
        String selection = UserHelperMethods.getInput();
        if(search(selection)){
            addMovieMenu(db.getMedia(selection));
            System.out.println("Movie added");
        }
        else{
            System.out.println("movie not in database");
        }
        mainMenu();
    }

    /**
     * print a goodbye message and dont prompt user for another input
     */
    public void quit(){
        System.out.println("Goodbye");
    }

    /**
     * Main method for the console app
     * @param args List of arguments
     */
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        movieStore.db.addMovie(new Movie("Harry Potter and the Sorcer's Stone", "151", true));
        movieStore.db.addMovie(new Movie("Pirates of the Caribbean: At Worlds End", "170", true));
        movieStore.db.addMovie(new Movie("It","192", true));
        movieStore.db.addMovie(new Movie("Gone with the Wind", "238", false));

        movieStore.db.addMovie(new Show("Star Treck", "792", true));
        movieStore.db.addMovie(new Show("Peanuts", "207", true));
        movieStore.db.addMovie(new Show("It's Always Sunny in Philadelphis", "154", false));

        movieStore.mainMenu();
    }

}