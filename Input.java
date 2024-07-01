/*public class Input {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Your Favourite Driver?");

      
        if (userInput.hasNext()) {
        
            String nameEntered = userInput.next();
 
            System.out.println("You Entered " + nameEntered);
            
        }
        else{
            System.out.println("Enter a string next time");
            
        }
    }
}*/
import java.util.Scanner;

public class Input {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please enter your favourite number? ");

        if (userInput.hasNextInt()) {

            int numberEntered = userInput.nextInt();

            System.out.println("You Entered " + numberEntered);
            int sum = numberEntered + numberEntered;
            int product = numberEntered * numberEntered;
            int divide = numberEntered / 2;
            int subtract = numberEntered - numberEntered;
            System.out.println(numberEntered + " + " + numberEntered + " = " + sum);
            System.out.println(numberEntered + " * " + numberEntered + " = " + product);
            System.out.println(numberEntered + " / 2 = " + divide);
            System.out.println(numberEntered + " - " + numberEntered + " = " + subtract);
        } else {
            System.out.println("Enter a string next time");
        }
    }
}


