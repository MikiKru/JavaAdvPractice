package threads;

import java.util.Arrays;

public class ThreadController extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        String [] names = {"Ala", "Ola", "Ela", "Adam", "Jan"};
        Arrays.stream(names).forEach(System.out::println);
        ThreadController tc1 = new ThreadController();
        ThreadController tc2 = new ThreadController();
        ThreadController tc3 = new ThreadController();
        ThreadController tc4 = new ThreadController();
        tc1.start();
        tc2.start();
        tc3.start();
        tc4.start();


    }
}
