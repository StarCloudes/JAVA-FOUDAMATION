package com.exam.eighth;
/*
 * 8.���������߳�ģ���������ݣ���һ���̸߳�������10��ͼƬ��
 * �ڶ����̸߳�������20�����ݣ��ֱ�����20�����10���롣�۲��ӡ�����
 */
public class Demo {
	public static void main(String[] args) {
		new Thread(new downloadPic(),"ͼƬ�߳�").start();
		new Thread(new downloadData(),"�����߳�").start();
	}
}
class downloadPic implements Runnable{
	@Override
	public void run() {
       for (int i = 1; i <= 10; i++) {
		System.out.println(Thread.currentThread().getName()+"--->���ص�"+i+"��ͼƬ");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   }
}
class downloadData implements Runnable{
	@Override
	public void run() {
		  for (int i = 1; i <= 20; i++) {
				System.out.println("    "+Thread.currentThread().getName()+"--->���ص�"+i+"������");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
	}
}