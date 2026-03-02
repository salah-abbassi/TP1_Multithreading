package Ex1_Concurent_Threads;

public class Q1_SequentialVersion {
    public static void main(String[] args) {

        for (int i = 1; i<=10; i++) {
            System.out.println("le nombre est :"+ i);
        }
        for (char i = 'A'; i<='Z'; i++) {
            System.out.println("la Letter est :"+ i);
        }
    }
}


