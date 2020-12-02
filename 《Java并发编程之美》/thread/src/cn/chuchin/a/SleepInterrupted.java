package cn.chuchin.a;

/**
 * @ClassName SleepInterrupted
 * @Author ChinHeng-Chu
 * @Date 2020/12/1 21:29
 * @Description SleepInterrupted
 * @Version 1.0
 */
public class SleepInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child threadA is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child threadA is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(2000);
        //主线程中断子线程
        threadA.interrupt();
    }
}
