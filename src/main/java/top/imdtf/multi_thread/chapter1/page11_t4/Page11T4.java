package top.imdtf.multi_thread.chapter1.page11_t4;

import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:04
 */
public class Page11T4 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ThreadUtils.newThread(myThread, "A").start();
        ThreadUtils.newThread(myThread, "B").start();
        ThreadUtils.newThread(myThread, "C").start();
        ThreadUtils.newThread(myThread, "D").start();
        ThreadUtils.newThread(myThread, "E").start();
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