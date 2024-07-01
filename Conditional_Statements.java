public class Conditional_Statements{
    public static void main(String[] args) {
    
        int randomNumber = (int) (Math.random() * 50);

        if (randomNumber < 25) {
            System.out.println("The random number is less than 25");
        }
      
        else if (randomNumber > 25) {
            System.out.println("The random number is greater than 25");
        }
   
        else if (randomNumber == 25) {
            System.out.println("The random number is equal to 25");
        }
     
        else if (randomNumber != 15) {
            System.out.println("The random number is not equal to 15");
        }

        else if (randomNumber <= 25) {
            System.out.println("The random number is less than or equal to 25");
        }
        else if (randomNumber >= 25) {
            System.out.println("The random number is greater than or equal to 25");
        }
        else {
            System.out.println("The random number is " + randomNumber);
        }
         

        System.out.println("The random number is " + randomNumber);
       
         
        if (!(false)) {
            System.out.println("I turned false into true");
        }
         
        if ((false) && (true)) {
            System.out.println("\nBoth are true");
        }
   
        if ((true) || (true)) {
            System.out.println("\nAt least 1 are true");
        }
      
         
        if ((true) ^ (false)) {
            System.out.println("\n1 is true and the other false");
        }
         
        int valueOne = 1;
        int valueTwo = 2;
     
        int biggestValue = (valueOne > valueTwo) ? valueOne : valueTwo;
         
        System.out.println(biggestValue + " is the biggest\n");
         
        char theGrade = 'B';
  
        switch (theGrade) {
        case 'A':
            System.out.println("Great Job");
            break; 
        case 'b':
        case 'B':
            System.out.println("Good Job, get an A next time");
            break;
        case 'C':
            System.out.println("OK, but you can do better");
            break;
        case 'D':
            System.out.println("You must work harder");
            break;
        default:
            System.out.println("You failed");
            break;
        }
    }
}
