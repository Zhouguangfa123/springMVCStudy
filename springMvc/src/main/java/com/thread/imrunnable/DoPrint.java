package com.thread.imrunnable;

/**
 * DoPrint
 *
 * @author zhougf
 * @date 2019/5/7
 */
public class DoPrint implements Runnable {

    private String name;

    public DoPrint(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0;i<5;i++){
            for(long k= 0; k <100;k++) {;
                System.out.println(name+" :"+i);
            }
        }
    }
}
