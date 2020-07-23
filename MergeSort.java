package Sort_hw;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 2, 5, 7, 6, 12, 17, 3 };
		mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	
	//배열을 중간값 구하여 계속 나누기
	public static void mergeSort(int[] a, int low, int high) { //a배열, low=0, high=배열길이-1=6
		if (low < high) {	//작은 값이 작고, 큰 값이 클 때
			int middle = low + (high - low) / 2;	//중간 값 구해서 배열 나누기. 소수점이 나오면 버림.
			mergeSort(a, low, middle);	//최대값을 중간값으로 기준 변경 -> 작은 요소번호 배열
			mergeSort(a, middle + 1, high);	//최소값을 중간값+1로 기준 병경 -> 큰 요소번호 배열
			merge(a, low, middle, high);	//나눈 기준 값과 배열 넘겨주기
		}
	}

	
	//실제 병합 메서드
	public static void merge(int[] a, int low, int middle, int high) {
		int[] sorted = new int[a.length];	//같은 크기의 정렬된 배열 생성
		
		for (int i = low; i <= high; i++) {	//일단 모든 값을 정렬 결과를 넣는 배열에 옮겨 담기
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
