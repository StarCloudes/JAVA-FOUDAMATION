package com.homework.homework15;

public class Demo7 {
	public static void main(String[] args) {
		System.out.println("String耗时：" + new stringCost().run());
		System.out.println("StringBuffer耗时：" + new stringBufferCost().run());
	}

}

abstract class time {
	public abstract void func();
	
	public long run() {
		long start= System.currentTimeMillis();
		func();
		long end = System.currentTimeMillis();
		return  end - start;
	}	
}

class stringCost extends time{
	public void func() {
		String str = "";
		for(int i = 0; i < 10000; i++) {
			str += "hello";
		}
	}
}


class stringBufferCost extends time{
	public void func() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < 10000; i++) {
			buffer.append("hello");
		}
		
	}
}
