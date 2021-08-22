package top.imdtf.multi.thread.chapter1.page5;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.RandomUtil;
import top.imdtf.multi.thread.utils.ThreadUtil;

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
            int time = RandomUtil.getRandomInt1000();
            ThreadUtil.sleep(time);
            System.out.println("main: " + ThreadUtil.getThreadName());
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < Constant.INT_10; ++i) {
            int time = RandomUtil.getRandomInt1000();
            ThreadUtil.sleep(time);
            System.out.println("run: " + ThreadUtil.getThreadName());
        }
    }
}
