��ҵһ��

��ʽһ:ͨ��Thread��������ͬ������̶߳���ʵ��.
��ʽ��:ͨ��ͬһ��Thread��������������ͬ���̶߳���ʵ��
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



��ҵ����
������
ʹ�ã�sleep()����
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
	System.out.println("�����Ǹ������׵ĸ��ܾ���");
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
	
	System.out.println("���������ܼ࿪��");
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
	
	System.out.println("��VIP�ͻ��Է�,����,KTV,ɣ��,��Ħ...");
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
	
	System.out.println("ȥ��۸��������6 Plus��Ϊ��������");
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
	
	System.out.println("ȥ������Ů���͵���˾�Աߵ�ϣ���ٷ�����Ϣ");
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
	
	System.out.println("������ȥҽԺ��������ͻ��");
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
	
	System.out.println("������������ҵ");
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
��ҵ����
����
ʹ�ã�sleep()����������ǰ�߳�
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

��ҵ�ģ�

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
class Bank1{//����
	int sum=100;
	public synchronized void cun(){
		sum+=10;
		System.out.println(Thread.currentThread().getName()+"����"+sum);
	}
	public synchronized void qu(){
		if(sum>0){
			sum-=1;
			System.out.println(Thread.currentThread().getName()+"ȡ���"+sum);
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
