package top.imdtf.multi.thread.utils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 20:34
 */
public class ThreadUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }

    public static Thread newThread(Runnable runnable) {
        return new Thread(runnable);
    }

    public static Thread newThread(Runnable runnable, String name) {
        return new Thread(runnable, name);
    }
}
