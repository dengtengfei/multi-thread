package top.imdtf.multi_thread.chapter1.page22_run_thread;

import top.imdtf.multi_thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/1 22:13
 */
public class Page22RunThread {
    public static void main(String[] args) {
        System.out.println(ThreadUtils.getThreadName() + " " + Thread.currentThread().getId());
    }
}
