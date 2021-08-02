package top.imdtf.multi_thread.chapter1.page33_run_method_use_stop_method;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:01
 */
public class Page33RunMethodUseStopMethod {
    public static void main(String[] args) {
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e) {
            System.out.println("Run in catch ThreadDeath.");
            e.printStackTrace();
        }
    }
}
