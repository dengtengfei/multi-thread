package top.imdtf.multi_thread.chapter1.page14_same_num;

import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:20
 */
public class Page14SameNum {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ThreadUtils.newThread(myThread).start();
        ThreadUtils.newThread(myThread).start();
        ThreadUtils.newThread(myThread).start();
        ThreadUtils.newThread(myThread).start();
        ThreadUtils.newThread(myThread).start();
    }
}

class MyThread extends Thread {
    private int i = 5;

    @Override
    synchronized public void run() {
        System.out.println("Thread name: " + ThreadUtils.getThreadName() + " i: " + (i--));
    }
}
