package Ex3_Producteur_Connsommateur;

public class Main {
        public static void main(String[] args) throws InterruptedException {
            File<Integer> file = new File<>(5);

            int perProducer = 2;
            int producers = 2;
            int total = perProducer * producers;
            int perConsumer = total / 2;

            Thread p1 = new Thread(new Producteur(file, perProducer), "Producteur-1");
            Thread p2 = new Thread(new Producteur(file, perProducer), "Producteur-2");

            Thread c1 = new Thread(new Consommateur(file, perConsumer), "Consommateur-1");
            Thread c2 = new Thread(new Consommateur(file, perConsumer), "Consommateur-2");

            p1.start();
            p2.start();
            c1.start();
            c2.start();

            p1.join();
            p2.join();
            c1.join();
            c2.join();

            System.out.println("Done (producteurs /conssommateurs fini).");
        }
    }
