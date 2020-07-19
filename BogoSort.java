package Sort_hw;

	import java.util.ArrayList;
	import java.util.Collections;

	public class BogoSort {
		static int count;

		public static void main(String[] args) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(30);
			list.add(7);
			list.add(50);
			list.add(45);
			list.add(22);
			list.add(18);
			list.add(22);
			list.add(20);
			System.out.println(quickSort(list));
			System.out.println(count + "번의 시도만에 성공 !");
		}

		private static ArrayList<Integer> quickSort(ArrayList<Integer> list) {
			count++;
			Collections.shuffle(list);	//숫자 임의 섞기

			for (int i = 0; i < list.size() - 1; i++) {	
				if (list.get(i) > list.get(i + 1)) {	//작은요소 번호 값이 큰 요소번호의 값보다 크다면
					quickSort(list);	//숫자 전체를 임의 섞기
				}
			}
			return list;
		}
}