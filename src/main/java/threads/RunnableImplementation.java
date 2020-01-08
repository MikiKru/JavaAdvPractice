package threads;

public class RunnableImplementation implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
    public static void main(String[] args) {
        Thread th1 = new Thread(new RunnableImplementation(), "MyThread1");
        Thread th2 = new Thread(new RunnableImplementation(), "MyThread2");
        Thread th3 = new Thread(new RunnableImplementation(), "MyThread3");
        Thread th4 = new Thread(new RunnableImplementation(), "MyThread4");
        th1.start();
        th2.start();
        th3.start();
        th4.start();

    }
}
