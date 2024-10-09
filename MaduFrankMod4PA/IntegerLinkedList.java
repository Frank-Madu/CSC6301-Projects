import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Frank Madu
 * CSC6301 Project 3
 * 
 * IntegerLinkedList.java
 * 
 * The IntegerLinkedList class provides a simple program that accepts a list of integers 
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
 * - LinkedList: This class is used to store integers dynamically.
 * - Collections: This class provides the sort method to order the integers.
 * - Scanner: This class is used to capture user input, facilitating interaction within the program.
 *
 * Error Handling:
 * - If the input is invalid, the program informs the user and prompts for new input.
 * - The linked list is cleared and repopulated upon receiving invalid entries.
 */

public class IntegerLinkedList {
    
    /**
     * The main method serves gateway to initiate the program. It prompts the user to input 
     * a list of integers (with spaces between), checks if the input is valid, and displays 
     * the sorted linked list of integers.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        LinkedList<Integer> IntegerList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter a list of integers separated by a whitespace: "); // Ex: input: 1 2 3 4 5
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue; // Restarts the loop if input is empty
            }
            

            String[] new_input = input.split(" ");
            boolean validInput = true; // Used to check if all elements from input are valid; Variable is intialized to true
            
            // Error Handling for checking if every element from input is an integer through try-catch
            for (String c : new_input) {
                try {
                    IntegerList.add(Integer.parseInt(c)); // Converts the string variable to an integer representation if possible
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
                IntegerList.clear(); // Clear the list if an invalid input was found; Restarts the while loop
            }
        }
        
        Collections.sort(IntegerList);
        System.out.println("Sorted Linked List: " + IntegerList);
        scanner.close();
    }
}



/**
 * Code reuse in the IntegerLinkedList program is demonstrated through the utilization of built-in classes and methods from the Java library. 
 * For example, the LinkedList class is used to create and manage a list of integers, allowing for straightforward additions and removals of 
 * values without requiring the implementation of additional code. By leveraging the capabilities of the LinkedList, the program benefits from 
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





 