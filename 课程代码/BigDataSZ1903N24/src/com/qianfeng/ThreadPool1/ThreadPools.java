package com.qianfeng.ThreadPool1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPools {
	 /**
     * 我们获取四次线程，观察4个线程地址
     * 
     * 说明:
     * 可以有无限大是线程数进来,如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     */
//    public static  void main(String[]args)
//    {
//        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//        System.out.println("****************************newCachedThreadPool*******************************");
//        for(int i=0;i<4;i++)
//        {
//            final int index=i;
//            //System.out.println(index);
//          newCachedThreadPool.execute(new ThreadForpool(index));//参数是加载的任务
//        }
//        
//        /*
//         *开始处理线程！！！  
//			开始处理线程！！！
//			开始处理线程！！！
//			开始处理线程！！！  这里可以同时盛装多个线程对象
//			我的线程标识是：com.qianfeng.ThreadPool1.ThreadForpool@ca0727
//			我的线程标识是：com.qianfeng.ThreadPool1.ThreadForpool@c7f867
//			我的线程标识是：com.qianfeng.ThreadPool1.ThreadForpool@71e116
//			我的线程标识是：com.qianfeng.ThreadPool1.ThreadForpool@1052a37
//         */
//    }
    
    /**
     * 我们获取四次次线程，观察4个线程地址
     * 
     * 说明:
     * 每次只有两个线程在处理，当第一个线程执行完毕后，新的线程进来开始处理
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     */
//    public static  void main(String[]args)
//    {
//        //线程池允许同时存在两个线程
//        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
//        System.out.println("****************************newFixedThreadPool*******************************");
//        for(int i=0;i<4;i++)
//        {
//            final int index=i;
//           
//            newFixedThreadPool.execute(new ThreadForpool(index));
//        }
//        /*
//         * ****************************newFixedThreadPool*******************************
//		开始处理线程！！！
//		开始处理线程！！！   这里每次最多同时存在两个线程对象
//		我的线程标识是：com.qianfeng.ThreadPool1.ThreadForpool@1152f18
//		开始处理线程！！！
//		我的线程标识是：com.qianfeng.ThreadPool1.ThreadForpool@15f791b
//		开始处理线程！！！
//		我的线程标识是：com.qianfeng.ThreadPool1.ThreadForpool@1d2ca0a
//		我的线程标识是：com.qianfeng.ThreadPool1.ThreadForpool@1989480
//         */
//    }
	
	/*
	 * 延迟一段时间,其他的与newFixedThreadPool一样,可以用来执行定时任务
	 */
//	public static void main(String[] args) {
//		ScheduledExecutorService newScheduledExecutorService = Executors.newScheduledThreadPool(2);
//		System.out.println("****************************newScheduledThreadPool*******************************");
//		
//      for(int i=0;i<4;i++)
//      {
//          final int index=i;
//         //延迟三秒执行
	
	        //TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段
//          //TimeUnit.SECONDS
//          //1.时间颗粒度转换    TimeUnit.SECONDS.toMillis(1)    SECONDS意思是单位是秒    toMillis(1),意思是转成毫秒 1000
//          //2.延时  说明在ThreadForpool.java
//          //System.out.println(TimeUnit.SECONDS.toMillis(1));
//          newScheduledExecutorService.schedule(new ThreadForpool(index), 3, TimeUnit.SECONDS);
//      }
//	}
	
	/**
     * 我们获取四次次线程，观察4个线程地址
     *
           说明:
           创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
//    public static  void main(String[]args)
//    {
//        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
//        System.out.println("****************************newFixedThreadPool*******************************");
//        for(int i=0;i<4;i++)
//        {
//            final int index=i;
//            System.out.println(index);
//            newSingleThreadExecutor.execute(new ThreadForpool(index));
//        }
//    }
    
	/**
     * 我们获取四次次线程，观察4个线程地址
     *
       说明:jdk8增加了newWorkStealingPool(int parall)，增加并行处理任务的线程池，不能保证处理的顺序。
      
     */
    public static  void main(String[]args)
    {
        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool(2);
        System.out.println("****************************newWorkStealingPool*******************************");
        for(int i=0;i<2;i++)
        {
            final int index=i;
            //System.out.println(index);
            newWorkStealingPool.execute(new ThreadForpool(index));
        }
    }
}
