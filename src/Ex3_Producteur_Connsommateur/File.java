package Ex3_Producteur_Connsommateur;
import java.util.LinkedList;

public class File<T> {
    private final LinkedList<T> file = new LinkedList<>();
    private final int capacity;

    public File(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("il faut que la capacity soit  > 0");
        }
        this.capacity = capacity;
    }

    public synchronized void Deposer(T element, String producerName) throws InterruptedException {
        while (file.size() == capacity) {
            System.out.println(producerName + " -> file pleine, en attente...");
            wait();
        }
        file.addLast(element);
        System.out.println(producerName + " -> produit: " + element + " (taille=" + file.size() + ")");
        notifyAll();
    }

    public synchronized T Retirer(String consumerName) throws InterruptedException {
        while (file.isEmpty()) {
            System.out.println(consumerName + " -> file vide, en attente...");
            wait();
        }
        T element = file.removeFirst();
        System.out.println(consumerName + " -> consomme: " + element + " (taille=" + file.size() + ")");
        notifyAll();
        return element;
    }
}


