一、 异常

1. Throwable 父类

   * Error ：运行中出现的严重的错误，不需要我们进行更改

   * Exception ：运行中出现的不严重的错误，我们可以尝试去改动

2. Exception 分类

   * 系统异常和自定义异常

   * 编译异常和运行时异常（RuntimeException）
   * 举🌰，数组下标越界异常，空指针异常

3. java虚拟机拥有处理异常的能力，打印异常名字、原因和位置

4. 异常处理

   ```java
   // catch会对try里面的代码进行监听，try遇到异常会立即中断代码进入atch
   try{
       //可能发生的异常
   }catch(Exception e){//捕获异常
       e.printStackTrace();
       //对当前异常的处理
   }
   
   //后续代码继续执行
   ```

   * 多异常处理

     ```java
     try{
         //可能发生的异常
     }catch(异常名字 e){//捕获异常
         e.printStackTrace(); 
         //对当前异常的处理
     }catch(异常名字 e){//捕获异常
         e.printStackTrace();
     }catch(Exception e){//捕获异常
         e.printStackTrace();
     }
     ```

   * Finally

     ```java
     try{
         //可能发生的异常
     }catch(Exception e){//捕获异常
         e.printStackTrace();  //对当前异常的处理
         return；//结束当前方法
         System.exit（-1）；//退出程序
     }finally{
         //必须执行的代码，释放资源，关闭数据库，关闭流
     }
     
     
     try{
         //获取资源
     }finally{
         //释放资源，关闭数据库，关闭流
     }
     ```

5. 自定义异常
   * 解决系统没有解决的异常，可以实现跨类处理
   * 实际应用：订单异常、用户异常、负数异常
   * 举🌰，老师上课电脑异常   

   ```java
   class IllegalNumException extends Exception {
   	public IllegalNumException() {
   		super();
   	}
   
   public IllegalNumException(String message) {
   		super(message);
   	}
   }
   
    //异常对象的抛出---throw
    //异常的声明(我们要给可能发生异常的方法进行异常的声明)----throws
   interface Inter {
   	public abstract double yuan(double radius) throws IllegalNumException;
   
   public abstract double ju(double length, double width) throws IllegalNumException;
   }
   
   class Hh implements Inter {
   	Hh() {
   	};
   
   	public double yuan(double radius) throws IllegalNumException {
   		if (radius < 0)
   			throw new IllegalNumException("你输入的半径不合法");
   		return 3.14 * radius * radius;
   	}
   
   	public double ju(double length, double width) throws IllegalNumException {
   		if (length < 0)
   			throw new IllegalNumException("你输入的长不合法");
   		if (width < 0)
   			throw new IllegalNumException("你输入的宽不合法");
   		return length * width;
   	}
   }
   
   class Demo10 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		System.out.println("请输入圆的半径");
   		double r = sc.nextDouble();
   		System.out.println("请输入矩形的长");
   		double a = sc.nextDouble();
   		System.out.println("请输入矩形的宽");
   		double b = sc.nextDouble();
   		Hh mianji = new Hh();
       
       //使用trycatch的位置:一般是调用可能发生异常的方法的位置
   		try {
   			System.out.print("圆的面积为" + mianji.yuan(r));
   		} catch (IllegalNumException e) {
   			System.out.println(e.getMessage());
   		}
   
   		try {
   			System.out.print("矩形的面积为" + mianji.ju(a, b));
   		} catch (IllegalNumException e) {
   			System.out.println(e.getMessage());
   		}
   	}
   }
   ```


* 子类重写方法中使用异常

  ```java
  //为了解释FuShuException构造方法中的参数如何在打印方法中显示.
  public class Demo8 {
  	public static void main(String[] args) {
  		Teacher teacher = new Teacher("除数为负数了");
  		teacher.printStackTrace();
  	}
  }
  
  class Person{//相当于Exception
  	private String message;
  	public String getMessage() {
  		return message;
  	}
  	public void setMessage(String message) {
  		this.message = message;
  	}
  	public Person() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
  	public Person(String message) {
  		super();
  		this.message = message;
  	}
  	public void printStackTrace() {
  		System.out.println(this.getMessage());
  	}
  }
  
  //相当于FuShuException
  class Teacher extends Person{
  
  	public Teacher() {
  	}
  
  	public Teacher(String message) {
  		super(message);
  	}
  }
  ```

  

二、模版设计模式

