package com.thread.extendthread;

/**
 * DoSomething
 *
 * @author zhougf
 * @date 2019/5/7
 */
public class DoSomething extends Thread{
    public DoSomething(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0;i<5;i++){
            for(long k= 0; k <100;k++) {;
            System.out.println(this.getName()+" :"+i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new DoSomething("张三");
        Thread t2 = new DoSomething("李四");
        t1.start();
        t2.start();
    }
}
