package top.imdtf.multi.thread.chapter1.page36;

import lombok.Getter;
import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:11
 */
public class Page36SuspendResumeTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        ThreadUtil.sleep(500);

        myThread.suspend();
        System.out.println("A suspend: " + System.currentTimeMillis() + " i: " + myThread.getI());
        ThreadUtil.sleep(500);
        System.out.println("A suspend: " + System.currentTimeMillis() + " i: " + myThread.getI());

        myThread.resume();
        ThreadUtil.sleep(500);

        myThread.suspend();
        System.out.println("B suspend: " + System.currentTimeMillis() + " i: " + myThread.getI());
        ThreadUtil.sleep(500);
        System.out.println("B suspend: " + System.currentTimeMillis() + " i: " + myThread.getI());

        myThread.resume();
        myThread.interrupt();
    }
}

@Getter
class MyThread extends Thread {
    private long i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                if (isInterrupted()) {
                    throw new InterruptedException();
                }
                ++i;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
