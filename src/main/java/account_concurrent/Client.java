package account_concurrent;

import java.util.Random;

public class Client implements Runnable {
    private Account account;

    public Client(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
        // klient wypłaca dowolną kwotę z zakresu
        // 0 - 3000
        for (int i = 0; i < 5; i++){
            account.pay((double) new Random().nextInt(3000)+ 1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
