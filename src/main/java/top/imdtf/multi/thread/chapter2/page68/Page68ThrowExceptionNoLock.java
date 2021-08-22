package top.imdtf.multi.thread.chapter2.page68;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 22:29
 */
public class Page68ThrowExceptionNoLock {
    public static void main(String[] args) {
        Service service = new Service();
        new MyThread(service, Constant.STR_A).start();
        ThreadUtil.sleep(500);
        new MyThread(service, Constant.STR_B).start();
    }
}

class Service {
    public synchronized void testMethod() {
        if (Constant.STR_A.equals(ThreadUtil.getThreadName())) {
            System.out.println("ThreadName: " + ThreadUtil.getThreadName() + ", testMethod begin time: " + System.currentTimeMillis());
            while (true) {
                String compareStr = "0.1234567";
                if (compareStr.equals(String.valueOf(Math.random()).substring(0, compareStr.length()))) {
                    System.out.println("ThreadName: " + ThreadUtil.getThreadName() + ", run exception, time: " + System.currentTimeMillis());
                    System.out.println(Integer.parseInt("a"));
                }
            }
        } else {
            System.out.println("ThreadName: " + ThreadUtil.getThreadName() + ", testMethod begin time: " + System.currentTimeMillis());
        }
    }
}

class MyThread extends Thread {
    private final Service service;

    public MyThread(Service service, String name) {
        this.service = service;
        setName(name);
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
