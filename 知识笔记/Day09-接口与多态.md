#### 一、设计模式

1. 常用设计模式

   工厂模式、单例

2. 单例： 保证一个类在内存中的对象唯一性。 比如多个程序使用同一个配置信息对象时，就需要保证该对象的唯一性。

   * 饿汉式

   ```java
   class Single{
       //类已加载，对象就已经存在了
       private static final Single s = new Single();;
       private Single(){}
       public static Single getInstance(){
           return s ;
       }
   }
   ```

   * 懒汉式（考试用）

   ```java
   class Single{
       //类加载进来，没有对象，只有调用了getInstance方法时，才会创建对象
       //延迟加载形式
       //创建静态私有对象
       private static Single s = null;
     
       //创建构造方法，并私有化
       private Single(){}
     
       //通过公共的静态的方法将对象传出去——访问点
       public static Single getInstance(){
           if(s == null)
               s = new Single();
           return s ;
       }
     
       //功能区
       //属性和方法一般写成非静态
       int num;
   }
   
   class SingleDemo{
       public static void main(String[] args){
           Single s1 = Single.getInstance();
           Single s2 = Single. getInstance();
           System.out.println(s1 == s2);
       }
   }
   
   ```

3. 单例传值（高内聚，低耦合）

4. 运行时类Runtime



#### 二、接口

```java
interface 接口名字{//默认抽象
    默认 public final static 成员变量;  //一般不写成员变量
    默认 public abstract 成员方法;  //抽象方法。接口又叫做方法列表
}
```

1. 接口 interface

   当一个抽象类中的方法都是抽象的时候，这时可以将该抽象类用另一种形式定义和表示，就是接口。

   为了扩展笔记本的功能，但日后出现什么功能设备不知道。因此需要定义一个规则，只要日后出现的设备都符合这个规则就可以了。

2. 接口与实现  implements

   * 一个子类可以同时有多个接口，逗号隔开
   * 父类与接口的功能如何分配？主要功能放在父类，接口放额外功能。接口作为父类功能的补充。
   * 接口不可以实例化，能由实现了接口并覆盖了接口中所有的抽象方法的子类实例化。否则，这个类就是一个抽象类。
   * 允许接口类型的引用指向实现接口的实例。
   * 接口与接口的关系：可以有继承的关系，并且可以是多继承。
   * 接口中出现相同的方法，子类实现方法时不会混淆。

2. 作用：

   * 间接实现了多继承，扩充了原来的功能。我们可以认为接口时类的补充。
   * 接口定义了一种规范，接口定义了某一批类所需要遵守的规范，接口不关心这些类的内部状态数据，也不关心这些类的内部方法的实现细节，它只规定这批类里必须提供某些方法，提供这些方法的类就可满足实际需要。
   * 接口体现的是规范和实现分离的设计哲学。让规范和实现分离正是接口的好处，让软件系统的各组件之间面向接口耦合，是一种松耦合的设计。

3. 接口方法可以有方法的实现，但方法必须使用 static/default 修饰

   ```java
   //暴露的原则
   public interface USB {
   	public void open();
   	public void close();
   }
   
   //实现原则, 这些设备和电脑的耦合性降低了
   class UPan implements USB {
   	public void open() {
   		System.out.println("upan open");
   	}
   
   	public void close() {
   		System.out.println("upan close");
   	}
   }
   
   class BookPC {
   	public static void main(String[] args) {
   		// 功能扩展了
   		useUSB(new UPan());
   	}
   
   	// 使用原则
   	public static void useUSB(USB u) {// 接口类型的引用，用于接收（指向）接口的子类对象
   		if (u != null) {
   			u.open();
   			u.close();
   		}
   	}
   }
   
   ```

   4. 接口与抽象类

      A.语法层面上的区别

      - 抽象类可以提供成员方法的实现细节，而接口中只能存在public abstract 方法；

      - 抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是public static final类型的；

      - 接口中不能含有静态代码块以及静态方法，而抽象类可以有静态代码块和静态方法；

      - 一个类只能继承一个抽象类，而一个类却可以实现多个接口。

        

      B. 设计层面不同，抽象类作为很多子类的父类，它是一种模板式设计。而接口是一种行为规范，它是一种辐射式设计。也就是说：

      - 对于抽象类，如果需要添加新的方法，可以直接在抽象类中添加具体的实现，子类可以不进行变更；
      - 而对于接口则不行，如果接口进行了变更，则所有实现这个接口的类都必须进行相应的改动。
      - 继承是一个 “是不是”的关系，而 接口 实现则是 “有没有”的关系。

      ```java
      interface Alram {
          void alarm();
      }
      
      abstract class Door {
          void open();
          void close();
      }
      
      class AlarmDoor extends Door implements Alarm {
          void oepn() {
            //....
          }
          void close() {
            //....
          }
          void alarm() {
            //....
          }
      }
      ```

      

​                  

​                  





#### 三、多态

在设计一个方法时，通常希望该方法具备一定的通用性。例如要实现一个动物叫的方法，由于每种动物的叫声是不同的，因此可以在方法中接收一个动物类型的参数，当传入猫类对象时就发出猫类的叫声，传入犬类对象时就发出犬类的叫声。在同一个方法中，这种由于参数类型不同而导致执行效果各异的现象就是多态。继承是多态得以实现的基础。



1. 多态：父类的引用指向子类的对象，根据被引用子类对象特征的不同，得到不同的运行结果。

2. 工作原理注意：

   * 这个父类不一定是直接父类。

   * 实际干活的是对象

   * 编译阶段只识别等号左边的引用，执行阶段才会执行等号右边的

3. 体现：父类或者接口的引用指向或者接收自己的子类对象。

4.  作用：多态的存在提高了程序的扩展性和后期可维护性，使用之前定义的功能，后面直接拿来用。

5. 缺点：只能直接调用父类的方法，不能直接调用子类特有的方法。（自动向上转型0

   如果想使用子类特有功能，你可以将该对象进行强制向下转型。

   ```java
   abstract class Animal{
           abstract void eat();
    }
   
   class Dog extends Animal{
           void eat(){
                System.out.println("啃骨头");
           }
           void lookHome(){
                System.out.println("看家");
           }
    }
   
   class Cat extends Animal{
           void eat(){
                System.out.println("吃鱼");
           }
           void catchMouse(){
                System.out.println("抓老鼠");
           }
    }
   
   class DuoTaiDemo{
       public static void main(String[] args){
           //自动类型提升，猫对象提升到了动物类型。但是特有功能无法访问，作用就是限制对特有功能
           的访问。
           //专业讲：向上转型，将子类型隐藏。就不能使用子类的特有方法了。
           Animal a = new Cat();
           a.eat();
           //a.catchMouse();//报错
   
           //如果还想用具体动物猫的特有功能。
           //你可以将该对象进行向下转型。
           Cat c = (Cat)a; //向下转型的目的是为了能够使用子类中的特有方法。
           c.eat();
           c.catchMouse();
   
           //注意：对于转型，自始至终都是子类对象在做类型的变化。
           //Animal a = new Dog();
           //Cat c = (Cat)a;//但是类型不能随意转换，否则可能会报出ClassCastException的异常
       }
   
       public static void method(Animal a){
           a.eat();
       }
   }
   ```

   





























