package top.imdtf.multi_thread.chapter1.page42_t17;

import top.imdtf.multi_thread.utils.Constant;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:38
 */
public class Page42T17 {
    public static void main(String[] args) {
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < Constant.INT_50M; ++i) {
//            Thread.yield();
            count += (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time consume: " + (endTime - beginTime) + "ms.");
        System.out.println("count: " + count);
    }
}
