package top.imdtf.multi_thread.chapter1.page5_random_thread;

import top.imdtf.multi_thread.utils.Constant;
import top.imdtf.multi_thread.utils.RandomUtils;
import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  20218/1 20:41
 */
public class Page5RandomThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("myThread");
        myThread.start();
        for (int i = 0; i < Constant.INT_10; ++i) {
            int time = RandomUtils.getRandomInt1000();
            ThreadUtils.sleep(time);
            System.out.println("main: " + ThreadUtils.getThreadName());
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < Constant.INT_10; ++i) {
            int time = RandomUtils.getRandomInt1000();
            ThreadUtils.sleep(time);
            System.out.println("run: " + ThreadUtils.getThreadName());
        }
    }
}
