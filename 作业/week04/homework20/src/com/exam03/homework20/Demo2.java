package com.exam03.homework20;

//自定义一个异常，模拟吃饭没带钱的问题
public class Demo2 {
	public static void main(String[] args) {
		try {
			eat(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void eat(int money) throws NoMonnyException {
		if(money == 0) {
		   throw new NoMonnyException("没钱吃饭");
		}
		System.out.println("出门去吃饭");
	}
}


class NoMonnyException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoMonnyException() {
		
	}
	
    public NoMonnyException(String msg) {
		super(msg);
	}
}
