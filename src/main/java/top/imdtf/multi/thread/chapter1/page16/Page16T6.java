package top.imdtf.multi.thread.chapter1.page16;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:22
 */
public class Page16T6 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.run();
    }
}

class MyThread extends Thread {
    public MyThread() {
        System.out.println("Constructor call by thread: " + ThreadUtil.getThreadName());
    }

    @Override
    public void run() {
        System.out.println("Thread run method call by thread: " + ThreadUtil.getThreadName());
    }
}
