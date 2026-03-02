package Ex2_Gestion_CompteBancaire;

public class MethodeSimple {
    public static void main(String[] args) throws InterruptedException {
        Compte compte = new Compte();
        JobAhmedEtFatima job = new JobAhmedEtFatima(compte, compte::SimpleRetirer);

        Thread ahmed = new Thread(job, "Ahmed");
        Thread fatima = new Thread(job, "Fatima");

        ahmed.start();
        fatima.start();

        ahmed.join();
        fatima.join();

        System.out.println("SOLDE FINAL (unsafe) = " + job.soldeFinal());
        System.out.println("Remarque: vous pouvez observer un solde incohérent (race condition).");
    }
}
