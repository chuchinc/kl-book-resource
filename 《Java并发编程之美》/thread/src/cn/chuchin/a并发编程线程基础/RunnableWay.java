package cn.chuchin.a并发编程线程基础;

/**
 * @ClassName RunnableWay
 * @Author ChinHeng-Chu
 * @Date 2020/11/29 17:11
 * @Description RunnableWay
 * @Version 1.0
 */
public class RunnableWay implements Runnable {
    @Override
    public void run() {
        System.out.println("I am a child thread");
    }

    public static void main(String[] args) {
        RunnableWay runnableWay = new RunnableWay();
        new Thread(runnableWay).start();
        new Thread(runnableWay).start();
    }
}
