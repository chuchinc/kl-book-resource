package cn.chuchin.a;

/**
 * @ClassName InterruptedJudge
 * @Author ChinHeng-Chu
 * @Date 2020/12/2 22:15
 * @Description InterruptedJudge
 * @Version 1.0
 */
public class InterruptedJudge {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断则退出循环
                while (! Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread interrupt thread");
        thread.interrupt();
        thread.join();
        System.out.println("main is over");
    }
}
