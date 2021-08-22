package top.imdtf.multi.thread.chapter7.page298;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 21:03
 */
public class Page298DefaultThreadExceptionHandler {
    public static void main(String[] args) {
        MyThread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("ThreadName: " + t.getName() + " throw exception.");
            e.printStackTrace();
        });
        new MyThread().start();
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }
}
