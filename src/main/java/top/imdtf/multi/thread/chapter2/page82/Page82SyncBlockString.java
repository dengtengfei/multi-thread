package top.imdtf.multi.thread.chapter2.page82;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/24 23:04
 */
public class Page82SyncBlockString {
    public static void main(String[] args) {
        Service service = new Service();
        Runnable runnable = service::method;
        ThreadUtil.newThread(runnable, "A").start();
        ThreadUtil.newThread(runnable, "B").start();
    }
    private static class Service {
        private final String anyString = "";

        public void method() {
            synchronized (anyString) {
                System.out.println("ThreadName: " + ThreadUtil.getThreadName() + " run into     sync block at: " + System.currentTimeMillis());
                ThreadUtil.sleep(3000);
                System.out.println("ThreadName: " + ThreadUtil.getThreadName() + " run out of   sync block at: " + System.currentTimeMillis());
            }
        }
    }
}
