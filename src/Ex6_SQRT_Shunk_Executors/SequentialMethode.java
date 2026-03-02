package Ex6_SQRT_Shunk_Executors;

public class SequentialMethode {

        public static void main(String[] args) {
            boolean print = args.length == 0 || !"--quiet".equalsIgnoreCase(args[0]);
            long t0 = System.currentTimeMillis();
            for (int i = 0; i <= 50000; i++) {
                double r = Sqrt_Newtonienne.sqrt(i);
                if (print) {
                    System.out.println("sqrt(" + i + ") = " + r);
                }
            }
            long t1 = System.currentTimeMillis();
            System.out.println("Temps séquentiel (ms) = " + (t1 - t0)
                    + (print ? " (avec affichage)" : " (sans affichage)"));
        }
    }

