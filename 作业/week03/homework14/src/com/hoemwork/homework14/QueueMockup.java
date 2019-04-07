package com.hoemwork.homework14;
import java.util.LinkedList;

//模拟队列的功能 入队 出队 判空
class Queue{
	LinkedList linkedList ;
	
	public Queue(){
		linkedList = new LinkedList<>();
	}
	public void EnterQueue(String s) {
		linkedList.offerFirst(s);
		System.out.println(s+" 入队");
	}
    public void OutQueue() {
    	if(!linkedList.isEmpty()) {
    		System.out.println((String) linkedList.pollLast()+" 出队");
    	}else {
    		System.out.println("队列已空");
    	}
	}	
}
public class QueueMockup {
   public static void main(String[] args) {
		Queue queue = new Queue();
		queue.EnterQueue("html");
		queue.EnterQueue("java");
		queue.EnterQueue("python");
		
		System.out.println(queue.linkedList);
		queue.OutQueue();
		queue.OutQueue();
		queue.OutQueue();
		queue.OutQueue();
   }
}
