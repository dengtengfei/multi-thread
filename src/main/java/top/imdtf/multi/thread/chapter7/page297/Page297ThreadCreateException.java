package top.imdtf.multi.thread.chapter7.page297;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 20:35
 */
public class Page297ThreadCreateException {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("ThreadName: " + t.getName() + " throw exception.");
            e.printStackTrace();
        });
        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }
}
