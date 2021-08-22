package top.imdtf.multi.thread.chapter7.page290.case2;

/**
 * 0 *
 * 1 * @Author:  deng.tengfei
 * 2 * @email:  imdtf@qq.com
 * 3 * @Date:  2021/8/22 19:38
 */
public class Page290GroupRecurseTest {
    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("A");
        ThreadGroup groupB = new ThreadGroup(groupA, "B");
        // 分配空间，但是不一定全部用完
        ThreadGroup[] threadGroups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        // 传入true是递归取得子组及子孙组
        Thread.currentThread().getThreadGroup().enumerate(threadGroups, true);
        System.out.println("Recurse true: ");
        for (ThreadGroup threadGroup : threadGroups) {
            if (threadGroup != null) {
                System.out.println(threadGroup.getName());
            }
        }

        System.out.println("\nRecurse false: ");
        threadGroups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadGroups, false);
        for (ThreadGroup threadGroup : threadGroups) {
            if (threadGroup != null) {
                System.out.println(threadGroup.getName());
            }
        }
    }
}
