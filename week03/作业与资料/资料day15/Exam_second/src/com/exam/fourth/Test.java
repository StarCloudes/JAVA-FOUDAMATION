package com.exam.fourth;

/*
 * 4.创建一个交通工具类Transport作为父类 
 * 1)属性：类型、颜色、价格 
 * 2)方法：启动、停止的方法 3)创建子类继承自Transport类 
 * 货车：Freight Freight自己的属性：载货量 、里程，Owner owner（所有者） 
 * Freight重写父类的启动（货车载着XXX吨东西出发了）和停止（货车形式了XXXX里程之后到达了目的地开始卸货）的方法 
 * 定义一个show()方法打印 ：货车的主人是XXX，该车行驶的里程数 和载货量 
 * 所以需要封装一个Owner实体类： 属性：name age sex 方法：set/get 4)
 * 创建测试类，分别定义以上公交车类与货车类的对象，并赋值，及调用其启动与停止的方法。观查其不同。
 */
public class Test {
	 public static void main(String[] args) {
			Freight freight = new Freight("货车", "白色",100.0,1000,7.5,new Owner("李四", 23, 1));
			Bus bus = new Bus("公交车", "黑色",2.0,60,30.2,new Owner("张三", 43, 1));
			freight.start();
			freight.stop();
			freight.show();
			bus.start();
			bus.stop();
			bus.show();
		}
}
