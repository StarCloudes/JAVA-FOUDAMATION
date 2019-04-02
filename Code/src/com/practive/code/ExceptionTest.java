package com.practive.code;


class FushuException extends Exception {
	private static final long serialVersionUID = 1L;

	public FushuException() {
	}

	public FushuException(String message) {
		super(message);// 传递消息
	}
}


public class ExceptionTest {

	public static void main(String[] args) // throws FushuException
	{	
		Math math = new Math();
		try {
			int value = math.div(4, -2);// 可能发生的异常
			System.out.println("尝试异常," + value);
		} catch (FushuException e) {
			e.printStackTrace();
			System.out.println("捕获异常");// 对当前异常的处理
		}
		System.out.println("go on");
	}
}

class Math {
	// throws FushuException 声明异常
	public int div(int a, int b) throws FushuException {
		if (b < 0) {
			throw new FushuException("除数为负数");
		}

		return a / b;
	}
}