作业一：

方式一:通过Thread的两个不同子类的线程对象实现.
方式二:通过同一个Thread类的子类的两个不同的线程对象实现
/*import java.util.*;
class shuzi extends Thread
{
	
	Random random=new Random();
	public void run()
	{
		System.out.println(random.nextInt(10));
	}
	
} 
class zimu extends Thread
{
	Random random=new Random();
	public void run()
	{
		System.out.println((char)(random.nextInt(26)+'a'));
	}
}


class lx2
{
	public static void main(String[] args) 
	{
		shuzi sz=new shuzi();
		zimu zm=new zimu();

		sz.start();
		zm.start();
	}
}
*/




import java .util.*;
class  shuzi implements Runnable
{
	
	Random random=new Random();
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+"..."+random.nextInt(10));
	}

} 
class zimu implements Runnable
{
	
	Random random=new Random();
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+"..."+(char)(random.nextInt(26)+'a'));
	}

} 
class Tu 
{
	private shuzi sz;
	private zimu zm;
	public Tu(shuzi sz)
	{
		this.sz=sz;
	}
	public Tu(zimu zm)
	{
		this.zm=zm;
	}
	
} 
class lx2
{
	public static void main(String[] args) 
	{
		shuzi sz=new shuzi();
		zimu zm=new zimu();
		Thread t1=new Thread(sz);
		Thread t2=new Thread(zm);

		t1.start();
		t2.start();
	}
}



作业二：
分析：
使用：sleep()方法
import java.util.*;
class T1 extends Thread
{
	private boolean flag=true;
	private Object obj=new Object();
	public void run()
	{
	while(flag==true)
	{
	synchronized(obj)
	{
	System.out.println("开除那个不靠谱的副总经理");
	}
	flag=false;
	}
	}
}
	

class T2 extends Thread
{
	private boolean flag=true;
	private Object obj=new Object();
	public void run()
	{
	while(flag==true)
	{
	synchronized(obj)
	{try{Thread.sleep(5);}catch(InterruptedException e){e.printStackTrace();}
	
	System.out.println("给各部门总监开会");
	}
	flag=false;
	}
	}
	
}
class T3 extends Thread
{
	private boolean flag=true;
	private Object obj=new Object();
	public void run()
	{
	while(flag==true)
	{
	synchronized(obj)
	{try{Thread.sleep(10);}catch(InterruptedException e){e.printStackTrace();}
	
	System.out.println("陪VIP客户吃饭,打牌,KTV,桑拿,按摩...");
	}
	flag=false;
	}
	}
	
}
class T4 extends Thread
{
	private boolean flag=true;
	private Object obj=new Object();
	public void run()
	{
	while(flag==true)
	{
	synchronized(obj)
	{try{Thread.sleep(15);}catch(InterruptedException e){e.printStackTrace();}
	
	System.out.println("去香港给妻子买个6 Plus作为生日礼物");
	}
	flag=false;
	}
	}
	
}
class T5 extends Thread
{
	private boolean flag=true;
	private Object obj=new Object();
	public void run()
	{
	while(flag==true)
	{
	synchronized(obj)
	{try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
	
	System.out.println("去机场接女儿送到公司旁边的希尔顿饭店休息");
	}
	flag=false;
	}
	}
	
}
class T6 extends Thread
{
	private boolean flag=true;
	private Object obj=new Object();
	public void run()
	{
	while(flag==true)
	{
	synchronized(obj)
	{try{Thread.sleep(25);}catch(InterruptedException e){e.printStackTrace();}
	
	System.out.println("陪老妈去医院看腰间盘突出");
	}
	flag=false;
	}
	}
	
}
class T7 extends Thread
{
	private boolean flag=true;
	private Object obj=new Object();
	public void run()
	{
	while(flag==true)
	{
	synchronized(obj)
	{try{Thread.sleep(30);}catch(InterruptedException e){e.printStackTrace();}
	
	System.out.println("辅导儿子做作业");
	}
	flag=false;
	}
	}
	
}
class lx2
{
	public static void main(String[] args)
	{
	T1 t1=new T1();
	T2 t2=new T2();
	T3 t3=new T3();
	T4 t4=new T4();
	T5 t5=new T5();
	T6 t6=new T6();
	T7 t7=new T7();
	
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	t6.start();
	t7.start();
	}
	

}
作业三：
分析
使用：sleep()方法阻塞当前线程
class shuchu 
{
	//private int s=1;
	//private int m=10;
	//private boolean flag=true;
	private Object obj=new Object();
	public void zheng()
	{
		System.out.println(Thread.currentThread().getName()+"....");
		
		for(int i=1;i<11;i++)
		{
			try
				{
					Thread.sleep(50);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				System.out.print(i+"  ");
			try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}

		}
			
		
	}

	public void fan()
	{
		System.out.println(Thread.currentThread().getName()+"....");
				
			for (int j=10;j>0 ;j-- )
			{
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.print(j+"  ");
				try
				{
					Thread.sleep(50);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
				
	}
}
class A extends Thread
{
	private shuchu sc;
	public A(shuchu sc)
	{
		this.sc=sc;
	}
	public void run()
	{
		while(true)
		{
		sc.zheng();
		}
	}
}
class B extends Thread
{
	private shuchu sc;
	public B(shuchu sc)
	{
		this.sc=sc;
	}
	public void run()
	{
		while(true)
		{
		sc.fan();
		}
	}
}
class lx2
{
	public static void main(String[] args)
	{
		shuchu sc=new shuchu();
		A a=new A(sc);
		B b=new B(sc);

		a.start();
		b.start();
	}
		
}

作业四：

package HomeWork;

public class ZuoYe4 {

	public static void main(String[] args) {
		Bank1 bn=new Bank1();
		Cun c=new Cun(bn);
		Qu q=new Qu(bn);
		Thread t1=new Thread(c);
		Thread t2=new Thread(c);
		Thread t3=new Thread(q);
		Thread t4=new Thread(q);
		t1.start();t2.start();t3.start();t4.start();
		
	}
}
class Bank1{//数据
	int sum=100;
	public synchronized void cun(){
		sum+=10;
		System.out.println(Thread.currentThread().getName()+"存款后"+sum);
	}
	public synchronized void qu(){
		if(sum>0){
			sum-=1;
			System.out.println(Thread.currentThread().getName()+"取款后"+sum);
		}
	}	
}
class Cun implements Runnable{
	Bank1 bank;
	int i=1;
	Object obj=new Object();
	Cun(Bank1 bank){
		this.bank=bank;
	}
	public void run(){
		synchronized (obj) {
			while(i<=100){
				
				bank.cun();
				
				i++;
			}
		}
		
		
	}	
}
class Qu implements Runnable{
	Bank1 bank;
	int i=1;
	Object obj=new Object();
	Qu(Bank1 bank){
		this.bank=bank;
	}
	public void run(){
		
		synchronized (obj) {
			while(i<=100){
				bank.qu();
				
				i++;
			}
		}
	}	
}
