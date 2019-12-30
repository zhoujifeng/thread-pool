package com.kind.basic.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhoujifeng
 * @date 2019/12/30 20:19
 */
public class BlockQueueTakeTest {

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(10);
        blockingQueue.offer("zhoujf");
        blockingQueue.offer("wugh");
        blockingQueue.offer("sc");

        String name = "";
        while ((name = blockingQueue.take()) != null){
            System.out.println(name);
        }
    }
}
