一、 异常

1. Throwable 父类

2. Error ：运行中出现的严重的错误，不需要我们进行更改

3. Exception ：运行中出现的不严重的错误，我们可以尝试去改动

4. Exception 分类

   * 系统异常和自定义异常

   * 编译异常和运行时异常（RuntimeException）
   * 举🌰，数组下标越界异常，空指针异常

5. java虚拟机拥有处理异常的能力，打印异常名字、原因和位置

6. 异常处理

   ```java
   // catch会对try里面的代码进行监听，try遇到异常会立即中断代码进入catch
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

7. 自定义异常
   * 解决系统没有解决的异常，可以实现跨类处理
   * 实际应用：订单异常、用户异常、负数异常
   * 举🌰，老师上课电脑异常
   * 子类重写方法中使用异常



二、模版设计模式

1. 定义：确定的功能交给当前类实现，不确定的类交给子类去实现，子类实现的结果反过来影响确定的功能。
2. 举🌰，计算一个功能的耗时



三、包装类

1. 定义：对简单数据类型的数据进行封装，形成的类

2. 基本类型转成字符串类型、字符串类型转基本类型

   * Integer.toString
   * Integer.parseInt

3. 包装类重写了toString

4. 通过调用intValue获取成员变量的值，方法内部可以自动或强制类型转换

5. 装箱和拆箱

   * 装箱：将数据装入对应的包装类

   * 拆箱：将数据从包装类取出

   * Jdk1.5开始，自动拆箱

6. 一个字节范围内相等，超出一个字节范围不相等



四、字符串