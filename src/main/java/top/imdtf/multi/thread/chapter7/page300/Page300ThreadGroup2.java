package top.imdtf.multi.thread.chapter7.page300;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 21:11
 */
public class Page300ThreadGroup2 {
    public static void main(String[] args) {
        MyThreadGroup group = new MyThreadGroup("myThreadGroup");
        for (int i = 0; i < Constant.INT_10; ++i) {
            new MyThread(group, "thread-" + (i + 1), "1").start();
        }
        ThreadUtil.sleep(1);
        new MyThread(group, "errorThread", "a").start();
    }
}

class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        this.interrupt();
    }
}

class MyThread extends Thread {
    private final String num;

    public MyThread(ThreadGroup group, String name, String num) {
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        while (this.isInterrupted() == false) {
            System.out.println("Thread: " + ThreadUtil.getThreadName() + " run into dead loop");
        }

    }
}
