package test;

import java.util.Arrays;

public class ≤Â»Î≈≈–Ú {
	
	public static void main(String[] args) {
		int[] arr = {6,2,7,3,8,9};
		System.out.println(Arrays.toString(insertionSort(arr)));
	}

	
	public static int[] insertionSort(int[] arr) {
		int preIndex, current;
		for (int i = 1; i < arr.length; i++) {
			preIndex = i - 1;
			current = arr[i];
			while (preIndex >= 0 && arr[preIndex] > current) {
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex + 1] = current;
		}
		return arr;
	}
	
}
