package top.imdtf.multi.thread.chapter2.page72;

import top.imdtf.multi.thread.utils.ThreadUtils;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/3 22:47
 */
public class Page72T5 {
    public static void main(String[] args) {
        Task task = new Task();
        new MyThread(task, 0).start();
        new MyThread(task, 1).start();

        ThreadUtils.sleep(10000);
        long beginTime = Math.min(CommonUtils.beginTime[0], CommonUtils.beginTime[1]);
        long endTime = Math.max(CommonUtils.endTime[0], CommonUtils.endTime[1]);
        System.out.println("Time consume: " + (endTime - beginTime) + "ms.");
    }
}

class Task {
    private String getData1, getData2;

    synchronized public void doLongTimeTask() {
        System.out.println("Begin task.");
        ThreadUtils.sleep(3000);
        getData1 = "The result of executing long time task is: 1, threadName: " + ThreadUtils.getThreadName();
        getData2 = "The result of executing long time task is: 2, threadName: " + ThreadUtils.getThreadName();
        System.out.println(getData1);
        System.out.println(getData2);
        System.out.println("End task.");
    }
}

class CommonUtils {
    public static long[] beginTime = new long[2];
    public static long[] endTime = new long[2];
}

class MyThread extends Thread {
    private final Task task;
    private final int index;

    public MyThread(Task task, int index) {
        this.task = task;
        this.index = index;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime[index] = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime[index] = System.currentTimeMillis();
    }
}
