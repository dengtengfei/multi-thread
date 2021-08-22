package top.imdtf.multi.thread.chapter7.page291;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 19:49
 */
public class Page291ThreadRunSync {
    public static void main(String[] args) {
        Object lock = new Object();
        new MyThread(lock, Constant.UPPERCASE_STR_A, 1).start();
        new MyThread(lock, Constant.UPPERCASE_STR_B, 2).start();
        new MyThread(lock, Constant.UPPERCASE_STR_C, 0).start();
    }
}

class MyThread extends Thread {
    private final Object lock;
    private final String showChar;
    private final int showNumPosition;
    private int printCount = 0;
    volatile private static int addNumber = 1;

    public MyThread(Object lock, String showChar, int showNumPosition) {
        this.lock = lock;
        this.showChar = showChar;
        this.showNumPosition = showNumPosition;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                if (addNumber % 3 == showNumPosition) {
                    System.out.println("ThreadName: " + ThreadUtils.getThreadName() + " runCount: " + addNumber + " " + showChar);
                    lock.notifyAll();
                    ++addNumber;
                    ++printCount;
                    if (printCount == 3) {
                        break;
                    }
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