1. 定义：确定的功能交给当前类实现，不确定的类交给子类去实现，子类实现的结果反过来影响确定的功能。
2. 举🌰，计算一个功能的耗时

```java
public abstract class Game {
   abstract void initialize();
   abstract void startPlay();
   abstract void endPlay();
 
   //模板
   public final void play(){
 
      //初始化游戏
      initialize();
 
      //开始游戏
      startPlay();
 
      //结束游戏
      endPlay();
   }
}
```



三、包装类

1. 定义：专门将简单数据类型的数据进行封装,形成的对应的类

2. 字符串 → 基本类型

   * 如果字符串被Integer进行对象的封装，可使用另一个非静态的方法，intValue
   * Integer.parseInt

3. 基本类型 → 字符串

   - 基本类型数值+"" //简单
   - 用String类中的静态方法valueOf(基本类型数值);

   ```java
   /*
    * int类型和String类型的相互转换
    *  
    * int -- String
    *      String.valueOf(number)
    *  
    * String -- int
    *      Integer.parseInt(s)
    */  
   public class IntegerDemo {  
       public static void main(String[] args) {  
           // int -- String  
           int number = 100;  
           // 方式1  
           String s1 = "" + number;  
           System.out.println("s1:" + s1);  
           // 方式2  
           String s2 = String.valueOf(number);  
           System.out.println("s2:" + s2);  
           // 方式3  
           // int -- Integer -- String  
           Integer i = new Integer(number);  
           String s3 = i.toString();  
           System.out.println("s3:" + s3);  
           // 方式4  
           // public static String toString(int i)  
           String s4 = Integer.toString(number);  
           System.out.println("s4:" + s4);  
           System.out.println("-----------------");  
   
           // String -- int  
           String s = "100";  
           // 方式1  
           // String -- Integer -- int  
           Integer ii = new Integer(s);  
           // public int intValue()  
           int x = ii.intValue();  
           System.out.println("x:" + x);  
           //方式2  
           //public static int parseInt(String s)  
           int y = Integer.parseInt(s);  
           System.out.println("y:"+y);  
       }  
   }
   ```

4. 包装类重写了toString
5. 装箱和拆箱

- 装箱：将数据装入对应的包装类
- 拆箱：将数据从包装类取出
- Jdk1.5开始，自动拆箱,装箱

7. 一个字节（8bit）范围内相等，超出一个字节范围不相等

```java
/*
 * 统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
 *  
 * 分析：
 *      A:定义三个统计变量。
 *          int bigCont=0;
 *          int smalCount=0;
 *          int numberCount=0;
 *      B:键盘录入一个字符串。
 *      C:把字符串转换为字符数组。
 *      D:遍历字符数组获取到每一个字符
 *      E:判断该字符是
 *          大写  bigCount++;
 *          小写  smalCount++;
 *          数字  numberCount++;
 *      F:输出结果即可
 */  
public class CharacterTest {  
    public static void main(String[] args) {  
        // 定义三个统计变量。  
        int bigCount = 0;  
        int smallCount = 0;  
        int numberCount = 0;  

        // 键盘录入一个字符串。  
        Scanner sc = new Scanner(System.in);  
        System.out.println("请输入一个字符串：");  
        String line = sc.nextLine();  

        // 把字符串转换为字符数组。  
        char[] chs = line.toCharArray();  

        // 历字符数组获取到每一个字符  
        for (int x = 0; x < chs.length; x++) {  
            char ch = chs[x];  

            // 判断该字符  
            if (Character.isUpperCase(ch)) {  
                bigCount++;  
            } else if (Character.isLowerCase(ch)) {  
                smallCount++;  
            } else if (Character.isDigit(ch)) {  
                numberCount++;  
            }  
        }  

        // 输出结果即可  
        System.out.println("大写字母：" + bigCount + "个");  
        System.out.println("小写字母：" + smallCount + "个");  
        System.out.println("数字字符：" + numberCount + "个");  
    }  
}
```





### 作业

1. 模拟一个trim方法，去除字符串两端的空格

```java
public static void main(String[] args) 
	{
		String str="   abcd  efg   ";
		String t=trim(str);
		System.out.println(t);
	}
	public static String trim(String str)
	{
		int start=0;
		int end=str.length()-1;
		while (str.charAt(start)==' ')
		{
			start++;
		}
		while(str.charAt(end)==' ')
		{
			end--;
		}
		return str.substring(start,end+1);
	}
```

