package cn.chuchin.a;

/**
 * @ClassName InterruptedBestWay
 * @Author ChinHeng-Chu
 * @Date 2020/12/2 22:11
 * @Description InterruptedBestWay
 * @Version 1.0
 */
public class InterruptedBestWay {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //线程退出的条件
                    while(! Thread.currentThread().isInterrupted() //&& more work to do
                    ) {
                        Thread.sleep(1000);
                        //do more work
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //cleanup,if required
                }
            }
        });
    }
}
