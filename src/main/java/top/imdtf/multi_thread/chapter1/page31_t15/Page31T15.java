package top.imdtf.multi_thread.chapter1.page31_t15;

import top.imdtf.multi_thread.utils.Constant;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 21:38
 */
public class Page31T15 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        System.out.println("Main end.");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Run begin.");
        try {
            for (int i = 0; i < Constant.INT_100K; ++i) {
                System.out.println("i: " + (i + 1));
            }
            System.out.println("begin sleep time: " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("Run end.");
        } catch (InterruptedException e) {
            System.out.println("Thread waked into catch block while sleeping, time: " + System.currentTimeMillis());
            System.out.println("this.isInterrupted(): " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
