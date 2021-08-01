package top.imdtf.multi_thread.chapter1.page19_is_alive_other_test;

import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 22:01
 */
public class Page19IsAliveOtherTest {
    public static void main(String[] args) {
        CountOperateThread countOperateThread = new CountOperateThread();
        Thread thread = ThreadUtils.newThread(countOperateThread);
        System.out.println("main begin thread.isAlive(): " + thread.isAlive());
        thread.setName("A");
        thread.start();
        System.out.println("main end thread.isAlive(): " + thread.isAlive());
    }
}

class CountOperateThread extends Thread {
    public CountOperateThread() {
        System.out.println("CountOperateThread -- begin.");
        System.out.println("ThreadUtils.getThreadName(): " + ThreadUtils.getThreadName());
        System.out.println("Thread.currentThread().isAlive(): " + Thread.currentThread().isAlive());
        System.out.println("this.getName(): " + this.getName());
        System.out.println("this.isAlive(): " + this.isAlive());
        System.out.println("CountOperateThread -- end.\n");
    }

    @Override
    public void run() {
        System.out.println("run -- begin.");
        System.out.println("ThreadUtils.getThreadName(): " + ThreadUtils.getThreadName());
        System.out.println("Thread.currentThread().isAlive(): " + Thread.currentThread().isAlive());
        System.out.println("this.getName(): " + this.getName());
        System.out.println("this.isAlive(): " + this.isAlive());
        System.out.println("run -- end.");
    }
}
