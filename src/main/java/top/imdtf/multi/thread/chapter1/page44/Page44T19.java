package top.imdtf.multi.thread.chapter1.page44;

import top.imdtf.multi.thread.utils.Constant;

import java.util.Random;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:46
 */
public class Page44T19 {
    public static void main(String[] args) {
        for (int i = 0; i < Constant.INT_5; ++i) {
            MyThread myThread1 = new MyThread("thread1-" + i), myThread2 = new MyThread("thread2-" + i);
            myThread1.setPriority(10);
            myThread2.setPriority(1);
            myThread1.start();
            myThread2.start();
        }
    }
}

class MyThread extends Thread {
    private final String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0L;
        for (int j = 0; j < Constant.INT_100; ++j) {
            for (int i = 0; i < Constant.INT_500K; ++i) {
                new Random().nextInt();
                addResult += i;
            }
        }
        System.out.println(name + " time consume: " + (System.currentTimeMillis() - beginTime) + "ms.");
    }
}
