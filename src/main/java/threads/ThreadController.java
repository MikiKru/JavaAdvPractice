package threads;

import java.util.Arrays;

public class ThreadController extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        String [] names = {"Ala", "Ola", "Ela", "Adam", "Jan"};
        ThreadController tc = new ThreadController();
        tc.start();
        Arrays.stream(names).forEach(System.out::println);

    }
}
