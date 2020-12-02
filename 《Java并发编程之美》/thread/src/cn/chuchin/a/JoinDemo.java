package cn.chuchin.a;

/**
 * @ClassName JoinDemo
 * @Author ChinHeng-Chu
 * @Date 2020/12/1 21:04
 * @Description JoinDemo
 * @Version 1.0
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadA over");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadB over");
            }
        });
        //启动子线程
        threadA.start();
        threadB.start();
        System.out.println("wait all child thread over");
        //等待子线程执行完毕，返回
        threadA.join();
        threadB.join();
        System.out.println("all child thread over");
    }
}
