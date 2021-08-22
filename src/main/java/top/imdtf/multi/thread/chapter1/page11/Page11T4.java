package top.imdtf.multi.thread.chapter1.page11;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:04
 */
public class Page11T4 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ThreadUtil.newThread(myThread, "A").start();
        ThreadUtil.newThread(myThread, "B").start();
        ThreadUtil.newThread(myThread, "C").start();
        ThreadUtil.newThread(myThread, "D").start();
        ThreadUtil.newThread(myThread, "E").start();
    }
}

class MyThread extends Thread {
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        while (count > 0) {
            --count;
            System.out.println("from " + currentThread().getName() + " calc, count: " + count);
        }
    }
}
