一、Object

* equals() 

  默认方法比较两个对象的地址，我们可以重写equals；

  ```java
  //方法的参数类型不能随便改动，改了就不是重写了
  @override
  public boolean equals(Object obj){
    if(!(obj instanceof Car)){
       System.exit(-1); //expectionErro
    }
    Car car = (Car)obj;
    return this.wheelNum > car.WheelNum;
  }
  ```

* hashCode()

  返回值 默认十进制 long型

  ```java
  System.out.println(car.hashCode());//2018699554  默认是一个十进制的值
  		System.out.println(Integer.toHexString(car.hashCode()));//7852e922  十六进制的数
  ```

* toString()

  当直接打印引用类型时，会默认调用toString()

  ```java
  System.out.println(car);//com.qianfeng.test.Car@1   这是包名+类名+@+哈希码值
  System.out.println(car.toString());
  ```

  重写toString

  ```java
  @Override
  public String toString() {
  		return "Car [wheelNumber=" + wheelNumber + ", name=" + name + ", age=" + age + "]";}
  ```

  

* getClass 获取当前对象的字节码文件

  Class的父类也是Object

  ``` java
  //重现默认的toString
  System.out.println(car.getName()+"@"+Integer.toHexString(car.hashCode()));	
  ```

  



二、内部类

1. 内部类基础

   * 内部类的地位与A类的成员变量, **成员方法平等**, 内部类也可以看做是A类的成员, 成员之间可以**相互调用**

   * 访问特点：内部类可以直接访问外部类中的成员，包括私有成员。而外部类要访问内部类中的成员必须要建立内部类的对象。

     为什么内部类能直接访问外部类中的成员呢？ 那是因为内部类持有了外部类的引用，外部类名.this

     ```java
     System.out.println(num);
     System.out.println(this.num);
     System.out.println(Outer.this.num);
     ```

     

   * 创建内部类对象的两种方法

     1. 借用外部类的方法

        ```java
        //直接访问外部类中的内部类中的成员
         Outer.Inner in = new Outer().new Inner();
         in.show();
        
        //如果内部类是静态的，相当于一个外部类
        Outer.Inner in = new Outer.Inner();
        in.show();
        
        //如果内部类是静态的，内部类成员也是静态的，可以不用创建内部类对象，直接调用
        Outer.Inner.show();
        ```

     2. 直接创建对象  （外部类.内部类）

   * 可以间接实现多继承

   * 

2. 局部内部类

   *  局部变量的作用域:定义变量开始到函数结束

      原理:

     1. 当方法中同时存在局部内部类与成员变量时,成员变量的使用范围就会从原来的基础上进行扩大.

     2. 原因:在当前的情况下,程序会默认让final去修饰height.所以当局部变量所在的方法结束的时候,变量没有被释放,保存的值还在.  final:被final修饰的变量会被放在常量区,而常量区的值存在的时间要大于局部变量所在的方法,相当于从原来的基础上扩大了作用域

   * 实现功能私有化，增强代码的可读性和可操作性

3. 匿名子类对象

   ​         两种创建方式

   * 使用已有子类创建匿名子类对象
   * new + 父类/接口的名字  + () + {写当前子类的成员} + . + 方法()

4. 匿名内部类（对象）      节省内存

   什么时候使用匿名内部类呢？ 通常使用方法是接口类型参数，并且该接口中的方法不超过三个，可以将匿名内部类作为参数传递。

   好处：增强阅读性。

   * 动态代理
   * 访问数据库
   * 回调


