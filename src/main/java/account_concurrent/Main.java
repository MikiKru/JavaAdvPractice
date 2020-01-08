package account_concurrent;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(10_000.);
        Client c1 = new Client(account);
        Client c2 = new Client(account);
        Client c3 = new Client(account);

        Thread th1 = new Thread(c1, "Client1");
        Thread th2 = new Thread(c1, "Client2");
        Thread th3 = new Thread(c1, "Client3");

        th1.start();
        th2.start();
        th3.start();
    }
}
