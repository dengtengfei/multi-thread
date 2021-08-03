package top.imdtf.multi.thread.chapter2.page57;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 21:45
 */
public class Page57TwoObjectTwoLock {
    public static void main(String[] args) {
        new MyThread(new HasSelfPrivateNum(), Constant.STR_A).start();
        ThreadUtils.sleep(50);
        new MyThread(new HasSelfPrivateNum(), Constant.STR_B).start();
    }
}

class HasSelfPrivateNum {
    private int num = 0;

    synchronized public void addI(String username) {
        if (Constant.STR_A.equals(username)) {
            num = 100;
            System.out.println(username + " set over.");
            ThreadUtils.sleep(2000);
        } else {
            num = 200;
            System.out.println(username + " set over.");
        }
        System.out.println("Username: " + username + ", num: " + num);
    }
}

class MyThread extends Thread {
    private final HasSelfPrivateNum numRef;
    private final String username;

    public MyThread(HasSelfPrivateNum num, String username) {
        this.numRef = num;
        this.username = username;
    }

    @Override
    public void run() {
        numRef.addI(username);
    }
}
