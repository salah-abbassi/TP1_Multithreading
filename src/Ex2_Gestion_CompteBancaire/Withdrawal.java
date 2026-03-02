package Ex2_Gestion_CompteBancaire;

@FunctionalInterface
public interface Withdrawal {
    boolean retirer(int montant, String who);
}
