package utils;

import models.VideoMedia;

import java.util.ArrayList;
import java.util.Scanner;

public class UserHelperMethods {

    /**
     * Prints the given array to the console
     * @param array The array to be printed
     */
    public static void printArray(String[] array) {
        // For each element in the array print the index and the element
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    /**
     * Prints the given options to the console and prompts the user
     * @param options The list of options
     */
    public static void printOptions(String[] options) {
        printArray(options);
        System.out.println("Enter the number of your selected option:");
    }

    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Displays the options and waits for the user to enter a valid options
     * @param options The array of options
     * @return The index of the selected option
     */
    public static String displayOptionsAndWaitForValidOption(String[] options) {
        // Initializes the scanner and defaults the option variable
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        // Prints the options
        printOptions(options);

        // An infinite to ensure the user selects a valid option
        do {
            // Reads the user input
            String input = scanner.nextLine();

            // Tries to parse the input to an integer
            try {
                option = Integer.parseInt(input);

                // If the option if not negative or outside the scope of the options, return that option as it is valid and ends the loop
                if (option >= 0 && option <= options.length) {
                    return options[option];
                }

                // Prints the options again as the input was not valid
                printOptions(options);
            } catch(NumberFormatException e) {
                // Catches any parsing error and re-prompts the user
                printOptions(options);
            }
        } while (true);
    }

    public static void printArray(ArrayList<VideoMedia> options){
        for(int i = 0; i < options.size(); i++){
            System.out.println(i + ": " + options.get(i).getTitle());
        }
    }

    /**
     * Displays the options and waits for the user to enter a valid options
     * @param options The array of movies
     * @return The index of the movie to be removed
     */
    public static int displayMoviesAndWaitForValidOption(ArrayList<VideoMedia> options) {
        // Initializes the scanner and defaults the option variable
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        // Prints the options
       printArray(options);


        // An infinite to ensure the user selects a valid option
        do {
            // Reads the user input
            String input = scanner.nextLine();

            // Tries to parse the input to an integer
            try {
                option = Integer.parseInt(input);

                // If the option if not negative or outside the scope of the options, return that option as it is valid and ends the loop
                if (option >= 0 && option <= options.size()) {
                    return option;
                }

                // Prints the options again as the input was not valid
                printArray(options);
            } catch(NumberFormatException e) {
                // Catches any parsing error and re-prompts the user
                printArray(options);
            }
        } while (true);
    }
}
