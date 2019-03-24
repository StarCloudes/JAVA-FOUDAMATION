package com.qianfeng.test;

public class Demo7 {
	public static void main(String[] args) {
		/*
		 * 循环语句:for   do  while   while
		 * 
		 * 循环三要素:1.起始条件   2.结束条件    3.自增量(变化值)
		 * 学习while
		 * 
		 * 1.起始条件
		 * int num = 1;
		 * 
		 * while(判断条件){//2.结束条件
		 * 		执行语句;
		 *       3.自增量(变化值)
		 *       num+=2;
		 * }
		 * 
		 * 语句2;
		 */
		//实例:打印1-10之间的数,当数是5的时候结束打印(break),当数是3的时候跳过这次循环,继续执行下次循环(continue)
		int num = 1;
		while(num<=10) {
			System.out.println(num);
			num++;
			if (num == 5) {
				break;//结束整个循环
			}
			if (num == 3) {
				continue;//结束当次循环
			}
			System.out.println("haha"+num);
		}
		
		/*
		 * do while:do里面的内容不管条件是否成立,都会先执行一遍.
		 * 
		 * do{
		 *     执行语句;
		 * }while(判断条件);
		 */
		int num1 = 1;
		do {
			System.out.println("num1:"+num1);
			num1++;
		} while (num1<=10);
		//比较while和dowhile:do里面的内容不管条件是否成立,都会先执行一遍.
		
		/*
		 * for循环
		 * for(起始条件;结束条件;自增量){//循环体
		 * 		执行语句;
		 * }
		 * 
		 * 原理:1.会执行起始条件     
		 * 2.判断结束条件,有两种情况:第一种不成立,直接结束循环.第二种成立,就去执行循环的语句      
		 * 3.执行自增量
		 * 4.继续执行结束条件,依次反复进行,直到结束条件不成立,结束循环
		 * 
		 * 起始条件:肯定执行一次
		 * 结束条件:至少一次
		 * 自增量:0次或多次
		 * 执行语句:0次或多次
		 */
		
		for(int i=0;i<=10;i++) {
			System.out.println("i:"+i);
			if (i==5) {
				break;
			}
			
			if (i==3) {
				continue;
			}
		}
		
		//注意点:1.for与while的区别,看是否使用变量i,如果使用就用for,不用就用while
		//2.后面也可以跟空语句
		//在使用循环的时候,尽量避免出现死循环
		for(int j=0;j<10;j++)
			System.out.println("j:"+j);
		//System.out.println("jaja");
		
		
		//3.for循环可以嵌套,可以给for循环添加标识,我们可以认为是给他起了一个别名.
		n:for(int i=1;i<=3;i++) {
			m:for(int j=1;j<=3;j++) {
				System.out.println("i:"+i+"  j:"+j);
				//当i=2,j=2的时候,在这里结束外层循环
				if (i==2 && j==2) {
					break n;
				}
			}
		}
	}
}
