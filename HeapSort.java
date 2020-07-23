package com.test;

public class HeapSort {

	private static int[] data;
	private static int number = 10;

	public static void main(String[] args) {
		data = new int[number];
		for (int i = 0; i < number; i++) { //
			data[i] = (int) (Math.random() * 100);	//0~99���� �� 10�� �� ���� ���̽�
		}

		System.out.print("���� �� : "); 
		for (int i = 0; i < number; i++) {
			System.out.print(data[i] + " ");
		}

		heap(data, number);
		
		//Ʈ��������� 1�� �迭  �� ���� ū ���� �� ���� �ֵ��� ���� �Ǿ�����
		//�Ʒ����� ���� ū ���� ���� ū ��ҹ�ȣ�� ������ �ϴ� ���̴�.
		//�׸��� ���ĵ� ���� ���� �ٽ� �������� ������.
		for (int i = number - 1; i > 0; i--) {	//
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;

			heap(data, i);
		}

		System.out.print("\n���� �� : ");
		for (int i = 0; i < number; i++) {
			System.out.print(data[i] + " ");
		}

	}
/*
 *    a
 *  b   c
 * d e f g
 * Ʈ�� ������� 1�� ����
 */
	public static void heap(int[] data, int number) {
		for (int i = 1; i < number; i++) {
			int child = i;	//ū ��ҹ�ȣ
			while (child > 0) {
				int parent = (child - 1) / 2;	//���� ��ҹ�ȣ
				if (data[child] > data[parent]) {	//���� ��ҹ�ȣ ���� Ŭ ��,
					int temp = data[parent];	//�ڸ� ����
					data[parent] = data[child];
					data[child] = temp;
				}
				child = parent;
			}
		}
	}

}
