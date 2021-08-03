package top.imdtf.multi.thread.chapter2.page65;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 22:23
 */
public class Page65SyncLockIn1 {
    public static void main(String[] args) {
        new MyThread().start();
    }
}

class Service {
    public synchronized void service1() {
        System.out.println("service1");
        service2();
    }

    public synchronized void service2() {
        System.out.println("service2");
        service3();
    }

    public synchronized void service3() {
        System.out.println("service3");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        new Service().service1();
    }
}
