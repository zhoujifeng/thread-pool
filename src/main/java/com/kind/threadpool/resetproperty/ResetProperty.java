package com.kind.threadpool.resetproperty;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ResetProperty {

    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue<Runnable>(100);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,
                20,
                100,
                TimeUnit.MILLISECONDS,queue);
        System.out.println("BEFORE:");
        System.out.println("线程池核心线程数量："+pool.getCorePoolSize());
        System.out.println("线程池最大线程数量"+pool.getMaximumPoolSize());
        System.out.println("线程池keepalive："+pool.getKeepAliveTime(TimeUnit.MILLISECONDS));
        System.out.println("线程池线程工厂"+pool.getThreadFactory());
        System.out.println("线程池拒绝策略"+pool.getRejectedExecutionHandler());

        pool.setCorePoolSize(20);
        pool.setMaximumPoolSize(40);
        //pool.setThreadFactory(new);
        pool.setKeepAliveTime(1000,TimeUnit.MILLISECONDS);
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        System.out.println("AFTER:");
        System.out.println("线程池核心线程数量："+pool.getCorePoolSize());
        System.out.println("线程池最大线程数量"+pool.getMaximumPoolSize());
        System.out.println("线程池keepalive："+pool.getKeepAliveTime(TimeUnit.MILLISECONDS));
        System.out.println("线程池线程工厂"+pool.getThreadFactory());
        System.out.println("线程池拒绝策略"+pool.getRejectedExecutionHandler());
    }
}
