package top.imdtf.multi.thread.chapter1.page8;

import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 20:53
 */
public class Page8T2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = ThreadUtils.newThread(runnable);
        thread.start();
        System.out.println("main end.");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("running.");
    }
}
