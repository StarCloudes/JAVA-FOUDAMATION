package com.Test;
//�Զ���һ���쳣��ģ��Է�û��Ǯ������
public class Test2 {
	public static void main(String[] args) {
		int money = 0;
		System.out.println((6 << 2) + (8 >> 1) + (~7) + (7^4) + (6&4) + (7|3));
		try {
			if(money == 0)
				throw new NotMoneyException("��Ŷ~û��Ǯ");
		} catch (NotMoneyException e) {
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
	}
}
class NotMoneyException extends Exception{
	public NotMoneyException(String message) {
		super(message);
	}
	public NotMoneyException() {}
}
