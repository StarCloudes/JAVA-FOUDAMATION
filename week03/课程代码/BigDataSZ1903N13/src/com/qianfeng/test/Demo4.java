package com.qianfeng.test;
/*
 * 可变字符串:字符串缓冲区.StringBuffer/StringBuilder
 * 区别:---了解
 * StringBuffer:出现在jdk1.0,是线程安全的,考虑了线程安全问题
 * StringBuilder:出现在jdk1.5,是线程不安全的,没有考虑线程安全问题
 * 
 * 注意:在不考虑线程安全问题时,尽量使用StringBuilder,因为速度快,效率高
 */
public class Demo4 {
	public static void main(String[] args) {
		//创建一个空的可变字符串
		StringBuffer sBuffer = new StringBuffer();
    	//1.存储：
    	//StringBuffer append(boolean b)   从最后插入
        //StringBuffer insert(int offset, boolean b)   从指定位置插入
		sBuffer.append(true);
		sBuffer.append(false);
		sBuffer.insert(4, "hello");
		System.out.println(sBuffer);
        //2.删除：
        //StringBuffer delete(int start, int end) 
        //StringBuffer deleteCharAt(int index)
        //3.修改：
        //StringBuffer replace(int start, int end, String str)  替换指定的子字符串
        //void setCharAt(int index, char ch) 修改一个字符
		System.out.println(sBuffer.replace(4, 9, "world"));
        //4.获取：
        //char charAt(int index) 
		
    	//int indexOf(String str) 从零开始,从左到又查找指定的子字符串,找到了将下标返回,注意只返回首次查到的字符串的下标
    	//int indexOf(String str, int fromIndex)
		StringBuffer sBuffer2 = new StringBuffer("1000phone");
		System.out.println(sBuffer2.indexOf("phone"));
		System.out.println(sBuffer2.indexOf("phone",5));
    	//int lastIndexOf(String str) 
        //返回指定子字符串(从右边开始计数)在此字符串第一次出现时的索引
        //int lastIndexOf(String str, int fromIndex) 
        //返回指定子字符串(从右边开始计数,范围:当前指定的位置-0)在此字符串第一次出现时的索引 
        //int length() 
        //返回长度（字符数）。 

        //5.反转：
        //StringBuffer reverse()
		System.out.println(sBuffer2.reverse());
	}
}
