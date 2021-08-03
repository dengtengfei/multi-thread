package top.imdtf.multi.thread.chapter1.page4.case2;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 20:39
 */
public class Page4T1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Main end.");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread run.");
    }
}
