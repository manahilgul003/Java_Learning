import java.util.Scanner;

public class Functions {
   
     
    static double myPI = 3.14159265;
     

     
    static int randomNumber;
     
    // Creates a Scanner object that monitors keyboard input
     
    static Scanner userInput = new Scanner(System.in);
     
    public static void main(String[] args) {
    
         
        System.out.println(addThem(1,2));
  
        int d = 5;
        
         
        tryToChange(d);
        System.out.println("Static Variable d = " + d);
     
        System.out.println("\n");
         
        System.out.println(getRandomNum());
         
        int guessResult = 1;
        int randomGuess = 0;
         
        while(guessResult != -1) {
            System.out.print("Guess a number between 0 and 50: ");

             
            randomGuess = userInput.nextInt();
             
            guessResult = checkGuess(randomGuess);
        }
         
        System.out.println("Yes the random number is " + randomGuess);
         
        System.out.println(randomNumber); // Random value was changed globally by getRandomNum
    }

     
    public static int addThem(int a, int b) {
        double smallPI = 3.140; // This variable is local to the addThem function
      
         
        System.out.println(Double.compare(smallPI, myPI));
         
        int c = a + b;
      
         
        return c;
    }
 
     
    public static void tryToChange(int d) {
        d = d + 1;
        System.out.println("tryToChange d = " + d);
    }
     
    public static int getRandomNum() {
        
         
        randomNumber = (int) (Math.random() * 51);
        return randomNumber;
    }
     
    public static int checkGuess(int guess) {
        if(guess == randomNumber) {
            return -1;
        } else {
            return guess; // Must return a value of type int
        }
    }
}
