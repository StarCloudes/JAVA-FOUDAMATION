1. 单例的安全性问题

   ```java
   //单例的线程安全
   class Single1{
   	private static final Single1 single1= new Single1();
   	private Single1() {
   		
   	}
   	//因为只有一行代码，不会产生线程安全
   	public static Single1 getSingle() {
   		return single1;
   	}
   }
   //懒汉式
   class Single2{
   	private static Single2 single2 = null;
   	private Single2() {
   		
   	}
   	public static Single2 getSingle() {
   		if(single2 == null) { //减少线程安全判断次数
   			synchronized(single2.getClass()) {//使用同步代码块
   				if(single2 == null) {        //线程安全问题
   					single2 = new Single2();
   				}			
   			}
   		}	
   		return single2;
   	}
   	@Override
   	protected Object clone() throws CloneNotSupportedException {
           return single2;
   	}
   }
   ```

   

2. 线程注意事项

   ```java
   new Thread() {//匿名线程对象-匿名内部类直接开启线程
     public void run() {
       System.out.println(Thread.currentThread().getName()+"   haha");
     }
   }.start();
   
   new Thread() {//匿名线程对象调用普通的run方法，这里没有创建新线程
     public void run() {
       System.out.println(Thread.currentThread().getName()+"  hehe");
     }
   }.run();//普通方法，主线程
   ```

   

3. 单生产者单消费者、多生产者多消费者

   ```java
   /* 生产者消费者:
   * 单生产者单消费者-----会
   * 多生产者多消费者-----了解
   * 
   * 先学习单生产者单消费者
   * 需要的线程:两个---一个生产线程一个消费线程
   * 需要的任务:两个---一个生产任务一个消费任务
   * 需要数据:一份---产品
   */
   public class Demo2 {
   	public static void main(String[] args) {
   		//准备数据
   		Product product = new Product();
   		//准备任务
   		Producer producer = new Producer(product);
   		Consumer consumer = new Consumer(product);
   		//准备线程
   		Thread proThread = new Thread(producer);
   		Thread proThread1 = new Thread(producer);
   		Thread conThread = new Thread(consumer);
   		Thread conThread1 = new Thread(consumer);
   		//开启线程
   		proThread.start();
   		proThread1.start();
   		conThread.start();	
   		conThread1.start();
   	}
   }
   
   //创建产品
   class Product{
   	String name;//产品的名字
   	double price;//产品的价格
   	int count;//生产的产品数量
   	
   	//标识
   	boolean flag = false;
   	
   	//准备生产
   	public synchronized void setProduce(String name,double price){
   		while(flag == true) {
   			try {
   				wait();//让生产线程等待
   			} catch (InterruptedException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   		}
   		
   		this.name = name;
   		this.price = price;
   		System.out.println(Thread.currentThread().getName()+"   生产了:"+this.name+"   产品的数量:"+this.count+"   价格:"+this.price);
   		
   		count++;
   		flag = ! flag;
   		notifyAll();//唤醒消费线程
   	}
   	//准备消费
   	public  synchronized void getConsume() {
   		while (flag == false) {
   			try {
   				wait();//让消费线程等待
   			} catch (InterruptedException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   		}
   		System.out.println(Thread.currentThread().getName()+"   消费了:"+this.name+"   产品的数量:"+this.count+"   价格:"+this.price);
   		//唤醒生产线程
   		flag = ! flag;
   		notifyAll();
   	}
   }
   //创建生产任务
   class Producer implements Runnable{
   	Product product;
   	public Producer(Product product) {
   		super();
   		this.product = product;
   	}
   	public void run() {
   		while (true) {
   			product.setProduce("bingbing", 10);
   		}
   		
   	}
   }
   //创建消费任务
   class Consumer implements Runnable{
   	Product product;
   	public Consumer(Product product) {
   		super();
   		this.product = product;
   	}
   	public void run() {
   		while (true) {
   			product.getConsume();
   		}
   	}
   }
   
   ```

4. lock锁 

   * 应用场景：多生产者多消费者，提高notifyAll的效率
   * 比较syncchronized和lock

   ```java
   class BoundedBuffer {
      final Lock lock = new ReentrantLock();
      final Condition pro  = lock.newCondition(); 
      final Condition con = lock.newCondition(); 
   
      final Object[] items = new Object[100];
      int putptr, takeptr, count;
   
      public void put(Object x) throws InterruptedException {
        lock.lock();//同步代码开始
        try {
          while (count == items.length)
            pro.await(); //线程等待
          items[putptr] = x;
          if (++putptr == items.length) putptr = 0;
          ++count;
          con.signal();  //线程唤醒
        } finally {
          lock.unlock();
        }
      }
   
      public Object take() throws InterruptedException {
        lock.lock();
        try {
          while (count == 0)
            con.await();
          Object x = items[takeptr];
          if (++takeptr == items.length) takeptr = 0;
          --count;
          pro.signal();
          return x;
        } finally {
          lock.unlock();
        }
      }
    }
   
   
   
   ```

5. 结束进程的方法

   * 设置标识— 让循环结束
   * 线程处于长期等待时候，调用interrupt
   * 调用stop（不建议）

   

6. 守护线程

   * 垃圾回收线程

   * setDaemon（true），在start之前

     

7. 线程优先级
   * join方法，使用后优先级只比main线程高，在start之后



8. 线程状态图





###  作业

1. 当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法？ 

　 　不能，一个对象的一个synchronized方法只能由一个线程访问。 



2. 请说出你所知道的线程同步的方法。

   wait():使一个线程处于等待状态，并且释放所持有的对象的lock。
   sleep():使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要捕捉InterruptedException异常。
    notify():唤醒一个处于等待状态的线程，注意的是在调用此方法的时候，并不能确切的唤醒某一个等待状态的线程，而是由JVM确定唤醒哪个线程，而且不是按优先级。
   notityAll():唤醒所有处入等待状态的线程，注意并不是给所有唤醒线程一个对象的锁，而是让它们竞争。

   

3. 