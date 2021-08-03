package top.imdtf.multi.thread.chapter2.page61;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 21:52
 */
public class Page61SynchronizedMethodLockObject2 {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        new MyThread(myObject, Constant.UPPERCASE_STR_A).start();
        new MyThread(myObject, Constant.UPPERCASE_STR_B).start();
    }
}

class MyObject {
    synchronized public void methodA() {
        System.out.println("Begin methodA threadName: " + ThreadUtils.getThreadName());
        ThreadUtils.sleep(5000);
        System.out.println("End methodA time: " + System.currentTimeMillis() + "ms.");
    }

    synchronized public void methodB() {
        System.out.println("Begin methodB threadName: " + ThreadUtils.getThreadName());
        ThreadUtils.sleep(5000);
        System.out.println("End methodB time: " + System.currentTimeMillis() + "ms.");
    }
}

class MyThread extends Thread {
    private final MyObject myObject;

    public MyThread(MyObject myObject, String name) {
        this.myObject = myObject;
        setName(name);
    }

    @Override
    public void run() {
        if (Constant.UPPERCASE_STR_A.equals(getName())) {
            myObject.methodA();
        } else {
            myObject.methodB();
        }
    }
}

