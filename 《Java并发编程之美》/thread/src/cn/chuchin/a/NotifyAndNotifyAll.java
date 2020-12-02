package cn.chuchin.a;

/**
 * @ClassName NotifyAndNotifyAll
 * @Author ChinHeng-Chu
 * @Date 2020/11/30 22:50
 * @Description NotifyAndNotifyAll
 * @Version 1.0
 */
public class NotifyAndNotifyAll {
    //创建资源
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取resourceA共享的监视器锁
                synchronized (resourceA) {
                    try {
                        System.out.println("ThreadA get resourceA lock");
                        System.out.println("ThreadA begin wait");
                        resourceA.wait();
                        System.out.println("ThreadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    try {
                        System.out.println("ThreadB get resourceA lock");
                        System.out.println("ThreadB begin wait");
                        resourceA.wait();
                        System.out.println("ThreadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
                    resourceA.notifyAll();
                }
            }
        });
        //启动线程
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }
}
