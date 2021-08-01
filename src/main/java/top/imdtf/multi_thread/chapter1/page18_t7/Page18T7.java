package top.imdtf.multi_thread.chapter1.page18_t7;

import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:57
 */
public class Page18T7 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin: " + myThread.isAlive());
        myThread.start();
//        ThreadUtils.sleep(1000);
        System.out.println("end: " + myThread.isAlive());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run: " + this.isAlive());
    }
}
