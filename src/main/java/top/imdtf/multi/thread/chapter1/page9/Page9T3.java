package top.imdtf.multi.thread.chapter1.page9;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:01
 */
public class Page9T3 {
    public static void main(String[] args) {
        new MyThread("A").start();
        new MyThread("B").start();
        new MyThread("C").start();
    }
}

class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            --count;
            System.out.println("from " + currentThread().getName() + " calc, count: " + count);
        }
    }
}
