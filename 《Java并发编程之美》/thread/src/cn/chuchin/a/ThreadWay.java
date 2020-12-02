package cn.chuchin.a;

/**
 * @ClassName ThreadWay
 * @Author ChinHeng-Chu
 * @Date 2020/11/29 16:50
 * @Description ThreadWay
 * @Version 1.0
 */
public class ThreadWay {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
