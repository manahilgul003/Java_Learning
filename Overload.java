public class Overload{
    public static void main (String[] arg){
        int result=addNumbers(3,2);
          double result2=addNumbers(3.5,2.8);
            int result3=addNumbers(3,2,3);
        System.out.println(result);
        System.out.println(result2);
          System.out.println(result3);
    }
    public static int addNumbers(int a,int b)
{ return a+b;
}
    public static double addNumbers(double  a,double b)
{ return a+b;
}
   public static int addNumbers(int a,int b,int c)
{ return a+b+c;
}

}
