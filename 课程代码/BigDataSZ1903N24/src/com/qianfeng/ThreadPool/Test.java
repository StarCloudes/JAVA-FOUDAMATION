package com.qianfeng.ThreadPool;

import java.util.ArrayList;
import java.util.List;
//这种方式非常简单，但是程序在处理的过程中非常的耗时，使用的时间会很长，
//因为每个线程都在等待当前线程执行完才会执行，和多线程没有多少关系，所以效率非常低。
public class Test {

    private static List<FileInfo> fileList= new ArrayList<FileInfo>();

    public static void main(String[] args) throws InterruptedException {

              createFileInfo();

              long startTime=System.currentTimeMillis();

              for(FileInfo fi:fileList){

                       //Thread.sleep(1);

              }

              long endTime=System.currentTimeMillis();

              System.out.println("单线程耗时："+(endTime-startTime)/1000.0+"s");

    }

   

    private static void createFileInfo(){

              for(int i=0;i<3000;i++){

                       fileList.add(new FileInfo("身份证正面照","jpg","101522","md5"+i,"1"));

              }

    }

}