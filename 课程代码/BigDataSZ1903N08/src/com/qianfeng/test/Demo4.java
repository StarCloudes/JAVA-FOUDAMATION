package com.qianfeng.test;
/*
 * 封装性:通过对具体属性的封装实现的.把对成员变量的访问进行私有化,通过公共的方法间接的实现访问
 * 好处:提高了代码的安全性,复用性和可读性.
 */
public class Demo4 {
	public static void main(String[] args) {
		/*
		 * 开枪射击
		 */
		Gun gun = new Gun();
		//脏数据:我们把程序中出现的不符合逻辑的数据称为脏数据
		/*
		 * 原因:让用户直接将数据传给了成员变量
		 * 解决:1.不让他直接传值----将成员变量私有化,写一个公共的方法
		 * 2.对数据进行过滤,将过滤后的数据交给成员变量
		 */
		//gun.bulletNumber = -5;
		//gun.addBulletNumber(-5);
		gun.setBulletNumber(-5);
		gun.shoot();
		
		/*
		 * 因为往往我们会有大量的属性需要进行赋值取值操作,所以就形成了一个规范
		 * 赋值的规范:set
		 * 构成:修饰词  返回值   方法名 (参数列表){
		 * 		方法体中的代码
		 * 		return 返回值
		 * }
		 * 修饰词:一定是public
		 * 返回值:不需要,这里写void
		 * 方法名:set+属性的名字,名字的首字母大写
		 * 参数列表:一般只有一个,写法:与属性同名
		 * 代码:this.属性的名字 = 参数
		 * return:不需要
		 * 取值的规范:get
		 * 构成:修饰词  返回值   方法名 (参数列表){
		 * 		方法体中的代码
		 * 		return 返回值
		 * }
		 * 修饰词:public
		 * 返回值:类型与属性一致
		 * 方法名:get+属性的名字,首字母大写
		 * 参数列表:不需要
		 * 代码:没有
		 * return 属性的名字/this.属性的名字
		 */
	}
}

class Gun{
	//private是一个权限修饰符,被他修饰的成员只对当前的类可见.
	private int bulletNumber;
	private int age;
	private int weight;
	private String model;
	
	public void shoot() {
		if (bulletNumber > 0) {
			--bulletNumber;
		}
		System.out.println("剩余子弹数量:"+ bulletNumber);
	}
	
//	public void addBulletNumber(int number) {
//		//过滤
//		if (number < 0) {
//			bulletNumber = 0;
//		}else {
//			bulletNumber = number;
//		}
//	}
	public void setBulletNumber(int bulletNumber) {
		if (bulletNumber < 0) {
			this.bulletNumber = 0;
		}else {
			this.bulletNumber = bulletNumber;
		}
	}
	
	public int getBulletNumber() {
		return this.bulletNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}
