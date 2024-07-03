public class create_thread extends Thread
{
public void run()
{
for(int i=0; ;i++)
 {System.out.println("This code is running in a thread");}
}
}
public static void main(String[] args) {
// TODO Auto-generated method stub
create_thread thread = new create_thread1();
 thread.start();
 for(int i=0; ; i++)
System.out.println("This code is outside of the thread");
}
}
