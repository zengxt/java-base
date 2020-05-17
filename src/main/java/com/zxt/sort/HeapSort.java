package com.zxt.sort;

public class HeapSort {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49 };
		HeapSort obj = new HeapSort();

		System.out.print("初始数组：");
		obj.print(a);

		for (int i = 0; i < a.length; i++) {
			// 创建堆,创建的是大顶堆。每次循环完，二叉树的根节点都是最大值，所以与此时的未排好部分最后一个值交换位置
			obj.createLittleHeap(a, a.length - 1 - i);
			// 与最后一个值交换位置，最大值找到了位置
			swap(a, 0, a.length - 1 - i);
			System.out.printf("第%d躺排序：", i);
			obj.print(a);
		}

		System.out.print("最终结果：");
		obj.print(a);
	}

	// 创建大顶堆（升序排序）：双亲节点大于子节点的值。从叶子节点开始，直到根节点。这样建立的堆定位最大值
	private void createLittleHeap(int[] data, int last) {
		// 找到最后一个叶子节点的双亲节点
		for (int i = last / 2; i >= 0; i--) {
			// 保存当前正在判断的节点
			int parent = i;
			// 若当前节点的左子节点存在，即子节点存在
			while (2 * parent + 1 <= last) {
				// 由于创建大顶堆，所以大的元素要换上来，biggerIndex总是记录较大节点的值，先赋值为当前判断节点的左子节点
				int bigger = 2 * parent + 1;

				// 说明存在右子节点
				if (bigger < last) {
					// 左子节点 < 右子节点时
					if (data[bigger] < data[bigger + 1]) {
						bigger = bigger + 1;
					}
				}

				// 若双亲节点值小于子节点中较大的，则交换2者得值（创建大顶堆，大的元素要上来）
				if (data[parent] < data[bigger]) {
					swap(data, parent, bigger);
					parent = bigger;
				} else {
					break;
				}
			}
		}
	}

	public void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}

	public static void swap(int[] data, int i, int j) {
		if (i == j) {
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}
	
	/**
	 * 
	 * @Description：类似的实现
	 * 
	 * @param array
	 */
	public static void heapSort(int[] array) {
		if(array == null || array.length < 2) {
			return ;
		}
		
		// 从数组的  0-index位置构建大顶堆
		for(int i = 0; i < array.length; i++) {
			heapInsert(array, i);
		}
		
		int heapSize = array.length;
		swap(array, 0, --heapSize);
		while(heapSize > 0) {
			heapify(array, 0, heapSize);
			swap(array, 0, --heapSize);
		}
	}

	// index位置的元素调整（插入了一个元素，创建）
	private static void heapInsert(int[] arr, int index) {
		while(arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	
	// 调整堆
	public static void heapify(int[] arr, int index, int heapSize) {
		// index节点的左孩子
		int left = 2 * index + 1;
		while(left < heapSize) {
			int largest = ( left + 1 < heapSize && arr[left + 1] > arr[left] ) ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if(largest == index) {
				break;
			}
			
			// largest != index
			swap(arr, largest, index);
			index = largest;
			left = 2 * index + 1;
		}
	}
}