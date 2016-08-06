package foundations.gettingStarted;

/**
 * First Part  Foundations
 * Chapter 2  Getting Started
 * Page 40 Problems 2.2 BUBBLESORT
 */

public class BubbleSort {
	static void bubbleSort(int[] A){
		//i计数冒泡执行的趟数，也是本轮冒泡要放的位置
		for(int i = 0; i < A.length - 1; i++){
			for(int j = A.length -1; j > i; j--){
				if(A[j] < A[j-1]){
					//交换
					int temp = A[j];
					A[j] = A[j-1];
					A[j-1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] A = {3, 1, 2, 5, 4};
		bubbleSort(A);
		System.out.print("Result:");
		for(int i = 0; i < A.length; i++){
			System.out.print(" " + A[i]);
		}
	}
}
