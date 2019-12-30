package com.kind.basic.Interrupt;

/**
 * 演示interrupt中断其他线程
 * @author zhoujifeng
 * @date 2019/12/30 19:30
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

        //构建一个线程
        Thread thread =new Thread(new Runnable() {
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName() + ":hello");
                }
            }
        });
        //启动线程
        thread.start();
        //主线程休眠，以便子线程能输出
        Thread.sleep(1000);

        //中断线程
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        //等待子线程结束
        thread.join();
        System.out.println("main is over");

    }

}
