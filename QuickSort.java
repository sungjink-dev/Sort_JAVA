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
		ArrayList<Integer> low = new ArrayList<Integer>(); // pivot보다 낮은 수가 들어갈 list
		ArrayList<Integer> high = new ArrayList<Integer>(); // pivot보다 높은 수가 들어갈 list
		ArrayList<Integer> result = new ArrayList<Integer>(); // 결과를 담을 list

		if (list.size() < 2) { // 요소가 1개일땐 바로 반환한다
			return list;
		} else {
			int pivot = list.get(0); // list의 0번 요소를 pivot으로 잡는다
			for (int i : list) {
				if (i < pivot) { // pivot보다 작으면
					low.add(i); // low list에 add한다
				}
				if (i > pivot) { // pivot보다 크면
					high.add(i); // high list에 add한다
				}
			}
			// 모든 list들을 return할 list에 add한다
			result.addAll(quickSort(low));
			result.add(pivot);
			result.addAll(quickSort(high));

			return result;
		}
	}
}
