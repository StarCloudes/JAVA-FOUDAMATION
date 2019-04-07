package com.classroom.homework13;

class Server{
	String num = "115490";
	String password = "123456";
	
}
class QQ{
	String string;
	String p;
	
	QQ(){
		
	}
	
	QQ(String num,String p){
		this.string = num;
		this.p = p;
	}
	
	public void validate(Server s) throws LengthException,NumberException,ValidationExcepption {
		int l = string.length();
		if(l < 5|| l >11) {
		   throw new LengthException("你输入的qq长度不合法");
		}	
		
		try {
			int b = Integer.parseInt(this.string);
		} catch (Exception e) {
			throw new NumberException("你输入的qq不全为数字");
		}
		
		if(this.string != s.num || this.p != s.password ) {
			throw new NumberException("你输入的密码帐号错误");
		}
	
	}
}

class LengthException extends Exception{

	public LengthException() {
	}

	public LengthException(String message) {
		super(message);
	}	
	
}

class NumberException extends Exception{

	public NumberException() {

	}

	public NumberException(String message) {
		super(message);
	}
	
}

class ValidationExcepption extends Exception{

	public ValidationExcepption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationExcepption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}

public class Validation {
	
	public static void main(String[] args) {
		//QQ qq = new QQ("11577t","123456");
		Server server = new Server();
		QQ qq = new QQ("115490","123456");
		try {
			qq.validate(server);
			System.out.println("验证成功");	
		} catch (LengthException e) {
			System.out.println(e.getMessage());		
		} catch (NumberException e) {
			System.out.println(e.getMessage());		
		} catch(ValidationExcepption e) {
			System.out.println(e.getMessage());		
		}
		
		
			
	}
}

