package top.imdtf.multi.thread.chapter1.page12;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 21:12
 */
public class Page12T4ThreadSafe {
    public static void main(String[] args) {
        new Login("a", "aa").start();
        new Login("b", "bb").start();
    }
}

class Login extends Thread {
    private final String username, password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        super.run();
        LoginServlet.doPost(username, password);
    }
}

class LoginServlet {
    private static String usernameRef, passwordRef;

    synchronized public static void doPost(String username, String password) {
        usernameRef = username;
        if (Constant.STR_A.equals(username)) {
            ThreadUtils.sleep(5000);
        }
        passwordRef = password;
        System.out.println("username: " + usernameRef + ", password: " + passwordRef);
    }
}
