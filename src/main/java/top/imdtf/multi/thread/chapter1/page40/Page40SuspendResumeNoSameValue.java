package top.imdtf.multi.thread.chapter1.page40;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/2 22:33
 */
public class Page40SuspendResumeNoSameValue {
    public static void main(String[] args) {
        final MyObject object = new MyObject();
        Thread thread = ThreadUtils.newThread(() -> object.setValue("a", "aa"));
        thread.setName("a");
        thread.start();
        ThreadUtils.sleep(500);

        ThreadUtils.newThread(object::printValue).start();
    }
}

class MyObject {
    private String username = "1";
    private String password = "11";

    public void setValue(String username, String password) {
        this.username = username;
        if (Constant.STR_A.equals(ThreadUtils.getThreadName())) {
            System.out.println("Suspend thread a.");
            Thread.currentThread().suspend();
        }
        this.password = password;
    }

    public void printValue() {
        System.out.println(username + " " + password);
    }
}
