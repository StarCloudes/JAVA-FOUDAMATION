package com.qianfeng.test;

public class Demo8 {
	public static void main(String[] args) {
		//先打印5个*   一次打印一个*
//		for(int i=0;i<5;i++) {
//			//System.out.println("*");//打印加换行
//			System.out.print("*");//只打印
//		}
		
		/*
		 * *****
		 * *****
		 * *****
		 * *****
		 * *****
		 */
		for(int j=0;j<5;j++) {//行数
			for(int i=0;i<5;i++) {//每行的*个数
				//System.out.println("*");//打印加换行
				System.out.print("*");//只打印
			}
			System.out.println();
		}
		//打印*的直角三角形
		//技巧:将行或者列中的一个当做定值,将另一个当做变量
		/*
		 * *          1
		 * **         2
		 * ***        3
		 * ****       4
		 * *****      5
		 */
		for(int j=1;j<=5;j++) {//行数
			for(int i=1;i<j+1;i++) {//每行的*个数
				//System.out.println("*");//打印加换行
				System.out.print("*");//只打印
			}
			System.out.println();
		}
		//九九乘法表   \t制表符
		for(int j=1;j<=9;j++) {//行数
			for(int i=1;i<j+1;i++) {//每行的*个数
				//System.out.println("*");//打印加换行
				System.out.print(i+"x"+j+"="+j*i+"\t");//只打印
			}
			System.out.println();
		}
		//练习
		/*
		 *  $$$*
		 *  $$***
		 *  $*****
		 *  *******

		 *   *****
		 *    ***
		 *     *
		 */
		/*
		 *     *
		 *    * *
		 *   *   *
		 *  *     *
		 *   *   *
		 *    * *
		 *     *
		 */
		/*
		 *     *
		 *    ***
		 *   *****
		 *    ***
		 *    ***
		 *    ***
		 *    ***
		 *   *****
		 *    ***
		 *     *
		 */
	}
}
