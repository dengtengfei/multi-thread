package top.imdtf.multi.thread.chapter1.page21;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 22:09
 */
public class Page21T8 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin:  " + System.currentTimeMillis());
        myThread.start();
        System.out.println("end:    " + System.currentTimeMillis());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run threadName: " + currentThread().getName() + " begin:    " + System.currentTimeMillis());
        ThreadUtil.sleep(2000);
        System.out.println("run threadName: " + currentThread().getName() + " end:      " + System.currentTimeMillis());
    }
}
