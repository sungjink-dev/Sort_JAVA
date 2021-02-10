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

// 보고 정렬(Bogo sort, stupid sort) - 나무위키 (https://namu.wiki/w/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#s-2.4.4)
// 이름 그대로 멍청한 정렬이다.
// 랜덤으로 데이터들을 재배열한 후, 정렬되었는지 검사한다.
// 정렬이 되어있지 않으면 다시 정렬될 때까지 랜덤하게 재배열한다.
// 덕분에 최악의 경우 정렬이 영원히 안 끝날 수도 있다! 물론 정렬된 데이터는 재배열 없이 한 방에 끝난다.
// 하지만 이 보고 정렬은 유전 알고리즘과 결합하면 나름 쓸만해지게 된다.
// 데이터에 따라서는 하나의 값만으로 크기를 비교할 수 없는 경우도 있다.
// 예를 들어 n차 다항식을 풀어서 나오는 결과값으로 정렬해야 하는 경우도 있는데 이런 데이터는 위에 나온 모든 정렬 알고리즘들이 다 소용없어진다.
// 이때 n차 다항식은 배열에서 데이터의 현재 위치까지 변수에 들어있는 등 사전에 계산해두는 게 불가능한 데이터이다.
// 이때 적절한 평가 함수와 유전 알고리즘을 조합하고 나서 유전 알고리즘의 후손 생성 알고리즘에 이 보고 정렬을 결합하는 것이다.
// 정말로 멍청하게 정렬된 후손은 도태되고 조금이라도 우수하게 정렬된 후손이 선택되는 과정이 반복돼서 최종적으로는 완전히 정렬된 데이터가 나온다.
// 다만 유전 알고리즘의 단점을 그대로 물려받는데, 정답이 언제 나올지는 아무도 모른다.
// 다만 실제로 돌려보면 대자연의 신비인지 생각보다 빠른 시간 안에 정답으로 수렴해간다.
