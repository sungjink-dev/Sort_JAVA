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


// 삽입 정렬(Insertion sort) - 나무위키(https://namu.wiki/w/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#s-2.1.3)
// 선택 정렬과 함께 인간에게 뭔가를 정렬하라고 하면 무의식적으로 사용하는 대표적인 알고리즘이다.
// k번째 원소를 1부터 k-1까지와 비교해 적절한 위치에 끼워넣고 그 뒤의 자료를 한 칸씩 뒤로 밀어내는 방식으로,
// 평균적으론 O(n^2) 중 빠른 편이나 자료구조에 따라선 뒤로 밀어내는데 걸리는 시간이 크며,
// 작은 값이 뒤쪽에 몰려있으면(내림차순의 경우 큰 게 뒤쪽에 몰려있으면) 그야말로 헬게이트다.
// 다만 이미 정렬되어 있는 자료구조에 자료를 하나씩 삽입/제거하는 경우에는 현실적으로 최고의 정렬 알고리즘이 되는데,
// 탐색을 제외한 오버헤드가 매우 적기 때문이다. 괜히 '삽입'이란 이름이 붙은 것이 아니다.
// 그밖에도 배열이 작을 경우에 역시 상당히 효율적이다.
// 일반적으로 빠르다고 알려진 알고리즘들도 배열이 작을 경우에는 대부분 삽입 정렬에 밀린다.
// 따라서 고성능 알고리즘들 중에서는 배열의 사이즈가 클때는 O(n*log(n))알고리즘을 쓰다가 정렬해야 할 부분이 작을때 는 삽입 정렬로 전환하는 것들도 있다.
// 또 굳이 장점을 뽑자면 구현이 매우 쉽다는 것.

// 파생형으로 이진 삽입 정렬(Binary insertionSort)이 있다.
// 이진 탐색을 활용해 새로운 원소가 위치할 곳을 미리 찾아서 정렬하는 방식이다.
// 원소크기를 비교하는 조건 부분을 \log{n}logn 수준으로 낮춰 조금은 더 빠르게 수행할 수 있다는 점 정도.
