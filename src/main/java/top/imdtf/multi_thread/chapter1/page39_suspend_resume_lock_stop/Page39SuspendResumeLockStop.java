package top.imdtf.multi_thread.chapter1.page39_suspend_resume_lock_stop;

import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:30
 */
public class Page39SuspendResumeLockStop {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        ThreadUtils.sleep(1000);
        myThread.suspend();
        myThread.resume();
        System.out.println("End.");
        System.out.println("Resume.");
    }
}

class MyThread extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            ++i;
            System.out.println(i);
        }
    }
}
