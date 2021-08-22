package top.imdtf.multi.thread.chapter7.page301;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 21:55
 */
public class Page302ThreadExceptionMoveTest2 {
    public static void main(String[] args) {
        ThreadExceptionTools.MyThreadGroup group = new ThreadExceptionTools.MyThreadGroup("myThreadGroup");
        ThreadExceptionTools.MyThread myThread = new ThreadExceptionTools.MyThread(group, "myThread");
//        myThread.setUncaughtExceptionHandler(new ThreadExceptionTools.ObjectUncaughtExceptionHandler());
//        ThreadExceptionTools.MyThread.setDefaultUncaughtExceptionHandler(new ThreadExceptionTools.StaticUncaughtExceptionHandler());
        myThread.start();
    }
}
