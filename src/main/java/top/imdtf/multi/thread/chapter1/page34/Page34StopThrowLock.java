package top.imdtf.multi.thread.chapter1.page34;

import lombok.Getter;
import lombok.Setter;
import top.imdtf.multi.thread.utils.ThreadUtil;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:03
 */
public class Page34StopThrowLock {
    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        MyThread myThread = new MyThread(object);
        myThread.start();
        ThreadUtil.sleep(500);
        myThread.stop();
        System.out.println(object.getUsername() + " " + object.getPassword());
    }
}

@Getter
@Setter
class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    synchronized public void printString(String username, String password) {
        this.username = username;
        ThreadUtil.sleep(5000);
        this.password = password;
    }
}

class MyThread extends Thread {
    private final SynchronizedObject object;

    public MyThread(SynchronizedObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }
}
