#### 代码块

1. 静态代码块
   * 随着类的加载，优先于main
   * 作用：对类初始化
2. 构造代码块
   * 随着对象加载
   * 作用：对对象初始化



#### 封装性

1. 脏数据
   * 原因：用户直接将数据传给成员变量
   * 解决方案：1. 不让他直接传值。 2.对数据进行过滤，过滤后的数据交给成员变量



2. private关键字

   * private时权限修饰符，被修饰的成员支队当前类可见,  成员变量私有化

   * 成员变量的封装性

     ```java
     private int num;
     
     public  void shoot(){
       if(num > 0){
         --num;   
       }
        System.out.println("剩余子弹数量： " + num)；
     }
     
     public  void addNum(num2){
       //过滤
       if(num2<0){
         num = 0
       }else{
         num = num1;
       }
     }
     
     ```

3. 安全性、复用性、可读性   

4. get—set 

   * 一定是public修饰词

   * get\set +属性名字,第一个字母大写

     ```java
     class test{
       private int year;
       
       public void setYear(int year){
         if(year < 0){
           this.year = 0;
         }
         this.year = year;
       }
       
       public int getYear(){
         return year;
       }
     }
     ```

5. 静态和非静态的方法计算两点的距离



#### 继承

1. extends关键字

2. super关键字，只能调用父类同名的方法

3. 构造方法

   * 子类默认调用父类无参构造方法

   



#### 关键词final

1. @override注解

2. final关键字

   * fianl修饰的类代表最终，不能有子类。

   * final修饰成员变量，变量是终值，不能再被改变。
   * final修饰的方法，不允许重写。
   * 符号常量，大写





#### 抽象abstarct

1. 抽象方法
   * 拥有抽象方法的类肯定是抽象类
   * 抽象类不一定有抽象方法
2. 抽象类
   * 抽象类不能直接创建对象，通过子类实现功能
   * 基础了抽象类的子类一定要实现抽象方法，如果不实现只能自己也变成抽象类
3. 作用
   * 节省代码
   * 可以指定一批规则















