package top.imdtf.multi.thread.chapter2.page80;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/24 22:58
 */
public class Page80T8 {
    public static void main(String[] args) {
        Task task = new Task();
        new MyThread(task, false).start();
        ThreadUtil.sleep(1);
        new MyThread(task, true).start();
    }

    private static class Task {
        public void method() {
            synchronized (this) {
                System.out.println("Run method.");
            }
        }

        public void doLongTimeTask() {
            synchronized (this) {
                for (int i = 0; i < Constant.INT_10K; ++i) {
                    System.out.println("Synchronized thread: " + ThreadUtil.getThreadName() + ", i: " + (i + 1));
                }
            }
        }
    }

    static class MyThread extends Thread{
        private final Task task;
        private final boolean isLongTimeTask;

        public MyThread(Task task, boolean isLongTimeTask) {
            this.task = task;
            this.isLongTimeTask = isLongTimeTask;
        }

        @Override
        public void run() {
            if (isLongTimeTask) {
                task.method();
            } else {
                task.doLongTimeTask();
            }
        }
    }
}
