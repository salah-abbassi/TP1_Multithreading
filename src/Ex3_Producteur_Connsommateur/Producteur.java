package Ex3_Producteur_Connsommateur;
import java.util.concurrent.atomic.AtomicInteger;

public class Producteur implements Runnable {
    private static final AtomicInteger GLOBAL_ID = new AtomicInteger(0);

    private final File<Integer> file;
    private final int Combient;
    private final int producerId;

    public Producteur(File<Integer> file, int Combient) {
        this.file = file ;
        this.Combient = Combient;
        this.producerId = GLOBAL_ID.incrementAndGet();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            for (int i = 1; i <= Combient; i++) {
                int element = producerId * 1_000_000 + i;
                file.Deposer(element, name);
                Thread.sleep((long)(Math.random() * 70) + 10);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
