package threads;

import java.time.Duration;
import java.time.LocalTime;

public class SequenceController {
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        LocalTime stop = LocalTime.now();
        Duration p = Duration.between(start, stop);
        System.out.println("Czas wykonywania: " + p.toMillis() + "ms");
    }
}
