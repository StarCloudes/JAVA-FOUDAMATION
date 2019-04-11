###多线程

1. 线程的创建（Thread）

   * new创建对象，通过start执行线程

   * 通过子类重写run方法

   ```java
   TestThread test1 = new TestThread("小白"); // one main thread
   test1.start();
   //启动线程调用的是start()方法，不是run()方法，run()方法只是封装了被线程执行的代码，调用run()只是普通方法的调用，无法启动线程。
   
   class TestThread extends Thread {
   	String mynameString;
   	
   	public TestThread(String mynameString) {
   		super();
   		this.mynameString = mynameString;
   	}
   
   	public void run() {
   		System.out.println(Thread.currentThread().getName()+ "  run" + mynameString);
   	}
   }
   ```

   * Runable 接口（线程与方法区分离）

   ```java
   //多线程的实现方案二：实现Runnable接口
   
   //1、定义类实现Runnable接口。
   class MyThread implements Runnable {
       // 2、覆盖接口中的run方法，将线程的任务代码封装到run方法中。
       public void run() {
           show();
       }
   
       public void show() {
           for (int x = 0; x < 5; x++) {
               System.out.println(Thread.currentThread().getName() + "..." + x);
           }
       }
   }
   
   class ThreadTest {
       public static void main(String[] args) {
           MyThread d = new MyThread();
           // 3、通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递。
           Thread t1 = new Thread(d);
           Thread t2 = new Thread(d);
           // 4、调用线程对象的start方法开启线程。
           t1.start();
           t2.start();
       }
   }
   ```

2. 线程安全问题

* 原因：线程共用一个数据；共享的语句有多条。

* 解决：使用同步锁，同步代码块

* 非静态同步函数和静态同步函数（没同步代码块方便）

  ```
  //锁（对象）1. 对象 2. 共享，唯一性
  synchronized（锁（对象））{  //让线程互斥
      共享的语句
  }
  
  ```

3. 线程通信

* 给两个任务加同步锁，举🌰，打印机的不断输入不断输出

* 唤醒等待，举🌰，打印机的一次输入一次输出=>单生产者单消费者

* wait方法必须放在synchronized的里面，而且调用它的对象必须和synchronized的对象是同一个。

  

### 明天

1. 单例中的线程安全——会会会
2. 线程安全注意点
3. 单生产者单消费者
4. 多生产者多消费者
5. lock

