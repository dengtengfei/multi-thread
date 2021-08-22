package top.imdtf.multi.thread.chapter2.page59;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 21:47
 */
public class Page59SynchronizedMethodLockObject {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        new MyThread(myObject, "A").start();
        new MyThread(myObject, "B").start();
    }
}

class MyObject {
    synchronized public void method() {
        System.out.println("Begin method threadName: " + ThreadUtil.getThreadName());
        ThreadUtil.sleep(5000);
        System.out.println("End.");
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
        myObject.method();
    }
}
