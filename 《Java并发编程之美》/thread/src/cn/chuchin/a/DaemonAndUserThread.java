package cn.chuchin.a;

/**
 * @ClassName DaemonThread
 * @Author ChinHeng-Chu
 * @Date 2020/12/3 23:22
 * @Description DaemonThread
 * @Version 1.0
 */
public class DaemonAndUserThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {}
            }
        });
        //启动子线程
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over ");
    }
}
