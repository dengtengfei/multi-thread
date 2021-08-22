package top.imdtf.multi.thread.chapter1.page14;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:20
 */
public class Page14SameNum {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ThreadUtil.newThread(myThread).start();
        ThreadUtil.newThread(myThread).start();
        ThreadUtil.newThread(myThread).start();
        ThreadUtil.newThread(myThread).start();
        ThreadUtil.newThread(myThread).start();
    }
}

class MyThread extends Thread {
    private int i = 5;

    @Override
    synchronized public void run() {
        System.out.println("Thread name: " + ThreadUtil.getThreadName() + " i: " + (i--));
    }
}
