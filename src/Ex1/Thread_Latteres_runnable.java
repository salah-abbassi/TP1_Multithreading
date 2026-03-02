package Ex1;

public class Thread_Latteres_runnable implements Runnable {
    @Override
    public  void run(){
        for (char i = 'A';i<='Z' ;i++){
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
