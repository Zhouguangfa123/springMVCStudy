package com.thread.threadstudey.day2;

/**
 * MyThread2
 *
 * @author zhougf
 * @date 2019/5/7
 */
public class MyThread2 implements Runnable {
    private int num;

    public MyThread2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        int max = 100;
        for (int i = 0; i < max; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + (i +num));
        }
    }
}
