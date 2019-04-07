package com.qianfeng.test;

public class Demo2 {
	public static void main(String[] args) {
		 /*打印实心菱形            *    行数      $
	        *  $$$*         1    1      3
	        *  $$***        3    2      2
	        *  $*****       5    3      1
	        *  *******      7    4      0
	        *  
	        *  $*****       5    1
	        *  $$***        3    2
	        *  $$$*         1    3
	        */  
			//上半部分
			for(int i=1;i<=4;i++){//控制行
				//控制每行的$的个数
				for(int k=1;k<=4-i;k++){
					System.out.print(" ");
				}
				//控制每行的*个数
				for(int j=1;j<=i*2-1;j++){//控制列
					System.out.print("*");
				}
				System.out.println();
			}
			//下半部分
			for(int i=1;i<=3;i++){//控制行
				//控制每行的$的个数
				for(int k=1;k<=i;k++){
					System.out.print(" ");
				}
				//控制每行的*个数
				for(int j=1;j<=6-(i*2-1);j++){//控制列
					System.out.print("*");
				}
				System.out.println();
			}
			
			
			
	       /*   打印空心菱形  
	        *     *
	        *    * *
	        *   *   *
	        *  *     *
	        *   *   *
	        *    * *
	        *     *
	        */
			System.out.println();
			//上半部分
			for(int i=1;i<=4;i++){//控制行
				//控制每行的$的个数
				for(int k=1;k<=4-i;k++){
					System.out.print(" ");
				}
				//控制每行的*个数
				for(int j=1;j<=i*2-1;j++){//控制列
					if (j==1 || j==i*2-1) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}	
				}
				System.out.println();
			}
			//下半部分
			for(int i=1;i<=3;i++){//控制行
				//控制每行的$的个数
				for(int k=1;k<=i;k++){
					System.out.print(" ");
				}
				//控制每行的*个数
				for(int j=1;j<=6-(i*2-1);j++){//控制列
					if (j==1 || j==6-(i*2-1)) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}	
				}
				System.out.println();
			}
	}
}
