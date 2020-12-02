package cn.chuchin.a;

/**
 * @ClassName InterruptedSleep
 * @Author ChinHeng-Chu
 * @Date 2020/12/2 22:25
 * @Description InterruptedSleep
 * @Version 1.0
 */
public class InterruptedSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("begin sleep");
                    Thread.sleep(2000000000);
                    System.out.println("awake");
                } catch (InterruptedException e) {
                    System.out.println("thread is interrupted while sleep");
                    return;
                }
                System.out.println("thread-leaving normally");
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
        System.out.println("main is over");
    }
}
