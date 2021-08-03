package top.imdtf.multi.thread.chapter2.page74;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 22:53
 */
public class Page74SynchronizedOneThreadIn {
    public static void main(String[] args) {
        Service service = new Service();
        new MyThread(service, Constant.UPPERCASE_STR_A).start();
        new MyThread(service, Constant.UPPERCASE_STR_B).start();
    }
}

class Service {
    public void testMethod() {
        synchronized (this) {
            System.out.println("ThreadName: " + ThreadUtils.getThreadName() + ", begin time: " + System.currentTimeMillis());
            ThreadUtils.sleep(2000);
            System.out.println("ThreadName: " + ThreadUtils.getThreadName() + ", end time: " + System.currentTimeMillis());
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
