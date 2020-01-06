package com.kind.threadpool.Task;

/**
 * 永不终止的任务，为了演示线程池使用
 * @author zhoujifeng
 * @date 2020/1/6 19:13
 */
public class NotTerminateTask implements Runnable {

    public void run() {

        while (true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
