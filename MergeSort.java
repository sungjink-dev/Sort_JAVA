package com.test;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 2, 5, 7, 6, 12, 17, 3 };
		mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	
	//�迭�� �߰��� ���Ͽ� ��� ������
	public static void mergeSort(int[] a, int low, int high) { //a�迭, low=0, high=�迭����-1=6
		if (low < high) {	//���� ���� �۰�, ū ���� Ŭ ��
			int middle = low + (high - low) / 2;	//�߰� �� ���ؼ� �迭 ������. �Ҽ����� ������ ����.
			mergeSort(a, low, middle);	//�ִ밪�� �߰������� ���� ���� -> ���� ��ҹ�ȣ �迭
			mergeSort(a, middle + 1, high);	//�ּҰ��� �߰���+1�� ���� ���� -> ū ��ҹ�ȣ �迭
			merge(a, low, middle, high);	//���� ���� ���� �迭 �Ѱ��ֱ�
		}
	}

	
	//���� ���� �޼���
	public static void merge(int[] a, int low, int middle, int high) {
		int[] sorted = new int[a.length];	//���� ũ���� ���ĵ� �迭 ����
		
		for (int i = low; i <= high; i++) {	//�ϴ� ��� ���� ���� ����� �ִ� �迭�� �Ű� ���
			sorted[i] = a[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while(i <= middle && j <= high) {	//
			if (sorted[i] <= sorted[j]) {
				a[k] = sorted[i];
				i++;
			} else {
				a[k] = sorted[j];
				j++;
			}
			k++;
		}
		
		while (i <= middle) {
			a[k] = sorted[i];
			k++;
			i++;
		}
	}

}
