package top.imdtf.multi_thread.chapter1.page47_t20;

import top.imdtf.multi_thread.utils.Constant;

import java.util.Random;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 23:08
 */
public class Page47T20 {
    public static void main(String[] args) {
        // TODO purpose??
        for (int i = 0; i < Constant.INT_5; ++i) {
            MyThread myThread1 = new MyThread("thread1-" + i), myThread2 = new MyThread("thread2-" + i);
            myThread1.setPriority(5);
            myThread2.setPriority(6);
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
        for (int i = 0; i < Constant.INT_1K; ++i) {
            new Random().nextInt();
        }
        System.out.println(name + " time consume: " + (System.currentTimeMillis() - beginTime) + "ms.");
    }
}