package top.imdtf.multi.thread.chapter2.page78;

import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/24 22:15
 */
public class Page78DoubleSyncBlockOneTwo {
    public static void main(String[] args) {
        Service service = new Service();
        new MyThread(service, true).start();
        new MyThread(service, false).start();
    }

    static class Service {
        public void methodA() {
            synchronized (this) {
                System.out.println("Method A begin  time: " + System.currentTimeMillis());
                ThreadUtil.sleep(2000);
                System.out.println("Method A end    time: " + System.currentTimeMillis());
            }
        }

        public void methodB() {
            synchronized (this) {
                System.out.println("Method B begin  time: " + System.currentTimeMillis());
                System.out.println("Method B end    time: " + System.currentTimeMillis());
            }
        }
    }

    static class MyThread extends Thread{
        private final Service service;
        private final boolean isMethodA;

        public MyThread(Service service, boolean isMethodA) {
            this.service = service;
            this.isMethodA = isMethodA;
        }

        @Override
        public void run() {
            if (isMethodA) {
                service.methodA();
            } else {
                service.methodB();
            }
        }
    }
}
