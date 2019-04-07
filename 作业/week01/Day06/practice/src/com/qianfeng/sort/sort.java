package com.qianfeng.sort;

import java.util.Arrays;

public class sort {
	public static void main(String[] args) {
		int[] arr = { 6, 2, 7, 3, 8, 9 };
		//shellSort(arr);
		//insertionSort(arr);
		//quickSort(arr, 0, 5);
		//mergeSort(arr, 0, 5);
		System.out.println(Arrays.toString(arr));
	}

	public static void shellSort(int[] data) {
		int j = 0;
		int temp = 0;

		for (int increment = data.length / 2; increment > 0; increment /= 2) // 设置步长
		{
			System.out.println("increment:" + increment);
			for (int i = increment; i < data.length; i++) {
				temp = data[i];
				for (j = i - increment; j >= 0; j -= increment) {
					if (temp < data[j]) {
						data[j + increment] = data[j];
					} else {
						break;
					}
				}
				data[j + increment] = temp;
			}
		}
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

	public static void quickSort(int[] array, int start, int end) {
		// 1,找到递归算法的出口
		if (start > end) {
			return;
		}
		// 2, 存储开始和末尾的位置
		int i = start;
		int j = end;
		// 3,存储基准值
		int key = array[start];
		// 4，完成一趟排序
		while (i < j) {
			// 4.1 ，从右往左找到第一个小于key的数
			// 要想降序只需要将> 修改成<
			while (i < j && array[j] > key) {
				j--;
			}
			// 4.2 从左往右找到第一个大于key的数
			// 要想降序只需要将<= 修改成 >=
			while (i < j && array[i] <= key) {
				i++;
			}
			// 4.3 交换
			if (i < j) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
			}
		}
		// 4.4，调整key的位置
		int p = array[i];
		array[i] = array[start];
		array[start] = p;
		System.out.println(i);
		// 5, 对key左边的数快排
		quickSort(array, start, i - 1);
		// 6, 对key右边的数快排
		quickSort(array, i + 1, end);

	}

	public static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			// 将数组拆分为两份，并递归拆分子数组，直到数组中只有一个元素
			mergeSort(array, left, center);
			mergeSort(array, center + 1, right);
			// 合并相邻数组
			merge(array, left, center, right);
			
		}
	}
 
	// 合并子数组的函数
	public static void merge(int[] array, int left, int center, int right) {
		// 临时数组，用于排序
		int[] tempArray = new int[array.length];
		// 用于将排好序的临时数组复制回原数组
		int mark = left;
		// 第二个数组的左端
		int mid = center + 1;
		// 用于临时数组的下标
		int tempLeft = left;
		while (left <= center && mid <= right) {
			// 从两个子数组中取出最小的放入临时数组，即按从小到大的顺序重新排布
			if (array[left] <= array[mid]) {
				tempArray[tempLeft++] = array[left++];
			} else {
				tempArray[tempLeft++] = array[mid++];
			}
		}
		// 剩余部分依次放入临时数组
		while (left <= center) {
			tempArray[tempLeft++] = array[left++];
		}
		while (mid <= right) {
			tempArray[tempLeft++] = array[mid++];
		}
		// 将中间数组中的内容复制回原数组
		while (mark <= right) {
			array[mark] = tempArray[mark++];
		}
	}
}
