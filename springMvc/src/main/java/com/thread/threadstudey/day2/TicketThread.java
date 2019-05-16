package com.thread.threadstudey.day2;

/**
 * TicketThread
 *
 * @author zhougf
 * @date 2019/5/13
 */
public class TicketThread implements Runnable {
    private int tickets = 100;

    /**
     * obj
     * */
    private Object obj = new Object();

    @Override
    public void run() {

        synchronized (obj) {
            while (true) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + tickets--);
                }
            }
        }


    }
}
