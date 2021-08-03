package top.imdtf.multi.thread.chapter1.page27;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 21:23
 */
public class Page27T13 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        ThreadUtils.sleep(100);
        myThread.interrupt();

        System.out.println("==============\n\n\n");
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        ThreadUtils.sleep(100);
        myThread2.interrupt();

        System.out.println("Main end.");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < Constant.INT_500K; ++i) {
            if (this.isInterrupted()) {
                System.out.println("Thread: " + this.getName() + " stopped.");
                break;
            }
            System.out.println("i: " + (i + 1));
        }
        System.out.println("Thread is already running");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < Constant.INT_500K; ++i) {
                if (this.isInterrupted()) {
                    System.out.println("Thread: " + this.getName() + " stopped.");
                    throw new InterruptedException();
                }
                System.out.println("i: " + (i + 1));
            }
            System.out.println("Thread is already running");
        } catch (InterruptedException e) {
            System.out.println("Run catch.");
            e.printStackTrace();
        }
    }
}
