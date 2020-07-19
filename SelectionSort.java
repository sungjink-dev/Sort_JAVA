package Sort_hw;

public class SelectionSort {
	
	public static void ascSelectionSort(int... a) {

		for (int i = 0; i < a.length - 1; i++) {	//i는 배열 전체를 1회 순회하도록 한다.
			int min = i;	//최소값을 가진 요소번호
			for (int j = i + 1; j < a.length; j++) {	//i번 요소와 비교할 다음 번호들을 순회한다.
				if (a[j] < a[min]) {	//i번 요소와 (i의 다음 번호)j번 요소 값을 비교하여 j번 요소값이 작을 경우,
					min = j;	//순회할 요소 번호가 j번으로 변경된다. 즉, 최소값 갱신
				}
			}
			int temp = a[min];	//temp 배열에다가 요소값끼리 비교 했을 때 작은 값을 빼놓고
			a[min] = a[i];	//최소값=j로 이미 위에서 처리됨. 큰 요소번호에 큰 수 넣기
			a[i] = temp;	//작은 요소번호에 작은 값 넣기
		}
		for (int i : a) {	//정렬 완료된 요소값 호출
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void descSelectionSort(int... a) {	//동일한 처리 과정

		for (int i = 0; i < a.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[max]) {
					max = j;
				}
			}
			int temp = a[max];
			a[max] = a[i];
			a[i] = temp;
		}
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 12, 57, 41, 2, 63, 4, 11, 7 };
		ascSelectionSort(a);
		descSelectionSort(a);

	}
	
}
