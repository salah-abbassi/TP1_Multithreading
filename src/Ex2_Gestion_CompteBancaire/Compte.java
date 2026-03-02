package Ex2_Gestion_CompteBancaire;

import java.util.concurrent.locks.ReentrantLock;

public class Compte {
    private int solde = 1000;
    private final ReentrantLock lock = new ReentrantLock();

    public int getSolde() {
        return solde;
    }

    public boolean SimpleRetirer(int montant, String who) {
        if (solde < montant) {
            System.out.println(who + " -> solde insuffisant (" + solde + "), retrait refusé");
            return false;
        }
        dormir(200);
        solde -= montant;
        System.out.println(who + " -> retrait " + montant + " OK, nouveau solde est =" + solde);
        return true;
    }

    public synchronized boolean retirerSynchronized(int montant, String who) {
        if (solde < montant) {
            System.out.println(who + " -> solde insuffisant (" + solde + "), retrait refusé");
            return false;
        }
        dormir(200);
        solde -= montant;
        System.out.println(who + " -> retrait " + montant + " OK, nouveau solde est =" + solde);
        return true;
    }

    public boolean retirerWithLock(int montant, String who) {
        lock.lock();
        try {
            if (solde < montant) {
                System.out.println(who + " -> solde insuffisant (" + solde + "), retrait refusé");
                return false;
            }
            dormir(200);
            solde -= montant;
            System.out.println(who + " -> retrait " + montant + " OK, nouveau solde=" + solde);
            return true;
        } finally {
            lock.unlock();
        }
    }

    private static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

