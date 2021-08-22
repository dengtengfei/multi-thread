package top.imdtf.multi.thread.chapter7.page301;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 21:54
 */
public class ThreadExceptionTools {
    public static class MyThread extends Thread {
        private String num = "a";

        public MyThread() {
        }

        public MyThread(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            int numInt = Integer.parseInt(num);
            System.out.println("print in thread: " + (numInt + 1));
        }
    }

    public static class MyThreadGroup extends ThreadGroup {
        public MyThreadGroup(String name) {
            super(name);
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            super.uncaughtException(t, e);
            System.out.println("Exception of ThreadGroup has been handled.");
            e.printStackTrace();
        }
    }

    public static class ObjectUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Exception of object has been handled.");
            e.printStackTrace();
        }
    }

    public static class StaticUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Exception of static object has been handled.");
            e.printStackTrace();
        }
    }
}
