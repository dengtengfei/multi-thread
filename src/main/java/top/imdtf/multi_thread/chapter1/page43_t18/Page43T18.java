package top.imdtf.multi_thread.chapter1.page43_t18;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:43
 */
public class Page43T18 {
    public static void main(String[] args) {
        System.out.println("Main thread run priority: " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("Main thread run priority: " + Thread.currentThread().getPriority());
        new MyThread1().start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1 run priority: " + this.getPriority());
        new MyThread2().start();
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread2 run priority: " + this.getPriority());
    }
}
