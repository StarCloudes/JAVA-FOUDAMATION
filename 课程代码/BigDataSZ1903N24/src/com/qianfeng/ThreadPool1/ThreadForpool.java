package com.qianfeng.ThreadPool1;

import java.util.concurrent.TimeUnit;


public class ThreadForpool implements Runnable{

    private Integer index;
    public  ThreadForpool(Integer index)
    {
     this.index=index;
    }
    @Override
    public void run() {
        /***
         * 业务......省略
          */
        try {
            System.out.println("开始处理线程！！！");
            Thread.sleep(index*10);
            //TimeUnit.SECONDS.sleep(index);//意思是延迟index秒
            System.out.println("我的线程标识是："+this.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
