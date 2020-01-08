package threads;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;

public class ThreadController extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LocalTime start = LocalTime.now();
        ThreadController tc1 = new ThreadController();
        ThreadController tc2 = new ThreadController();
        ThreadController tc3 = new ThreadController();
        ThreadController tc4 = new ThreadController();
        tc1.start();
        tc2.start();
        tc3.start();
        tc4.start();
        // join() -> determinuje ropoczęcie działania po wykonaniu wątku
        tc1.join();
        tc2.join();
        tc3.join();
        tc4.join();
        LocalTime stop = LocalTime.now();
        Duration p = Duration.between(start, stop);
        System.out.println("Czas wykonywania: " + p.toMillis() + "ms");

    }
}
