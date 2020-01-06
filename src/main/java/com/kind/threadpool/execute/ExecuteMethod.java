package com.kind.threadpool.execute;

import com.kind.threadpool.Task.SleepTask;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示了线程的创建，execute方法
 * 演示任务的处理
 * @author zhoujifeng
 * @date 2020/1/6 19:22
 */
public class ExecuteMethod {


    public static void main(String[] args) {
        try{
            LinkedBlockingQueue queue = new LinkedBlockingQueue<Runnable>(100);
            ThreadPoolExecutor pool = new ThreadPoolExecutor(10,
                    20,
                    100,
                    TimeUnit.MILLISECONDS,queue);

            for (int i = 0; i < 10; i++) {
                pool.execute(new SleepTask());
                System.out.println("运行的线程数:"+pool.getActiveCount()+",队列SIZE:"+queue.size()+",worker数量:"+pool.getPoolSize()+"，线程数的峰值:"+pool.getLargestPoolSize());

            }
            for (int i = 0; i < 100; i++) {
                pool.execute(new SleepTask());
                System.out.println("运行的线程数:"+pool.getActiveCount()+",队列SIZE:"+queue.size()+",worker数量:"+pool.getPoolSize()+"，线程数的峰值:"+pool.getLargestPoolSize());

            }
            for (int i = 0; i < 10; i++) {
                pool.execute(new SleepTask());
                System.out.println("运行的线程数:"+pool.getActiveCount()+",队列SIZE:"+queue.size()+",worker数量:"+pool.getPoolSize()+"，线程数的峰值:"+pool.getLargestPoolSize());
            }

            for (;;){
                while(pool.getActiveCount() != 0){
                    Thread.sleep(100);
                    System.out.println("运行的线程数:"+pool.getActiveCount()+",队列SIZE:"+queue.size()+",worker数量:"+pool.getPoolSize()+"，线程数的峰值:"+pool.getLargestPoolSize());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
