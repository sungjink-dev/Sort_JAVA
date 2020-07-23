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

