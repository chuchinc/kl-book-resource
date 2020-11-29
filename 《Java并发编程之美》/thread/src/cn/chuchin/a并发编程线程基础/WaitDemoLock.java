package cn.chuchin.a并发编程线程基础;

/**
 * @ClassName WaitDemoLock
 * @Author ChinHeng-Chu
 * @Date 2020/11/29 21:03
 * @Description WaitDemoLock
 * @Version 1.0
 */
public class WaitDemoLock {

    //创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("ThreadA get resourceA lock");
                    //获取resourceB共享资源的监视器锁
                    synchronized (resourceB) {
                        System.out.println("ThreadA get resourceB lock");
                        //线程A阻塞，并释放获取到的resourceA的锁
                        System.out.println("ThreadA release resourceA lock");
                        try {
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //休眠一秒
                    Thread.sleep(1000);
                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("ThreadB get resourceA lock");
                        System.out.println("ThreadB try get resourceB lock...");
                        //获取resourceB共享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("ThreadB get resourceB lock");
                            //线程B阻塞，并释放获取到的resourceA的锁
                            System.out.println("ThreadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
        //等待两个线程执行完
        threadA.join();
        threadB.join();
        System.out.println("main over");
    }

}

