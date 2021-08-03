package top.imdtf.multi.thread.chapter1.page49;

import lombok.Getter;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 23:11
 */
public class Page49CountPriority {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread(), myThread2 = new MyThread();
        myThread1.setPriority(Thread.NORM_PRIORITY - 3);
        myThread1.start();
        myThread2.setPriority(Thread.NORM_PRIORITY + 3);
        myThread2.start();
        ThreadUtils.sleep(20000);
        myThread1.stop();
        myThread2.stop();
        System.out.println("Count of myThread1: " + myThread1.getCount());
        System.out.println("Count of myThread2: " + myThread2.getCount());
    }
}

@Getter
class MyThread extends Thread {
    private long count = 0L;

    @Override
    public void run() {
        while (true) {
            ++count;
        }
    }
}
