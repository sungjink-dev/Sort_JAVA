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

// 선택 정렬(Selection sort) - 나무위키(https://namu.wiki/w/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#s-2.1.2)
// 버블 정렬이 비교하고 바로 바꿔 넣는 걸 반복한다면 이쪽은 일단 1번째부터 끝까지 훑어서
// 가장 작은 게 1번째, 2번째부터 끝까지 훑어서 가장 작은 게 2번째……해서 (n-1)번 반복한다.
// 어찌 보면 인간이 사용하는 정렬 방식을 가장 많이 닮았다.
// 어떻게 정렬이 되어 있든 일관성 있게 {n(n-1)}/2 에 비례하는 시간이 걸린다는 게 특징.
// 또한, 버블 정렬보다 두 배 정도 빠르다.
// 파생형으로 이중 선택 정렬(Double Selection Sort)도 있다.
// 이 쪽은 끝까지 훑어서 최솟값과 최댓값을 동시에 찾아낸 뒤 최솟값은 1번째와 바꾸고 최댓값은 끝과 바꾼 다음
// 훑는 범위를 양쪽으로 한 칸씩 줄여서 반복하는 방식이다. 이 방법을 쓰면 반복 횟수가 반으로 줄어든다.
