package cn.chuchin.a并发编程线程基础;

/**
 * @ClassName WaitNotifyInterrupt
 * @Author ChinHeng-Chu
 * @Date 2020/11/29 22:11
 * @Description WaitNotifyInterrupt
 * @Version 1.0
 */
public class WaitNotifyInterrupt {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("begin");
                    //阻塞当前线程
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("bengin interrupt thread");
        thread.interrupt();
        System.out.println("end interrupt");
    }
}
