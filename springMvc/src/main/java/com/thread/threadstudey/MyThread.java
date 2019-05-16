package com.thread.threadstudey;

/**
 * MyThread 多线程 实现Thread重写run() 方法 可通过单例模式将多线程修改为单线程
 *
 * @author zhougf
 * @date 2019/5/7
 */
public class MyThread extends Thread {

    private static MyThread thread = new MyThread();

    private MyThread() {}

    public static MyThread singleThrea() {
        return thread;
    }

    @Override
    public void run() {
        int max = 101;
        for (int i = 0; i < max; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
