package Ex3_Producteur_Connsommateur;

public class Consommateur implements Runnable {
    private final File<Integer> file;
    private final int Combient;

    public Consommateur(File<Integer> file, int Combient) {
        this.file = file;
        this.Combient = Combient;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            for (int i = 1; i <= Combient; i++) {
                file.Retirer(name);
                Thread.sleep((long)(Math.random() * 70) + 10);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


