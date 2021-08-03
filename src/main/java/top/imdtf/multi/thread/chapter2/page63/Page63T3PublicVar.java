package top.imdtf.multi.thread.chapter2.page63;

import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 22:15
 */
public class Page63T3PublicVar {
    public static void main(String[] args) {
        PublicVar publicVar = new PublicVar();
        new MyThread(publicVar).start();
        ThreadUtils.sleep(200);
        publicVar.getValue();
    }
}

class PublicVar {
    private String username = "A";
    private String password = "AA";

    public synchronized void setValue(String username, String password) {
        this.username = username;
        ThreadUtils.sleep(5000);
        this.password = password;
        System.out.println("SetValue method, threadName: " + ThreadUtils.getThreadName() + ", username: " + username + ", password: " + password);
    }

    public synchronized void getValue() {
        // TODO remove synchronized
        System.out.println("GetValue method, threadName: " + ThreadUtils.getThreadName() + ", username: " + username + ", password: " + password);
    }
}

class MyThread extends Thread {
    private final PublicVar publicVar;

    public MyThread(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}
