package com.practive.code;

//import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class TempleteDemo {
	public static void main(String[] args) {
	    Zi2 zi = new Zi2();
	    long time = zi.getTime();
	    System.out.println(time);
	}

}


abstract class Fu2{
	public abstract void function();
	
	public long getTime() {
		long starTime = System.nanoTime();
		function();
		long endTime = System.nanoTime();
		return endTime-starTime;
	}
}


class Zi2 extends Fu2{
	public void function() {
		for(int i = 0; i< 10; i++) {
			System.out.println("i :" + i);
		}
	}
	
}