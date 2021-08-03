package top.imdtf.multi.thread.chapter1.page30;

import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 21:34
 */
public class Page30T14 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        ThreadUtils.sleep(5000);
        myThread.interrupt();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("Run begin.");
            Thread.sleep(200000);
            System.out.println("Run end.");
        } catch (InterruptedException e) {
            System.out.println("Thread waked into catch block while sleeping.");
            System.out.println("this.isInterrupted(): " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
