package Sort_hw;

import java.util.ArrayList;

public class QuickSort {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(30);
		list.add(7);
		list.add(22);
		list.add(50);
		list.add(30);
		list.add(18);
		list.add(22);
		list.add(20);
		System.out.println(quickSort(list));

	}

	public static ArrayList<Integer> quickSort(ArrayList<Integer> list) {
		ArrayList<Integer> low = new ArrayList<Integer>(); // pivot 작은 값 리스트 
		ArrayList<Integer> high = new ArrayList<Integer>(); // pivot 큰 값 리스트
		ArrayList<Integer> result = new ArrayList<Integer>(); // return 최종 리스트

		if (list.size() < 2) { // 하나 밖에 없으면 바로 리턴
			return list;
		} else {
			int pivot = list.get(0); // pivot 을 요소번호 0로 설정 (속도는 느리지만 간단한 방법)
			for (int i : list) {	
				if (i < pivot) { // pivot (기준 값) 보다 작으면
					low.add(i); // 낮은 값을 모으는 리스트에 넣자
				}
				if (i > pivot) { // pivot (기준 값) 보다 높으면
					high.add(i); // 높은 값을 모으는 리스트에 넣자
				}
			}
			// 
			result.addAll(quickSort(low));	//addAll 값을 받아서 한번에 저장!
			result.add(pivot);	//pivot이 중간값이기 때문에 낮은값 넣으 후에 높은 값 넣기 전 중간 값 넣어주기
			result.addAll(quickSort(high));

			return result;
		}
	}

}

// 퀵 정렬(Quick sort) - 나무위키(https://namu.wiki/w/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#s-2.2.3)
// 찰스 앤터니 리처드 호어가 1959년에 개발한 알고리즘이다.
// 퀵이라는 이름에서 알 수 있듯이 평균적인 상황에서 최고의 성능을 나타낸다.
// 컴퓨터로 가장 많이 구현된 정렬 알고리즘 중 하나이다.
// C, C++, PHP등의 언어에서 제공하는 정렬 함수에서 퀵 정렬 혹은 퀵 정렬의 변형 알고리즘을 사용한다.
// 방식은 적절한 원소 하나를 기준(피벗, pivot)으로 삼아 그보다 작은 것을 앞으로 빼내고
// 그 뒤에 피벗을 옮겨 피벗보다 작은 것, 큰 것으로 나눈뒤 나누어진 각각에서 다시 피벗을 잡고 정렬해서
// 각각의 크기가 0이나 1이 될 때까지 정렬한다.
// 이렇게 피벗을 잡고 이보다 작은 원소들을 왼쪽으로, 보다 큰 원소들을 오른쪽으로 나누는걸 partition step이라 한다.
// 퀵 정렬에도 이 partition step을 어떻게 하느냐에 따라 바리에이션이 매우 많으며, 성능 차이도 날 수 있다.

