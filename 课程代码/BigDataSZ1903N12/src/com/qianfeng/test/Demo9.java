package com.qianfeng.test;
/*
 * 使用自定义异常解决
 * 
 * 题目:老师使用电脑上课
 * 上课时电脑可能发生蓝屏异常---重启电脑
 * 				       死机异常---- 老师上课异常-----去苹果店修电脑
 *
 */
public class Demo9 {
	public static void main(String[] args) {
		Teacher1 teacher1 = new Teacher1(new Computer());
		try {
			teacher1.work();
		} catch (ClassingException e) {
			e.printStackTrace();
			System.out.println("去中关村修电脑");
		}
	}
}

//创建三个异常类
class ClassingException extends Exception{
	public ClassingException() {}

	public ClassingException(String message) {
		super(message);
	}
}

class LanPingException extends Exception{
	public LanPingException() {
	}

	public LanPingException(String message) {
		super(message);
	}
}

class MaoYanException extends Exception{
	public MaoYanException() {
	}

	public MaoYanException(String message) {
		super(message);
	}
}

class Teacher1 {
	Computer computer;

	public Teacher1(Computer computer) {
		super();
		this.computer = computer;
	}
	//老师上课
	public void work() throws ClassingException
	{
		try {
			computer.computerWork();
		} catch (LanPingException  e) {
			e.printStackTrace();
			computer.reset();
		} catch (MaoYanException  e) {
			e.printStackTrace();
			throw new ClassingException("老师无法继续上课");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class Computer{
	//设定当前的状态值:代表要发生的异常   1.蓝屏    2.冒烟
	int status = 2;
	//重启方法
	public void reset(){
		System.out.println("重启电脑");
	}
	
	//电脑工作
	public void computerWork() throws LanPingException,MaoYanException
	{
		switch (status) {
		case 1://蓝屏
			throw new LanPingException("电脑蓝屏了");
			//break;
	    case 2://冒烟
			throw new MaoYanException("电脑冒烟了");
			//break;
		default:
			break;
		}
	}
}
//在重写的方法中使用异常的注意点:
/*
* 1.子类的同名方法中声明的异常等级要=<父类的.
* 2.子类的同名方法中声明的异常可以与父类的不一致,也可以不声明异常.但是此时子类方法不能再抛出异常
* 3.如果子类同名方法声明了异常,父类必须声明异常.
*/
class BadComputer extends Computer{
	
	public void computerWork() {
		
	}
}
