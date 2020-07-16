
/*
 * CountingSort
 * "counting"�� "���� �ϴ�"��� ���Դϴ�.
 * 
 * �Ϲ������� ���� �Ҷ��� ù°, ��°..�� ����
 * �̴� ��, ��, ��..�� ���� �� ��ü�� ���ϴ� ���� �ƴ�
 * ���� ��ġ�� �ٰ��մϴ�.
 * 
 * Q.������ counting �ϳ�?
 * 1. 1, 10, 100�� �ڸ���
 * 2. �� �ڸ� ���� ���� ���� ����
 * 3. ���� ���� ������ �� ���� �̿�
 *    (������ ���ĵ� �ڸ� ���� )
 *    
 * Q.max ���� �˾ƾ� �ϴ� ������?
 * max+1 ���� �̿��Ͽ� �迭�� �����.
 * counting�� ��ġ�� �ٰ��Ѵٰ� �Ͽ���.
 * counts �迭�� index = ���� ���� �̴�.
 * ��, �迭�� �ּҿ� ���ڸ� �����ϰ� ����� �����̴�.
 * 
 * Q.�׷� �� min ���� �� �ȱ��ұ�?
 * ���� min���� ���Ѵٰ��ص�,
 * �迭�� �ּҴ� 0���� �����Ѵٴ� Ư���� ���Ӽ��� ������ ��� Ư¡����
 * �迭 ��ü�� �߰��� ¥���� ���� ���̴�.
 * �׷� �ϴ� �迭�� 0���� �����ϰ� ����� �˻� ������ ���ϱ�?
 * �翬�� �̷��� �� ���� ���� ���̴�.
 * �׷��� ����????
 * ���� �ڸ��� ���� �˻��Ѵٸ� �ᱹ 0~9���� ��� ���ڸ� counting�ϴµ�
 * �� �׷��� ũ�� �����...�׸�������...�ǰ����ڳ� �ڰ�;�..�� ���� �ΰ���
 * 
 * ������ �ش� �˰��򿡼���
 * ��� ������ �Ϻθ� �̿��Ͽ� �ڸ����� ������
 * 0~9���� �˻��ϴ� ����� �����Ͽ���.
 * �� �ٺ������� ��ġ������� ��������� �̴� countingsort�� �ַ� ����Ͽ��ٰ� �� �� ���� ���̴�.
 * 
 * 
 * Q.count ������ �ϴ� ������?
 * �� ��Һ��� 1 �Ǵ� 10 �Ǵ� 100�� �ڸ��� ���� 1���� ���ڸ� �߶�´�.
 * ���⼭ �����Ǵ� ���ڵ��� ������ ��� ���ϸ�, ���⼭�� 7�� �ʰ� �� �� ����.
 * ��, ���� �����ϰ��� �ϴ� �迭�� ��Ұ� ������ �ʰ��� �� ����.
 * 
 * �̷��� ������ ����
 * �� ���ڵ��� ���ĵǱ� ���� ��ġ�Ǿ�� �ϴ� ���ο� ��ġ �ּҿ� �����ϴ�.
 * ������..�����Ӹ��� ������ �̰ͱ��� �ֳİ� ���� ����....1+1=2���ݾ� ���� �׷��ٴϱ� �׳� �ƴ°ž�..
 * ���� ������ �ٰ��Ͽ� ��ġ�� ������ -1�Ͽ� �ּҸ� �ϳ��� �������ָ�,
 * ��� ���� ũ�⺰�� ��ġ�� �� �ִ�.
 * 
 * ��, ���� ���� index�� ����!
 * 
 * Q.�� �Ųٷ� �б� �����ؼ� �־����?
 * ���̳� �ڳ� ���� ��� ���� ���� ���̴�.�Ƹ�? �ñ��ϸ�..�غ����� �� �� ���ϰ���..
 * ��������! �����̴� ����~~
 * ���� index=0���� �����Ѵٰ� ġ��.
 * index�� ++�� �Ǿ�� �ϰ�, counting�� --�� �Ǿ�� �ϴ� ��Ȳ����
 * �и� �߰� ������ ���� ������? ��� ��������.
 * ��, index�� counting�� �� �������� �����ϸ� �ϳ��� ���ǿ��� ���� �� �� �����ϱ�!
 * Ȥ �ٸ� ������� �߹㿡 �����ص� ����! ���� �˰����
 */
