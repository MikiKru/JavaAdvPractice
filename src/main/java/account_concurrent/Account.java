package account_concurrent;

public class Account {
    private Double saldo;

    public Account(Double saldo) {
        this.saldo = saldo;
    }
    public synchronized void pay(Double amount){
        if(saldo >= amount){
            System.out.printf("%s : Wypłacono kwotę: %.2f\n",
                    Thread.currentThread().getName(),
                    amount);
            saldo -= amount;
        } else {
            System.out.printf("%s : Brak środków\n",
                    Thread.currentThread().getName());
        }
        System.out.println("Saldo: " + getSaldo());
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
