package concurrent;

public class ThreadController {
    Thread th1;
    Thread th2;
    public void createThread(){
        th1 = new Thread(() -> {
            for (int i = 0; i <= 100; i++){
                System.out.println(th1.getName() + " : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void createThreadWithPriority(){
        th2 = new Thread(() -> {
            for (int i = 0; i <= 100; i++){
//                try {
//                    th1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(th2.getName() + " : " + i);
            }
        });
    }

    public static void main(String[] args) {
        ThreadController tc = new ThreadController();
        tc.createThread();
        tc.createThreadWithPriority();
        tc.th1.start();
        tc.th2.start();
    }
}
