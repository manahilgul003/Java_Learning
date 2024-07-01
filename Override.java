public class Override{
    public static void main(String[]args){
        Dog d=new Chiuahua();
        d.Bark();
       
        
    }
}
public class Dog{
    public void Bark(){
        System.out.println("bark bark")
        
        
    }
    public void poop(){
        System.out.println("The Dog is pooping");
        
    }
    
}
public class Chiuahua extends Dog{
    public void Bark(){
        System.out.println("yip yip")
        
    }
}
