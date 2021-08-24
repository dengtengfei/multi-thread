package top.imdtf.multi.thread.chapter2.page87;

import top.imdtf.multi.thread.utils.Constant;
import top.imdtf.multi.thread.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/24 23:15
 */
public class Page87SyncOutAsync {
    public static void main(String[] args) {
        MyList myList = new MyList();
        Runnable runnable = () -> {
            for (int i = 0; i < Constant.INT_100K; ++i) {
                myList.add("thread-" + ThreadUtil.getThreadName() + "-" + (i + 1));
            }
        };
        ThreadUtil.newThread(runnable, "A").start();
        ThreadUtil.newThread(runnable, "B").start();
    }

    private static class MyList {
        private final List<Object> list = new ArrayList<>();

        public synchronized void add(String username) {
            System.out.println("ThreadName: " + ThreadUtil.getThreadName() + " run into     add method.");
            list.add(username);
            System.out.println("ThreadName: " + ThreadUtil.getThreadName() + " run finish   add method.");
        }

        public synchronized int getSize() {
            System.out.println("ThreadName: " + ThreadUtil.getThreadName() + " run into     getSize method.");
            int size = list.size();
            System.out.println("ThreadName: " + ThreadUtil.getThreadName() + " run finish   getSize method.");
            return size;
        }
    }
}
