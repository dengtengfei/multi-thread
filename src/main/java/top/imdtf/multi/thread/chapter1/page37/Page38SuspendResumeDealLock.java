package top.imdtf.multi.thread.chapter1.page37;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:16
 */
public class Page38SuspendResumeDealLock {
    public static void main(String[] args) {
        final SynchronizedObject object = new SynchronizedObject();
        Thread thread = ThreadUtils.newThread(object::printString);
        thread.setName("a");
        thread.start();
        ThreadUtils.sleep(1000);

        ThreadUtils.newThread(() -> {
            System.out.println("Thread2 started, can not run printString(). There is only one begin print");
            System.out.println("Because of printString() method has been locked by thread which is suspended.");
            object.printString();
        }).start();
    }
}

class SynchronizedObject {
    public synchronized void printString() {
        System.out.println("ThreadName: " + ThreadUtils.getThreadName() + " begin.");
        if (Constant.STR_A.equals(ThreadUtils.getThreadName())) {
            System.out.println("thread a suspend forever.");
            Thread.currentThread().suspend();
        }
        System.out.println("end.");
    }
}
