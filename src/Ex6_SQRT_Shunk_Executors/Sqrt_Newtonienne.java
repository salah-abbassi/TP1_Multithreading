package Ex6_SQRT_Shunk_Executors;

public class Sqrt_Newtonienne {

        private Sqrt_Newtonienne() {
            // Classe utilitaire : constructeur privé pour empêcher l'instanciation.
        }
    /**
     * Calcule une approximation de sqrt(n) avec la méthode de Newton-Raphson.
     *
     * @param n valeur dont on cherche la racine carrée (n >= 0)
     * @return approximation de sqrt(n)
     */
        public static double sqrt(double n) {
            if (n < 0) {
                throw new IllegalArgumentException("n doit être >= 0");
            }
            if (n == 0.0 || n == 1.0) {
                return n;
            }

            double x = n;
            double eps = 1e-10;

            for (int i = 0; i < 50; i++) {
                double next = 0.5 * (x + n / x);

                if (Math.abs(next - x) < eps) {
                    return next;
                }
                x = next;
            }

            return x;
        }
    }

