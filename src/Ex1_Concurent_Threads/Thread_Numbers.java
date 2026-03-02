package Ex1_Concurent_Threads;

public class  Thread_Numbers extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }

}
}
