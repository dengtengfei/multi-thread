package top.imdtf.multi.thread.chapter2.page69;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 22:39
 */
public class Page69SyncNotExtends {
    public static void main(String[] args) {
        Sub sub = new Sub();
        new MyThread(sub, Constant.STR_A).start();
        new MyThread(sub, Constant.STR_B).start();
    }
}

class Base {
    protected synchronized void testMethod() {
        System.out.println(ThreadUtils.getThreadName() + " base testMethod sleep before  time: " + System.currentTimeMillis());
        ThreadUtils.sleep(5000);
        System.out.println(ThreadUtils.getThreadName() + " base testMethod sleep end     time: " + System.currentTimeMillis());
    }
}

class Sub extends Base {
    @Override
    public synchronized void testMethod() {
        // TODO remove synchronized
        System.out.println(ThreadUtils.getThreadName() + " sub testMethod sleep before  time: " + System.currentTimeMillis());
        ThreadUtils.sleep(5000);
        System.out.println(ThreadUtils.getThreadName() + " sub testMethod sleep end     time: " + System.currentTimeMillis());
        super.testMethod();
    }
}

class MyThread extends Thread {
    private final Sub sub;

    public MyThread(Sub sub, String name) {
        this.sub = sub;
        setName(name);
    }

    @Override
    public void run() {
        sub.testMethod();
    }
}
