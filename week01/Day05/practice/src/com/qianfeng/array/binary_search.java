package com.qianfeng.array;

public class binary_search {
	public static void main(String[] args) {
		int a[] = { 1,2,3,4,9,11 };
		int n = 6;
		int p1 = getPosition(a,n);
		System.out.print(p1);
	}
	
	static int getPosition(int a[], int key) {
		int min = 0, mid = 0;
		int max = a.length - 1;
		
		while(min < max) {
			mid = (min+max)/2;
			    
			if(key > a[mid])
				min = mid + 1;
			else if(key < a[mid])
				max = mid - 1;
			else
				return mid;
		}
		
		return mid;
		
	}
}
