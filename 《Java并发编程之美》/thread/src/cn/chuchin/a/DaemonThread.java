package cn.chuchin.a;

/**
 * @ClassName DaemonThread
 * @Author ChinHeng-Chu
 * @Date 2020/12/3 23:22
 * @Description DaemonThread
 * @Version 1.0
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
        //设置为守护线程
        thread.setDaemon(true);
        thread.start();
    }
}
