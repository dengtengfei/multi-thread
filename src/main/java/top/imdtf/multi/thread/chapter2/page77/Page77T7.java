package top.imdtf.multi.thread.chapter2.page77;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 23:00
 */
public class Page77T7 {
    public static void main(String[] args) {
        Task task = new Task();
        new MyThread(task).start();
        new MyThread(task).start();
    }
}

class Task {
    public void doLongTimeTask() {
        for (int i = 0; i < Constant.INT_100; ++i) {
            System.out.println("no synchronized threadName: " + ThreadUtils.getThreadName() + ", i: " + (i + 1));
        }
        System.out.println();
        synchronized (this) {
            for (int i = 0; i < Constant.INT_100; ++i) {
                System.out.println("synchronized threadName: " + ThreadUtils.getThreadName() + ", i: " + (i + 1));
            }
        }
    }
}

class MyThread extends Thread {
    private final Task task;

    public MyThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
