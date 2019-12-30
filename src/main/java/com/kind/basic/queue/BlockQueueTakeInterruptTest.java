package com.kind.basic.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhoujifeng
 * @date 2019/12/30 20:19
 */
public class BlockQueueTakeInterruptTest {

    public static void main(String[] args) throws InterruptedException {

        final LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(10);
        blockingQueue.offer("zhoujf");
        blockingQueue.offer("wugh");
        blockingQueue.offer("sc");

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    String name = "";
                    while ((name = blockingQueue.take()) != null){
                        System.out.println(name);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动子线程
        thread.start();
        //中断子线程，因为take方法中断时，会抛出异常，利用这一点，可以让线程退出
        thread.interrupt();
        //等待子线程结束
        thread.join();


    }
}
