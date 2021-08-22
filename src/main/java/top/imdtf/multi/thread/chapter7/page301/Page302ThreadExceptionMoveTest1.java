package top.imdtf.multi.thread.chapter7.page301;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 21:46
 */
public class Page302ThreadExceptionMoveTest1 {
    public static void main(String[] args) {
        ThreadExceptionTools.MyThread myThread = new ThreadExceptionTools.MyThread();
//        myThread.setUncaughtExceptionHandler(new ThreadExceptionTools.ObjectUncaughtExceptionHandler());
        ThreadExceptionTools.MyThread.setDefaultUncaughtExceptionHandler(new ThreadExceptionTools.StaticUncaughtExceptionHandler());
        myThread.start();
    }
}
