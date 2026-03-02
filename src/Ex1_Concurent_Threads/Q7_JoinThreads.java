package Ex1_Concurent_Threads;

public class Q7_JoinThreads {
        public static void main(String[] args) throws InterruptedException {
            Thread numbers = new Thread(new Thread_Numbers_runnable());
            Thread letters = new Thread(new Thread_Latteres_runnable());

            numbers.start();
            numbers.join(); // le thread main attend la fin de numbers

            letters.start();
            letters.join();

        }
    }

