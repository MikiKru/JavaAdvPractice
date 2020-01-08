package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadLambda {
    Thread th1;
    Thread th2;
    List<Integer> randomNumberes = new ArrayList<>();
    // losuje 10 liczb  (0 - 1000) i zapisuje je w Liście
    private void createThread1(){
        th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(randomNumberes.size() <= 100){
                    randomNumberes.add(new Random().nextInt(1001));
                    System.out.println(th1.getName() + " dodaje liczbę " + randomNumberes.get(randomNumberes.size()-1));
                }
            }
        }, "Thread1");
    }
    // losuje liczby od -1000 do -1 i dodaje do tej samej listy
    private void createThread2(){
        th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(randomNumberes.size() <= 100){
                    randomNumberes.add(new Random().nextInt(1000) - 1000);
                    System.out.println(th1.getName() + " dodaje liczbę " + randomNumberes.get(randomNumberes.size()-1));
                }
            }
        }, "Thread2");
    }
}
