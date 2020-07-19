package Sort_hw;

public class BubbleSort {
	
	public static void main(String[] args) {
		// ture : 오름차순, false : 내림차순
		int[] a = { 2, 12, 7, 6, 5, 17, 3 };
		bubblesort(true, a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void bubblesort(boolean isAscending, int... num) {
		int temp;
		if (isAscending) {	//오름차순
			for (int i = 0; i < num.length; i++) {	//i는 배열 전체를 1회 연달아 위치한 요소값을 비교
				for (int j = 0; j < num.length - 1; j++) {	//이 for문은 하나씩 제자리를 찾은
					                                        //마지막 요소 값을 하나씩 빼고 순환되도록 함.
					if (num[j] > num[j + 1]) {	//j번 요소값이 j+1번 요소값 보다 클 경우,
						temp = num[j];	//j번 요소를 temp로 빼내고
						num[j] = num[j + 1];	//j+1번의 작은 요소값을 j번에 넣는다.
						num[j + 1] = temp;	//빼놓았던 원래 j번에 있던 큰 요소값은 temp에서 꺼내어 j+1에 넣는다.
					}
				}
			}
		} else {	//내림차순 (오름 차순과 동일한 처리 과정)
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < num.length - 1; j++) {
					if (num[j] < num[j + 1]) {
						temp = num[j];
						num[j] = num[j + 1];
						num[j + 1] = temp;
					}
				}
			}
		}
	}
}
