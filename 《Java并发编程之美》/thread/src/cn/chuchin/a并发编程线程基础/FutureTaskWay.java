package cn.chuchin.a并发编程线程基础;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName FutureTaskWay
 * @Author ChinHeng-Chu
 * @Date 2020/11/29 17:17
 * @Description FutureTaskWay
 * @Version 1.0
 */
public class FutureTaskWay implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> stringFutureTask = new FutureTask<>(new FutureTaskWay());
        //启动线程
        new Thread(stringFutureTask).start();
        try {
            String result = stringFutureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
