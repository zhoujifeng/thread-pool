package com.kind.threadpool.manager;

import com.kind.threadpool.Task.SleepTask;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ShutdownMethod {


    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue queue = new LinkedBlockingQueue<Runnable>(100);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,
                20,
                100,
                TimeUnit.MILLISECONDS,queue);

        //先加入任务
        for (int i = 0; i < 50; i++) {
            pool.execute(new SleepTask());

        }
        //将线程池shutdown
        pool.shutdown();

        for (;;){
            while(pool.getActiveCount() != 0){
                Thread.sleep(100);
                System.out.println("运行的线程数:"+pool.getActiveCount()+",队列SIZE:"+queue.size()+",worker数量:"+pool.getPoolSize()+"，线程数的峰值:"+pool.getLargestPoolSize());
            }
        }
    }
}
