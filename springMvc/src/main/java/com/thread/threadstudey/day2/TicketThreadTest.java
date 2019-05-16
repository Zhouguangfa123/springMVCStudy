package com.thread.threadstudey.day2;

/**
 * TicketThreadTest
 *
 * @author zhougf
 * @date 2019/5/13
 */
public class TicketThreadTest {
    public static void main(String[] args) {
        TicketThread tt = new TicketThread();
        Thread t = new Thread(tt);
        t.setName("窗口1");
        Thread t2 = new Thread(tt);
        t2.setName("窗口2");
        Thread t3 = new Thread(tt);
        t3.setName("窗口3");

        //启动线程对象
        t.start();
        t2.start();
        t3.start();
    }
}
