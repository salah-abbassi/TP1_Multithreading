package Ex1_Concurent_Threads;

public class Q4_Concurent_threads_Runnable {
    public static void main(String[] args){
        Runnable r1 = new Thread_Numbers_runnable();
        Runnable r2 = new Thread_Latteres_runnable();
        Thread T1 = new Thread(r1);
        Thread T2 = new Thread(r2);


        T1.start();
        T2.start();


    }
}
