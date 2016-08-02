package gettingStarted_02;

/**
 * First Part  Foundations
 * Chapter 2  Getting Started
 * Page 18 INSERTION-SORT
 * 
 */

public class InsertionSort {
	static void sort(int array[]){
		for(int i = 1; i < array.length; i++){
			//key表示本轮要插入的数字
			int key = array[i];
			int j = i - 1;
			//大于key的数向后移
			while(j >= 0 && array[j] > key){
				array[j+1] = array[j];
				j--;
			}
			//插入key
			array[j+1] = key;
		}
		System.out.print("Result:");
		for(int i = 0; i < array.length; i++)
			System.out.print(" " + array[i]);
	}
	
	public static void main(String[] args){
		int array[] = {5,2,4,6,1,3};
		sort(array);
	}
}
