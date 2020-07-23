package com.test;

public class HeapSort {

	private static int[] data;
	private static int number = 10;

	public static void main(String[] args) {
		data = new int[number];
		for (int i = 0; i < number; i++) { //
			data[i] = (int) (Math.random() * 100);	//0~99까지 중 10개 수 랜덤 초이스
		}

		System.out.print("정렬 전 : "); 
		for (int i = 0; i < number; i++) {
			System.out.print(data[i] + " ");
		}

		heap(data, number);
		
		//트리모양으로 1차 배열  후 가장 큰 값이 맨 위에 있도록 정렬 되어졌다
		//아래에서 가장 큰 값이 가장 큰 요소번호로 들어가도록 하는 것이다.
		//그리고 정렬된 값은 빼고 다시 힙정렬을 돌린다.
		for (int i = number - 1; i > 0; i--) {	//
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;

			heap(data, i);
		}

		System.out.print("\n정렬 후 : ");
		for (int i = 0; i < number; i++) {
			System.out.print(data[i] + " ");
		}

	}
/*
 *    a
 *  b   c
 * d e f g
 * 트리 모양으로 1차 정렬
 */
	public static void heap(int[] data, int number) {
		for (int i = 1; i < number; i++) {
			int child = i;	//큰 요소번호
			while (child > 0) {
				int parent = (child - 1) / 2;	//작은 요소번호
				if (data[child] > data[parent]) {	//작은 요소번호 값이 클 때,
					int temp = data[parent];	//자리 변경
					data[parent] = data[child];
					data[child] = temp;
				}
				child = parent;
			}
		}
	}

}
