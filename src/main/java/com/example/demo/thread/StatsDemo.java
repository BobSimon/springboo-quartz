package com.example.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Bob Simon
 * @Description:
 * @Date:Created in 2018-05-03 9:32
 * @Modified By:
 **/
public class StatsDemo {

    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    final static String startTime = sdf.format(new Date());

    /**
     * IO密集型任务  = 一般为2*CPU核心数（常出现于线程中：数据库数据交互、文件上传下载、网络数据传输等等）
     * CPU密集型任务 = 一般为CPU核心数+1（常出现于线程中：复杂算法）
     * 混合型任务  = 视机器配置和复杂度自测而定
     */
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    /**
     * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,
     *                           TimeUnit unit,BlockingQueue<Runnable> workQueue)
     * corePoolSize用于指定核心线程数量
     * maximumPoolSize指定最大线程数
     * keepAliveTime和TimeUnit指定线程空闲后的最大存活时间
     * workQueue则是线程池的缓冲队列,还未执行的线程会在队列中等待
     * 监控队列长度，确保队列有界
     * 不当的线程池大小会使得处理速度变慢，稳定性下降，并且导致内存泄露。如果配置的线程过少，则队列会持续变大，消耗过多内存。
     * 而过多的线程又会 由于频繁的上下文切换导致整个系统的速度变缓——殊途而同归。队列的长度至关重要，它必须得是有界的，这样如果线程池不堪重负了它可以暂时拒绝掉新的请求。
     * ExecutorService 默认的实现是一个无界的 LinkedBlockingQueue。
     */
    private static ThreadPoolExecutor executor  = new ThreadPoolExecutor(corePoolSize,corePoolSize+1,10l,TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        //使用execute方法
        executor.execute(new Stats("任务A", 1000, latch));
        executor.execute(new Stats("任务B", 1000, latch));
        executor.execute(new Stats("任务C", 1000, latch));
        executor.execute(new Stats("任务D", 1000, latch));
        executor.execute(new Stats("任务E", 1000, latch));
        latch.await();// 等待所有人任务结束
        System.out.println("所有的统计任务执行完成:" + sdf.format(new Date()));
    }

    static class Stats implements Runnable  {
        String statsName;
        int runTime;
        CountDownLatch latch;

        public Stats(String statsName, int runTime, CountDownLatch latch) {
            this.statsName = statsName;
            this.runTime = runTime;
            this.latch = latch;
        }

        public void run() {
            try {
                System.out.println(statsName+ " do stats begin at "+ startTime);
                //模拟任务执行时间
                Thread.sleep(runTime);
                System.out.println(statsName + " do stats complete at "+ sdf.format(new Date()));
                latch.countDown();//单次任务结束，计数器减一
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
