package cn.chuchin.a;

/**
 * @ClassName InterruptedAndIsInterrupted
 * @Author ChinHeng-Chu
 * @Date 2020/12/2 23:10
 * @Description InterruptedAndIsInterrupted
 * @Version 1.0
 */
public class InterruptedRemove {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //中断标志为true时会退出循环，并且清除中断标志
                while (!Thread.currentThread().isInterrupted()){

                }
                System.out.println("thread is interrupted :" + Thread.currentThread().isInterrupted());
            }
        });
        //启动线程
        thread.start();
        //设置中断标志
        thread.interrupt();
        thread.join();
        System.out.println("main thread is over");
    }
}
