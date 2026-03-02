package Ex2_Gestion_CompteBancaire;

public class MethodeSyncronizer {
    public static void main(String[] args) throws InterruptedException {
        Compte compte = new Compte();
        JobAhmedEtFatima job = new JobAhmedEtFatima(compte, compte::retirerSynchronized);

        Thread ahmed = new Thread(job, "Ahmed");
        Thread fatima = new Thread(job, "Fatima");

        ahmed.start();
        fatima.start();

        ahmed.join();
        fatima.join();

        System.out.println("SOLDE FINAL (synchronized) = " + job.soldeFinal());
        System.out.println("Remarque: check+sleep+retrait sont atomiques => pas d'incohérence.");
    }
}
