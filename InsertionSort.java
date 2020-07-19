package Sort_hw;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = { 2, 12, 7, 6, 5, 17, 3 };
		insertSort(true, a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void insertSort(boolean isAscending, int... num) {
		int temp;
		if (isAscending) {	//오름차순
			for (int i = 0; i < num.length - 1; i++) {
				for (int j = i + 1; j < num.length; j++) {
					if (num[i] > num[j]) {	//작은 요소번호의 값이 큰 요소번호의 값보다 클 경우,
						temp = num[i];	//큰 값을 꺼내고
						num[i] = num[j];	//작은 요소번호에 큰 요소번호의 작은 값은 넣어준다.
						num[j] = temp;	//큰 요소번호에 꺼내놓았던 큰 값을 넣는다.
					}
				}
			}
		} else {	//내림차순 (처리 과정 동일)
			for (int i = 0; i < num.length - 1; i++) {
				for (int j = i + 1; j < num.length; j++) {
					if (num[i] < num[j]) {
						temp = num[i];
						num[i] = num[j];
						num[j] = temp;
					}
				}
			}
		}
	}
}
