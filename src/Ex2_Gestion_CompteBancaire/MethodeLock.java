package Ex2_Gestion_CompteBancaire;

public class MethodeLock {
    public static void main(String[] args) throws InterruptedException {
        Compte compte = new Compte();
        JobAhmedEtFatima job = new JobAhmedEtFatima(compte, compte::retirerWithLock);

        Thread ahmed = new Thread(job, "Ahmed");
        Thread fatima = new Thread(job, "Fatima");

        ahmed.start();
        fatima.start();

        ahmed.join();
        fatima.join();

        System.out.println("SOLDE FINAL (ReentrantLock) = " + job.soldeFinal());
        System.out.println("Remarque: Lock offre plus de contrôle (tryLock, fairness, Condition) que synchronized.");
    }
}
