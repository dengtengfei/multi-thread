package top.imdtf.multi.thread.chapter7.page299;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 21:06
 */
public class Page299ThreadGroup1 {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("myThreadGroup");
        for (int i = 0; i < Constant.INT_10; ++i) {
            new MyThread(group, "thread-" + (i + 1), "1").start();
        }
        // 线程组中一个线程抛异常不会影响到其他线程的正常运行
        new MyThread(group, "errorThread", "a").start();
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
        while (true) {
            System.out.println("Thread: " + ThreadUtil.getThreadName() + " run into dead loop");
        }
    }
}
