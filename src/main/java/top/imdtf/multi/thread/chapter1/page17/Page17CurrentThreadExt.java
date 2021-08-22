package top.imdtf.multi.thread.chapter1.page17;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:26
 */
public class Page17CurrentThreadExt {
    public static void main(String[] args) {
        CountOperateThread countOperateThread = new CountOperateThread("C");
        ThreadUtil.newThread(countOperateThread, "A").start();
    }
}

class CountOperateThread extends Thread {
    public CountOperateThread(String name) {
        this.setName(name);
        System.out.println("CountOperateThread constructor begin.");
        System.out.println("Thread.currentThread().getName(): " + ThreadUtil.getThreadName());
        System.out.println("this.getName: " + this.getName());
        System.out.println("CountOperateThread constructor end.\n");
    }

    @Override
    public void run() {
        System.out.println("run constructor begin.");
        System.out.println("Thread.currentThread().getName(): " + ThreadUtil.getThreadName());
        System.out.println("this.getName(): " + this.getName());
        System.out.println("run constructor end.");
    }
}
