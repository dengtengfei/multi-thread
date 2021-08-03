package top.imdtf.multi.thread.chapter2.page66;

import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 22:25
 */
public class Page66SyncLockIn2 {
    public static void main(String[] args) {
        new MyThread().start();
    }
}

class Base {
    protected int i = 10;

    protected synchronized void operateBaseMethod() {
        --i;
        System.out.println("Base operate i: " + i);
        ThreadUtils.sleep(100);
    }
}

class Sub extends Base {
    public synchronized void operateSubMethod() {
        while (i > 0) {
            --i;
            System.out.println("Sub operate i: " + i);
            ThreadUtils.sleep(100);
            operateBaseMethod();
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        new Sub().operateSubMethod();
    }
}
