package cn.chuchin.a;

/**
 * @ClassName ThreadLocal
 * @Author ChinHeng-Chu
 * @Date 2020/12/7 20:50
 * @Description ThreadLocal
 * @Version 1.0
 */
public class ThreadLocalTest {

    //创建thradlocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    /**
     * print函数
     * @param string
     */
    static void print(String string) {
        //打印当前线程本地内存中localVariable变量的值
        System.out.println(string + ":" + localVariable.get());
        //清除当前线程本地内存中的localVariable变量
//        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print("threadOne");
                System.out.println("threadOne remove after" + ":" + localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("threadTwo remove after" + ":" + localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}
