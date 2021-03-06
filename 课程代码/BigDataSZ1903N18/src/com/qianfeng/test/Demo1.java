package com.qianfeng.test;

public class Demo1 {
	/*
	 * 知识总结:
	 * 0.作业
	 * 1.多线程的创建-----会
	 * 	>创建Thread类的子类-----线程与任务绑定
	 * 	>单独创建Runnable的子类---线程与任务分离
	 * 2.多线程的安全---会
	 * 	>四个人卖票---synchronized
	 * 3.多线程的通信----会
	 * 	>打印机的输入输出
	 * 		>>多次输入多次输出----给两个任务区加同一把锁
	 * 		>>一次输入一次输出----唤醒等待机制
	 * 		>>使用notify,wait的注意点:必须是在同步的环境下,因为他们的使用要借助锁.
	 * 		>>优化---正确的面向对象思想,谁的事情谁干,不是你的事情不要干.
	 * 
	 * 今天的内容
	 *1.单例中的线程安全----会会会
	 *2.线程的一些注意点----了解
	 *3.单生产者单消费者-----会
	 *4.多生产者多消费者----了解
	 *5.Lock---了解
	 *6....-----了解
	 */
}
