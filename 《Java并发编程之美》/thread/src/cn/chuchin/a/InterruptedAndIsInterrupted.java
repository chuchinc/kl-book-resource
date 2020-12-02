package cn.chuchin.a;

/**
 * @ClassName InterruptedAndIsInterrupted
 * @Author ChinHeng-Chu
 * @Date 2020/12/2 23:10
 * @Description InterruptedAndIsInterrupted
 * @Version 1.0
 */
public class InterruptedAndIsInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });
        //启动线程
        thread.start();
        //设置中断标志
        thread.interrupt();
        //获取中断标志
        System.out.println("isInterrupted:" + thread.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:" + thread.interrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:" + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted:" + thread.isInterrupted());
        thread.join();
        System.out.println("main thread is over");
    }
}
