package top.imdtf.multi.thread.chapter1.page25;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 22:16
 */
public class Page25T12 {
    public static void main(String[] args) {
        run1();
        run2();
        run3();
    }

    private static void run1() {
        MyThread myThread = new MyThread();
        myThread.start();
        ThreadUtils.sleep(1000);
        myThread.interrupt();
        System.out.println("run1 interrupted?: " + Thread.interrupted());
        System.out.println("run1 interrupted?: " + Thread.interrupted() + "\n\n");
    }

    private static void run2() {
        Thread.currentThread().interrupt();
        System.out.println("run2 interrupted?: " + Thread.interrupted());
        System.out.println("run2 interrupted?: " + Thread.interrupted() + "\n\n");
    }

    private static void run3() {
        MyThread myThread = new MyThread();
        myThread.start();
        ThreadUtils.sleep(1000);
        myThread.interrupt();
        System.out.println("run3 isInterrupted?: " + myThread.isInterrupted());
        System.out.println("run3 isInterrupted?: " + myThread.isInterrupted() + "\n\n");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < Constant.INT_500K; ++i) {
//            System.out.println("i: " + (i + 1));
        }
    }
}
