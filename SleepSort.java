package Sort_hw;

import java.util.concurrent.CountDownLatch;

public class SleepSort {
	public static void sleepSortAndPrint(int[] nums) {
		final CountDownLatch doneSignal = new CountDownLatch(nums.length);	//여러 쓰레드가 병력 구조로 실행될 수 있도록 한다.
		for (final int num : nums) {	//각 숫자마다 쓰레드 생성될 수 있도록 함
			new Thread(new Runnable() {	//쓰레드 사용

				public void run() {
					doneSignal.countDown();	//실행 완료된 쓰레드 카운팅 - 카운팅 완료되면 정수값 내려줘야하는데 Latch없어도 되는 걸까..?
					try {
						doneSignal.await();	//메인 잠시 대기
						Thread.sleep(num * 1000);	//값 크기만큼 대기
						System.out.println(num);
					} catch (InterruptedException e) {	//쓰레드 진행 중단될 경우
						e.printStackTrace();	//지난 처리 과정 출력
					}
				}

			}).start();	//???..스따뚜
		}
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 7, 6, 12, 17, 3 };
		sleepSortAndPrint(nums);
	}
}

/* 간단하게 알아본 내용!
 * 
 * Thread 
 * 
 * 자바 쓰레드(JAVA Thread)의 정의를 알기 전에 프로세스에 대해서 알아야 한다. 보통 우리가 짜는 프로그램이 가지고 있는 프로세스는
 * 보통 하나의 루틴(프로그램 처리 경로)이다. 즉, 어떤 일을 수행하는 것에 있어 원하는 순서대로 일을 처리한다.
 * 
 * 하지만 생각해보면 굳이 앞뒤 순서가 필요없는 일들이 있을 때 분리해서 동시에 처리하고 싶은 생각이 들 것이다. 이때 사용하는 것이
 * 쓰레드Thread이다.
 * 
 * 자바 쓰레드를 이용하면 하나의 프로세스에서도 병렬적으로 처리, 즉 여러 개의 처리 루틴을 가질 수 있다. 단순 반복의 코드를 실행할 때에도
 * 여러개의 쓰레드를 만들어서 분리시킨 뒤 결과 데이터를 합치면 그만큼 시간을 절약할 수 있다.
 */


/*
 * CountDownLatch
 * 
 * 쓰레드를 N개 실행했을 때, 일정 개수의 쓰레드가 모두 끝날 때 까지 기다려야하지만, 다음으로 진행 할 수 있거나 다른 쓰레드를 실행시킬
 * 수 있는 경우 사용한다. 예를들어 리스트에 어떤 자료구조가 있고, 각 자료구조를 병렬로 처리한 후 배치(batch)로 데이터 베이스를
 * 업데이트 한다거나 다른 시스템으로 push 하는 경우가 있다.
 * 
 * CountDownLatch를 초기화 할 때 정수값 count를 넣어준다. 쓰레드는 마지막에서 countDown()메서드를 불러준다. 그러면
 * 초기화 때 넣어준 정수값이 하나 내려간다. 즉, 각 쓰레드는 마지막에서 자신이 실행 완료했음을 countDown메서드로 알려준다. 이
 * 쓰레드들이 끝나기를 기다리는 쪽 입장에서는 await()메서드를 불러준다. 그렇면 현재 메서드가 실행중인 메인쓰레드는 더이상 진행하지않고
 * CountDownLatch의 count가 0이 될 때까지 기다린다. 0이라는 정수값이 게이트(Latch)의 역할을 한다. 카운트다운이 되면
 * 게이트(latch)가 열리는 것이다.
 */
