package top.imdtf.multi_thread.chapter1.page7_z;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 20:50
 */
public class Page7Z {
    public static void main(String[] args) {
        for (int i = 1; i <= 13; ++i) {
            new MyThread(i).start();
        }
    }
}

class MyThread extends Thread {
    private final int i;

    public MyThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(i);
    }
}
