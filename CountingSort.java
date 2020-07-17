
/*
 * CountingSort
 * "counting"은 "셈을 하다"라는 말입니다.
 * 
 * 일반적으로 셈을 할때는 첫째, 둘째..로 세며
 * 이는 일, 이, 삼..과 같이 값 자체를 말하는 것이 아닌
 * 값의 위치를 근거합니다.
 * 
 * Q.무엇을 counting 하나?
 * 1. 1, 10, 100의 자리수
 * 2. 각 자리 수의 출현 숫자 개수
 * 3. 출현 숫자 개수의 총 합을 이용
 *    (역으로 정렬될 자리 추적 )
 *    
 * Q.max 값을 알아야 하는 이유는?
 * max+1 값을 이용하여 배열을 만든다.
 * counting은 위치를 근거한다고 하였다.
 * counts 배열의 index = 출현 숫자 이다.
 * 즉, 배열내 주소와 숫자를 동일하게 만들기 위함이다.
 * 
 * Q.그럼 왜 min 값은 왜 안구할까?
 * 만약 min값을 구한다고해도,
 * 배열의 주소는 0부터 시작한다는 특성과 연속성을 가진다 라는 특징으로
 * 배열 자체를 중간에 짜르진 못할 것이다.
 * 그럼 일단 배열은 0부터 시작하게 만들고 검사 범위를 줄일까?
 * 당연히 이렇게 할 수는 있을 것이다.
 * 그런데 구지????
 * ㄴㄴ 자리수 별로 검사한다면 결국 0~9까지 모든 숫자를 counting하는데
 * 
 * 하지만 해당 알고리즘에서는
 * 기수 정렬의 일부를 이용하여 자리수를 나누어
 * 0~9까지 검사하는 방법을 차용하였다.
 * 단 근본적으로 위치기반으로 진행됨으로 이는 countingsort를 주로 사용하였다고 할 수 있을 것이다.
 * 
 * 
 * Q.count 누적을 하는 이유는?
 * 각 요소별로 1 또는 10 또는 100의 자리수 별로 1개의 숫자를 잘라온다.
 * 여기서 출현되는 숫자들의 개수를 모두 합하면, 여기서는 7을 초과 할 수 없다.
 * 즉, 최초 정렬하고자 하는 배열의 요소값 개수를 초과할 수 없다.
 * 
 * 이렇게 누적한 값은
 * 각 숫자들이 정렬되기 위해 배치되어야 하는 새로운 위치 주소와 동일하다.
 * 솔직히..인정머리가 있으면 이것까지 왜냐고 묻진 말자....1+1=2라잖아 나도 그렇다니까 그냥 아는거야..
 * 누적 개수를 근거하여 배치할 때마다 -1하여 주소를 하나씩 차감해주면,
 * 모든 수를 크기별로 배치할 수 있다.
 * 
 * 즉, 누적 값은 index와 같다!
 * 
 * Q.왜 거꾸로 읽기 시작해서 넣어야해?
 * 앞이나 뒤나 같은 결과 값이 나올 것이다.아마? 궁금하면..해보세요 난 더 못하겠음..
 * 추측컨데! 추측이다 추측~~
 * 만약 index=0부터 시작한다고 치자.
 * index은 ++이 되어야 하고, counting은 --가 되어야 하는 상황에서
 * 분명 추가 조건이 붙지 않을까? 라고 생갛나다.
 * 즉, index와 counting을 한 방향으로 진행하면 하나의 조건에서 진행 할 수 있으니까!
 * 혹 다른 이유라면 야밤에 갠톡해도 좋다! 나도 알고시퐁
 */
import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] array = { 142, 243, 21, 13, 11, 7, 86 };
		System.out.println("\n정렬 전\n" + Arrays.toString(array));
		countingSort(array);
	}

	public static void countingSort(int[] array) {
		final int MAX_LENGTH = CountingSort.getMaxLength(array)/*매게변수로 배열 받아오기*/,
				  myArrLen = array.length;
		System.out.println("myArrLen : " + myArrLen+"\n\n");

		int myRadix = 1;

		int[] sortedArray = new int[myArrLen], counts; // myArrLen = 7,정렬된 숫자를 넣을 배열 생성

		for (int p = 0; p < MAX_LENGTH; p++) { // MAX_LENGTH = 3;
			
			
			System.out.println("-------------turn-------------");
			
			counts = new int[10]; //정렬할 배열의 값 구성이 0~9까지의 숫자로 되어있기 때문이다.
			
			System.out.println("숫자 잘라오기");
			for (int numOfTemp : array) { 
				counts[(numOfTemp / myRadix) % 10]++;
				System.out.print(((numOfTemp / myRadix) % 10)+" ");
			}//-> 숫자 잘라오기 : 첫 turn에서 1의 자리; 두번째 turn에서 10의 자리; 세번째 turn에서 100의 자리
			
			System.out.println();
			System.out.println("자릿수 별 출현 숫자 개수의 합");
			for (int i = 1; i < 10; i++) {	//위 for문에서 잘라온 숫자를 동일한 counts index에 몇번 나왔는지 입력
				counts[i] += counts[i - 1];
//			System.out.print("["+counts[i]+"]");
			}//-> 몇 번 나왔는지 개수를 센 후, index 0~9까지 요소값을 더하여 누적 개수를 저장한다.
			
				/* "자릿수 별 출현 숫자 개수의 합" for문에 대하여
				 * counts[i]배열의 index는 0~9까지 이다.
				 * 하지만 상단과 같이 i=1로 시작할 경우, counts[0]이 출력되지 않는다.
				 * 해당 counts배열은 카운팅 목적이며 index=0의 요소값이 출력 되지 않는다고 하여 문제 될 것은 없다.
				 * 출력이 안되는 것이지 counts[0]의 요소값은 존재하기 때문이다.
				 * 이해를 위해 임의 출력 할 경우, 배열의 출력이 혼란을 가져올 수 있음으로 주의하자!
				 * 
				 * #1. for 조건으로 i=0, counts[i-1]일 경우,
				 * 처음에 index번호가 -1 로 들어가서,ArrayIndexOutOfBoundsException 발생
				 * 
				 * #2. for 조건으로 i=0, counts[i+1]일 경우,
				 * 처음에 index번호가 음수가 아니지만, 마지막 index가 지정한 10보다 커지기 때문에
				 * ArrayIndexOutOfBoundsException 발생
				 */
			
			for (int i = myArrLen - 1; i >= 0; i--) {
				System.out.println("i값 : " + i);
				sortedArray[counts[(array[i] / myRadix) % 10]-- - 1] = array[i];
				System.out.println("\ncounts[" + ((array[i] / myRadix) % 10)+"]");
			}
			
			array = sortedArray;
			for(int i = 0; i < 7 ; i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
			sortedArray = new int[myArrLen];
			myRadix *= 10;

		}
		System.out.print("\n정렬 후\n" + Arrays.toString(array));
	}

	public static int getMaxLength(int[] array) { // 가장 큰 숫자 찾아내기
		System.out.println("\n-----최대 값 뽑아내기-----");
		int max = 0;
		for (int numOfTemp : array) {
			if (max < numOfTemp)
				max = numOfTemp;
			System.out.println("max : " + max);
			System.out.println("numOfTemp : " + numOfTemp);
		}
		System.out.println ("\n" + max + " 값의 자릿수 계산하기 : "+((int) Math.log10((double) max) + 1)+"\n\n");
		return (int) Math.log10((double) max) + 1; // 결과값 : 21 / 1자리수 이상일 경우, 자리수 계산. (자릿수 구하기)
	}
}
