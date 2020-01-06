package com.kind.threadpool.manager;

import com.kind.threadpool.Task.SleepTask;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 演示了执行shutdownNow方法之后，不会再执行
 *
 */


public class ShutdownNowMethod {


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

        List<Runnable> runnables = pool.shutdownNow();

        System.out.println("未执行的任务数量："+runnables.size());

        for (;;){
            while(pool.getActiveCount() != 0){
                Thread.sleep(1);
                System.out.println("运行的线程数:"+pool.getActiveCount()+",队列SIZE:"+queue.size()+",worker数量:"+pool.getPoolSize()+"，线程数的峰值:"+pool.getLargestPoolSize());

            }
        }

    }
}
