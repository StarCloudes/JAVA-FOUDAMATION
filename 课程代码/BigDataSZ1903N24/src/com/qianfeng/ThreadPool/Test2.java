package com.qianfeng.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 2） ThreadPool（线程池）+CountDownLatch（程序计数器）

顾名思义，CountDownLatch为线程计数器，他的执行过程如下：
首先，在主线程中调用await()方法，主线程阻塞，
然后，将程序计数器作为参数传递给线程对象，
最后，每个线程执行完任务后，调用countDown()方法表示完成任务。
countDown()被执行多次后，主线程的await()会失效。
 */
public class Test2 {
    
    private static ExecutorService executor=Executors.newFixedThreadPool(100);//创建线程池,最大的线程个数是100个
    private static CountDownLatch countDownLatch=new CountDownLatch(100);
    private static List<FileInfo> fileList= new ArrayList<FileInfo>();
    private static List<List<FileInfo>> list=new ArrayList<List<FileInfo>>();
    
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
        createFileInfo(); addList();
       
        long startTime=System.currentTimeMillis();
        int i=0;
        for(List<FileInfo> fi:list){
            executor.submit(new FileRunnable(countDownLatch,fi,i));//提交线程
            i++;
        }
        countDownLatch.await();//主线程阻塞
        long endTime=System.currentTimeMillis();
        executor.shutdown();//关闭线程池
        System.out.println(i+"个线程耗时："+(endTime-startTime)+"ms");
    }
    
    private static void createFileInfo(){
        for(int i=0;i<3000;i++){
            fileList.add(new FileInfo("身份证正面照","jpg","101522","md5"+i,"1"));
        }
    }
    
    private static void addList(){
        
        for(int i=0;i<100;i++){
            list.add(fileList);
        }
    }

}
