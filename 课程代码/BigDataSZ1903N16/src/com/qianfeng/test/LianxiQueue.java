package com.qianfeng.test;
import java.util.Scanner;
import java.util.LinkedList;

/*
 * 练习:用LinkedList模拟队列--课下练习
 */
public class LianxiQueue {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue queue = new Queue();
		while(true)		
		{		
		System.out.println("请选择添加还是删除字符,添加按1.删除按2.退出按0 ");
		String choose = scanner.next();		
		if (choose.equals("2")) {//判断用户选择的功能
			if (queue.isEmpty()==true) {//先判断集合此时有没有元素,如果没有要先添加元素
				System.out.println("现在集合为空,请先添加字符");
				continue;
			}else {	
				queue.deleteCharater();//从集合的开头删除元素
			}
		} 
		if(choose.equals("1")) {//判断用户选择的功能
			System.out.println("请输入要添加的字符");
			String string = scanner.next();
			queue.addCharater(string);//从集合的后方添加元素			
		}
		if(choose.equals("0")) {//判断用户选择的功能
			System.exit(0);			
		}
		else if(!(choose.equals("1")||choose.equals("2"))) {//判断用户选择的功能,如果不是需要的数字,就提醒输入不正确
			System.out.println("请输入正确的数字");
		}
		
		}		
	}
}
//谁的活儿谁干,不是你的活儿不要干
class Queue{
	LinkedList linkedList= new LinkedList();
	
	public Queue() {}
	public Queue(LinkedList linkedList) {
		super();
		this.linkedList = linkedList;
	}	
	//入队
	public void addCharater(String string) {		
		linkedList.addLast(string);	
		System.out.println(linkedList);
	}
	//出队
	public void deleteCharater() {		
		linkedList.pollFirst();	
		System.out.println(linkedList);
	}
	
	//判空
	public boolean isEmpty(){
	    return linkedList.isEmpty();
	}
}