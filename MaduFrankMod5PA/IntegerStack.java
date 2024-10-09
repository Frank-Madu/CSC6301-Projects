import java.util.Stack;
import java.util.Collections;
import java.util.Scanner;

/**
 * Frank Madu
 * CSC6301 Project 5
 * 
 * IntegerStack.java
 * 
 * This program is based on the design from Project 4, which used a linked list
 * to store and sort integers with utilities from the Collections library. In 
 * this project, a stack is used instead of a linked list to store the integers.
 * 
 * The IntegerStack class provides a simple program that accepts a list of integers 
 * from user input, checks the validity of the input, and sorts the integers in ascending order 
 * before outputting it.
 *
 * Program Flow Process:
 * 1. Prompt the user for input (list of numbers separated by white space).
 * 2. Validate the input:
 *    - Check for empty input.
 *    - Parse integers and handle exceptions for invalid inputs.
 * 3. Sort the valid integers using Collections.sort().
 * 4. Output the sorted list.
 *
 * Key Classes:
 * - Stack: This class is used to store integers in a last-in-first-out (LIFO) order.
 * - Collections: This class provides the sort method to order the integers.
 * - Scanner: This class is used to capture user input, facilitating interaction within the program.
 *
 * Error Handling:
 * - If the input is invalid, the program informs the user and prompts for new input.
 * - The stack is cleared and repopulated upon receiving invalid entries.
 */

public class IntegerStack {
    
    /**
     * The main method serves gateway to initiate the program. It prompts the user to input 
     * a list of integers (with spaces between), checks if the input is valid, and displays 
     * the sorted stack of integers.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter a list of integers separated by a whitespace: "); // Ex: input: 1 2 3 4 5
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue; // Restarts the loop if input is empty
            }
            

            String[] new_input = input.split(" "); // Converts input into an array with string type elements
            boolean validInput = true; // Used to check if all elements from input are valid; Variable is intialized to true
            
            // Error Handling for checking if every element from input is an integer through try-catch
            for (String c : new_input) {
                try {
                    integerStack.push(Integer.parseInt(c)); // Converts the string element to an integer representation if possible
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for the element: " + c);
                    System.out.println("Please try again.");
                    validInput = false; // Set variable to false if an invalid input was found
                    break; // Exits the for loop after invalid input was found
                }
            }
            
            if (validInput) {
                break; // Exits the while loop if all input elements are valid
            } else {
                integerStack.clear(); // Clear the list if an invalid input was found; Restarts the while loop
            }
        }
        System.out.println("Original Stack: " + integerStack);
        Collections.sort(integerStack);
        System.out.println("Sorted Stack: " + integerStack);
        scanner.close();
    }
}



/**
 * Code reuse in the IntegerStack program is demonstrated through the utilization of built-in classes and methods from the Java library. 
 * For example, the Stack class is used to create and manage a collection of integers, allowing for straightforward additions and removals of 
 * values without requiring the implementation of additional code. By leveraging the capabilities of the Stack, the program benefits from 
 * optimized methods for handling dynamic collections. Furthermore, the inclusion of the Collections.sort() method streamlines the sorting process, 
 * eliminating the need to develop a custom sorting algorithm and ensuring that the code remains concise and efficient. 
 * 
 * Additionally, the program employs the Scanner class to capture user input and demonstrate how existing tools can enhance coding productivity 
 * and efficiency. By using this utility, the program simplifies the process of reading input from the user and automatically handles potential 
 * errors when capturing the input, such as empty entries or invalid data formats, through exception handling. This reliance on standard Java 
 * libraries not only minimizes the amount of code written but also increases the reliability of the program, as these libraries are well-tested 
 * and widely used. Overall, the effective use of these built-in classes illustrates the advantages of code reuse in reducing development time while 
 * improving code quality and maintainability.
 */