import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] array = { 142, 243, 21, 13, 11, 7, 86 };
		System.out.println("\n���� ��\n" + Arrays.toString(array));
		countingSort(array);
	}

	public static void countingSort(int[] array) {
		final int MAX_LENGTH = CountingSort.getMaxLength(array)/*�ŰԺ����� �迭 �޾ƿ���*/,
				  myArrLen = array.length;
		System.out.println("myArrLen : " + myArrLen+"\n\n");

		int myRadix = 1;

		int[] sortedArray = new int[myArrLen], counts; // myArrLen = 7,���ĵ� ���ڸ� ���� �迭 ����

		for (int p = 0; p < MAX_LENGTH; p++) { // MAX_LENGTH = 3;
			
			
			System.out.println("-------------turn-------------");
			
			counts = new int[10]; //������ �迭�� �� ������ 0~9������ ���ڷ� �Ǿ��ֱ� �����̴�.
			
			System.out.println("���� �߶����");
			for (int numOfTemp : array) { 
				counts[(numOfTemp / myRadix) % 10]++;
				System.out.print(((numOfTemp / myRadix) % 10)+" ");
			}//-> ���� �߶���� : ù turn���� 1�� �ڸ�; �ι�° turn���� 10�� �ڸ�; ����° turn���� 100�� �ڸ�
			
			System.out.println();
			System.out.println("�ڸ��� �� ���� ���� ������ ��");
			for (int i = 1; i < 10; i++) {	//�� for������ �߶�� ���ڸ� ������ counts index�� ��� ���Դ��� �Է�
				counts[i] += counts[i - 1];
//			System.out.print("["+counts[i]+"]");
			}//-> �� �� ���Դ��� ������ �� ��, index 0~9���� ��Ұ��� ���Ͽ� ���� ������ �����Ѵ�.
			
				/* "�ڸ��� �� ���� ���� ������ ��" for���� ���Ͽ�
				 * counts[i]�迭�� index�� 0~9���� �̴�.
				 * ������ ��ܰ� ���� i=1�� ������ ���, counts[0]�� ��µ��� �ʴ´�.
				 * �ش� counts�迭�� ī���� �����̸� index=0�� ��Ұ��� ��� ���� �ʴ´ٰ� �Ͽ� ���� �� ���� ����.
				 * ����� �ȵǴ� ������ counts[0]�� ��Ұ��� �����ϱ� �����̴�.
				 * ���ظ� ���� ���� ��� �� ���, �迭�� ����� ȥ���� ������ �� �������� ��������!
				 * 
				 * #1. for �������� i=0, counts[i-1]�� ���,
				 * ó���� index��ȣ�� -1 �� ����,ArrayIndexOutOfBoundsException �߻�
				 * 
				 * #2. for �������� i=0, counts[i+1]�� ���,
				 * ó���� index��ȣ�� ������ �ƴ�����, ������ index�� ������ 10���� Ŀ���� ������
				 * ArrayIndexOutOfBoundsException �߻�
				 */
			
			for (int i = myArrLen - 1; i >= 0; i--) {
				System.out.println("i�� : " + i);
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
		System.out.print("\n���� ��\n" + Arrays.toString(array));
	}

	public static int getMaxLength(int[] array) { // ���� ū ���� ã�Ƴ���
		System.out.println("\n-----�ִ� �� �̾Ƴ���-----");
		int max = 0;
		for (int numOfTemp : array) {
			if (max < numOfTemp)
				max = numOfTemp;
			System.out.println("max : " + max);
			System.out.println("numOfTemp : " + numOfTemp);
		}
		System.out.println ("\n" + max + " ���� �ڸ��� ����ϱ� : "+((int) Math.log10((double) max) + 1)+"\n\n");
		return (int) Math.log10((double) max) + 1; // ����� : 21 / 1�ڸ��� �̻��� ���, �ڸ��� ���. (�ڸ��� ���ϱ�)
	}
}