package top.imdtf.multi.thread.chapter1.page50;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 23:14
 */
public class Page50DaemonThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
        ThreadUtil.sleep(10000);
        System.out.println("Main end, and daemon thread end.");
    }
}

class MyThread extends Thread {
    private long i = 0L;

    @Override
    public void run() {
        while (true) {
            ++i;
            System.out.println("i: " + i);
            ThreadUtil.sleep(1000);
        }
    }
}
