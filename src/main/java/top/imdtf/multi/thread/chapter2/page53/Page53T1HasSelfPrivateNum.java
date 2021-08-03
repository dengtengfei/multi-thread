package top.imdtf.multi.thread.chapter2.page53;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 21:35
 */
public class Page53T1HasSelfPrivateNum {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        new MyThread(hasSelfPrivateNum, Constant.STR_A).start();
        ThreadUtils.sleep(50);
        new MyThread(hasSelfPrivateNum, Constant.STR_B).start();
    }
}

class HasSelfPrivateNum {
    public void addI(String username) {
        int num;
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
