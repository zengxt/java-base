package com.zxt.sort;

public class HeapSort {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49 };
		HeapSort obj = new HeapSort();

		System.out.print("��ʼ���飺");
		obj.print(a);

		for (int i = 0; i < a.length; i++) {
			// ������,�������Ǵ󶥶ѡ�ÿ��ѭ���꣬�������ĸ��ڵ㶼�����ֵ���������ʱ��δ�źò������һ��ֵ����λ��
			obj.createLittleHeap(a, a.length - 1 - i);
			// �����һ��ֵ����λ�ã����ֵ�ҵ���λ��
			swap(a, 0, a.length - 1 - i);
			System.out.printf("��%d������", i);
			obj.print(a);
		}

		System.out.print("���ս����");
		obj.print(a);
	}

	// �����󶥶ѣ��������򣩣�˫�׽ڵ�����ӽڵ��ֵ����Ҷ�ӽڵ㿪ʼ��ֱ�����ڵ㡣���������ĶѶ�λ���ֵ
	private void createLittleHeap(int[] data, int last) {
		// �ҵ����һ��Ҷ�ӽڵ��˫�׽ڵ�
		for (int i = last / 2; i >= 0; i--) {
			// ���浱ǰ�����жϵĽڵ�
			int parent = i;
			// ����ǰ�ڵ�����ӽڵ���ڣ����ӽڵ����
			while (2 * parent + 1 <= last) {
				// ���ڴ����󶥶ѣ����Դ��Ԫ��Ҫ��������biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ���ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�
				int bigger = 2 * parent + 1;

				// ˵���������ӽڵ�
				if (bigger < last) {
					// ���ӽڵ� < ���ӽڵ�ʱ
					if (data[bigger] < data[bigger + 1]) {
						bigger = bigger + 1;
					}
				}

				// ��˫�׽ڵ�ֵС���ӽڵ��нϴ�ģ��򽻻�2�ߵ�ֵ�������󶥶ѣ����Ԫ��Ҫ������
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
	 * @Description�����Ƶ�ʵ��
	 * 
	 * @param array
	 */
	public static void heapSort(int[] array) {
		if(array == null || array.length < 2) {
			return ;
		}
		
		// �������  0-indexλ�ù����󶥶�
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

	// indexλ�õ�Ԫ�ص�����������һ��Ԫ�أ�������
	private static void heapInsert(int[] arr, int index) {
		while(arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	
	// ������
	public static void heapify(int[] arr, int index, int heapSize) {
		// index�ڵ������
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