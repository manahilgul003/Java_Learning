import java.util.*;

public class Preliminaries {
   static public String myString="I am an Emumba intern";
   static final double Pi_Num=3.14;
   
    public static void main(String[] args) {
      System.out.println(myString);
      int int1,int2;
      int1=22;
      int2=int1+334;
      System.out.println("The final answer is "+int2);
      char myChar=66;
      
      String anotherString="My name is Manahil";
      String merge_String="and i love to Code";
      System.out.println(anotherString+'\\'+merge_String);
      System.out.println(anotherString+'\t'+merge_String);
      System.out.println(anotherString+'\b'+merge_String);
      System.out.println(anotherString+'\n'+merge_String);
      System.out.println(myChar);
      System.out.println(Pi_Num);
      System.out.println("Max Value of Float "+Float.MAX_VALUE);
      System.out.println("Max Value of Byte "+Byte.MAX_VALUE);
      System.out.println("Max Value of Double "+Double.MAX_VALUE);
      
      //String Type Casting)
     
      double aDoubleValue=3.14546466464;
      int doubleToInt=(int)aDoubleValue;
      System.out.println(doubleToInt);
      
      int StringToInt=Integer.parseInt(myString);
      
      
  }
