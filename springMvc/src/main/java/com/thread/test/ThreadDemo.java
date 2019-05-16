package com.thread.test;

import com.thread.threadstudey.MyThread;

/**
 * ThreadDemo
 *
 * @author zhougf
 * @date 2019/5/7
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //创建线程实例
        MyThread thread = MyThread.singleThrea();
        //修改线程名字
        thread.setName("zs");
        System.out.println(thread);
        //创建线程实例
        MyThread thread1= MyThread.singleThrea();
        thread1.setName("ls");
        System.out.println(thread1);
        thread.start();
    }
}
