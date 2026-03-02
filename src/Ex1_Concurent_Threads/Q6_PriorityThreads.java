package Ex1_Concurent_Threads;

public class Q6_PriorityThreads {

        public static void main(String[] args) {
            Thread letters = new Thread(new Thread_Latteres_runnable(), "T-LETTERS(MAX)");
            Thread numbers = new Thread(new Thread_Numbers_runnable(), "T-NUMBERS(MIN)");

            letters.setPriority(Thread.MAX_PRIORITY);
            numbers.setPriority(Thread.MIN_PRIORITY);

            numbers.start();
            letters.start();

            System.out.println("Priorities set: letters=" + letters.getPriority() + ", numbers=" + numbers.getPriority());
            System.out.println("Remarque: la priorité influence parfois, mais ne garantit pas l'ordre (dépend JVM/OS).");
        }
}

