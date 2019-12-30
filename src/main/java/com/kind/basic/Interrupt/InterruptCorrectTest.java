package com.kind.basic.Interrupt;

/**
 * @author zhoujifeng
 * @date 2019/12/30 19:59
 */
public class InterruptCorrectTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            public void run() {

                //这里执行Thread.interrupted()，得到中断状态返回结果true，并重置了interrupt标识
                while (!Thread.interrupted()){

                }
                //由于上面重置了interrupt标识，所以输出false
                System.out.println("thread isInterrupted:"+Thread.currentThread().isInterrupted());
            }
        });

        thread.start();
        thread.interrupt();
        thread.join();

        System.out.println("main is over");

    }
}
