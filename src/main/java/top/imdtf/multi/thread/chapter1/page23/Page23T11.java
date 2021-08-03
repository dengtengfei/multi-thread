package top.imdtf.multi.thread.chapter1.page23;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 22:14
 */
public class Page23T11 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        ThreadUtils.sleep(2000);
        myThread.interrupt();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < Constant.INT_500K; ++i) {
            System.out.println("i: " + (i + 1));
        }
    }
}
