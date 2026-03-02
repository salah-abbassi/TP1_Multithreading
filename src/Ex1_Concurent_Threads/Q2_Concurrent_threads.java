package Ex1_Concurent_Threads;


public class Q2_Concurrent_threads {

    public static void main(String[] args){
        Thread T1 = new Thread_Numbers() ;
        Thread T2 = new Thread_Latteres();

        T1.start();
        T2.start();
    }

}
