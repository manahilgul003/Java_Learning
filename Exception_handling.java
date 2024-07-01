import java.util.Scanner; 
import java.util.*;
import java.io.*;

public class Exception_Handling{

    static Scanner userInput = new Scanner(System.in);
     
    public static void main(String[] args) {
        divideByZero(2);
         
        System.out.print("How old are you? ");
        int age = checkValidAge();
         
        if (age != 0) {
            System.out.println("You are " + age + " years old");
        }
         
        getAFile("./somestuff.txt");
    }
     
    public static void divideByZero(int a) {
        try {
            // The following throws an error because you can't divide by zero
            // Exception in thread "main" java.lang.ArithmeticException
            System.out.println(a/0);
        }
       
        catch (ArithmeticException e) {

            System.out.println("You can't divide by zero");

            System.out.println(e.getMessage());
    
            System.out.println(e.toString());
         
            e.printStackTrace();
        }
    }
     
    public static int checkValidAge() {
        try {
            return userInput.nextInt();
        }
        catch (InputMismatchException e) {
            userInput.next(); // Skips the last user input and waits for the next
            System.out.print("That isn't a whole number");
            return 0;
        }
    }
     
    /* If you prefer to throw an exception to the calling method you use throw
     * public static void getAFile(String fileName) throws IOException, FileNotFoundException
     * {
     *      FileInputStream file = new FileInputStream(fileName);
     * }
     *
     * If main called this method, main would have to handle the exception
     *
     * public static void main(String[] args) {
     *      try {
     *          getAFile("./somestuff.txt");
     *      }
     *      catch(IOException e) {
     *          System.out.println("An unknown IO Error Occured");
     *      }
     * }
     */
     
    public static void getAFile(String fileName) {
        try {
        
            FileInputStream file = new FileInputStream(fileName);
        }
        catch (FileNotFoundException e) {
            System.out.println("Sorry I couldn't find that file");
        }
       
        catch (IOException e) { // Catches any IO Exception
            System.out.println("An unknown IO Error Occured");
      
        // This will catch any exception (This should always be last)
        catch (Exception e) {
            System.out.println("I catch every exception");
        }

        finally {
            System.out.println("");
        }
    }
}
