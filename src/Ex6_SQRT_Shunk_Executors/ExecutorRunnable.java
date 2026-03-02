package Ex6_SQRT_Shunk_Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorRunnable{
    public static void main(String[] args) throws InterruptedException {
        boolean print = args.length == 0 || !"--quiet".equalsIgnoreCase(args[0]);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        int chunkSize = 10000;
        long t0 = System.currentTimeMillis();
        for (int start = 0; start <= 50000; start += chunkSize) {
            final int s = start;
            final int e = Math.min(50000, s + chunkSize - 1);
            pool.submit(() -> {
                for (int i = s; i <= e; i++) {
                    double r = Sqrt_Newtonienne.sqrt(i);
                    if (print) {
                        System.out.println(Thread.currentThread().getName()
                                + " -> sqrt(" + i + ") = " + r);
                    }
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.MINUTES);
        long t1 = System.currentTimeMillis();
        System.out.println("Temps ExecutorService + Runnable (ms) = " + (t1 - t0)
                + (print ? " (affichage non ordonné)" : " (sans affichage)"));
    }
}

