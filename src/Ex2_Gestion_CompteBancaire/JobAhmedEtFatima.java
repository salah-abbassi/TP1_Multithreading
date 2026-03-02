package Ex2_Gestion_CompteBancaire;


import java.util.concurrent.ThreadLocalRandom;

public class JobAhmedEtFatima implements Runnable {
    private final Compte compte;
    private final Withdrawal withdrawal;
    private final int attempts;

    public JobAhmedEtFatima(Compte compte, Withdrawal withdrawal) {
        this(compte, withdrawal, 10);
    }

    public JobAhmedEtFatima(Compte compte, Withdrawal withdrawal, int attempts) {
        this.compte = compte;
        this.withdrawal = withdrawal;
        this.attempts = attempts;
    }

    @Override
    public void run() {
        // Comportement: effectuer en boucle des retraits de 10
        for (int i = 0; i < attempts; i++) {
            doRetrait(10);
            dormir(ThreadLocalRandom.current().nextInt(0, 30)); // bruit (facilite l'entrelacement)
        }
    }

    public boolean doRetrait(int montant) {
        String who = Thread.currentThread().getName();
        return withdrawal.retirer(montant, who);
    }

    public int soldeFinal() {
        return compte.getSolde();
    }

    private static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


