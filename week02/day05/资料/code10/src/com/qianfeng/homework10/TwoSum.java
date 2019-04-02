package com.qianfeng.homework10;


public class TwoSum {
	public static void main(String[] args) {
		int[] arr = {2,5,9,11,15};
		int[] index = twoSum(arr,7);
		System.out.println(index[0]);
	}
	
	public static int[] twoSum(int[] numbers,int target) {
		if(numbers == null || numbers.length <=1) {
			return new int[0];
		}
		int[] res = new int[2];
		int left = 0, right = numbers.length -1;
		while(left<right) {
			if(target < numbers[left] + numbers[right]) {
				right--;
			}else if(target > numbers[left] + numbers[right]) {
				left++;
			}else {
				res[0] = left;
				res[1] =right;
				break;
			}
		}	
		return res;		 
	}
}
