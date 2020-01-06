package com.kind.threadpool.Task;

import java.util.Random;

/**
 * @author zhoujifeng
 * @date 2020/1/6 19:12
 */
public class SleepTask implements Runnable{

    Random r = new Random();
    public void run() {
        try {
            Long sleepTime = new Long(r.nextInt(10000));
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
