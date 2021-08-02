package top.imdtf.multi_thread.chapter1.page32_use_stop_method_thread_test;

import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 21:46
 */
public class Page32UseStopMethodThreadTest {
    static MyThread myThread = new MyThread();

    public static void main(String[] args) {
        try {
            myThread.start();
            // instance sleep equals class sleep
            myThread.sleep(8000);
//            Thread.sleep(8000);
            myThread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            ++i;
            System.out.println("i: " + i);
            ThreadUtils.sleep(1000);
        }
    }
}
