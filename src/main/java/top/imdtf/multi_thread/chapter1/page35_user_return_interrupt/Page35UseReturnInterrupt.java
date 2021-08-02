package top.imdtf.multi_thread.chapter1.page35_user_return_interrupt;

import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:09
 */
public class Page35UseReturnInterrupt {
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
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("Thread has been Interrupted.");
                return;
            }
            System.out.println("Time: " + System.currentTimeMillis());
        }
    }
}
