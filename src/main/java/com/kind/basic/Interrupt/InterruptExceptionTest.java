package com.kind.basic.Interrupt;

/** 演示当某个线程阻塞挂起时，interrupt当前线程，会抛出异常，可以使用这个特性，让某个线程提前被激活
 * @author zhoujifeng
 * @date 2019/12/30 19:39
 */
public class InterruptExceptionTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            public void run() {

                try {
                    System.out.println("thread begin sleep");
                    //正常情况下当前子线程需要休眠200000s，当时被main线程interrupt之后，直接返回了
                    Thread.sleep(200000);
                    System.out.println("thread awaking");
                } catch (InterruptedException e) {
                    System.out.println("thread is interrupted while sleeping");
                    return;
                }
            }
        });

        thread.start();
        Thread.sleep(1000);

        thread.interrupt();
        thread.join();
        System.out.println("main is over");
    }
}
