package com.thread.test;

import com.thread.threadstudey.day2.MyThread2;

/**
 * ThreadDemo3
 *
 * @author zhougf
 * @date 2019/5/7
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2(4);
        Thread t = new Thread(mt);
        t.setName("ls");
        t.run();
    }
}
