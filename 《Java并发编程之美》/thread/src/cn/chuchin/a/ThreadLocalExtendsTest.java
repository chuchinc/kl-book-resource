package cn.chuchin.a;

/**
 * @ClassName ThreadLocalExtendsTest
 * @Author ChinHeng-Chu
 * @Date 2020/12/7 21:48
 * @Description ThreadLocalExtendsTest
 * @Version 1.0
 */
public class ThreadLocalExtendsTest {
    //（1）创建线程变量
//    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        //（2）设置线程变量
        threadLocal.set("hello world");
        //(3)启动子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //(4)子线程输出线程变量的值
                System.out.println("thread:" + threadLocal.get());
            }
        });
        thread.start();
        System.out.println("main:" + threadLocal.get());
    }
}
