package Ex2;

@FunctionalInterface
public interface Withdrawal {
    boolean retirer(int montant, String who);
}
