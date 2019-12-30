package com.kind.basic.Interrupt;

/**
 * 演示interrupted()方法
 * 注意：interrupted()方法一定是面向的当前线程，而不是当前对象
 * @author zhoujifeng
 * @date 2019/12/30 19:48
 */
public class InterruptedTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                for(;;){

                }
            }
        });
        //启动子线程
        thread.start();
        //中断子线程
        thread.interrupt();
        //isInterrupted面向的当前线程对象，所以被中断之后返回true
        System.out.println("isInterrupted:"+thread.isInterrupted());
        //interrupted面向的线程，现在的线程是main线程，所以返回结果是main线程的中断标识，返回false
        System.out.println("interrupted:"+thread.interrupted());
        //同上
        System.out.println("interrupted:"+Thread.interrupted());
        //interrupted方法虽然会重置标志，但是一直对main线程重置，所以thread线程的中断标识还是true
        System.out.println("isInterrupted:"+thread.isInterrupted());

        //不然当前线程结束
        thread.join();

    }
}
