package foundations.gettingStarted;

/**
 * First Part  Foundations
 * Chapter 2  Getting Started
 * Page 39 Exercises 2.3-7 
 * Describe a n*lgn time algorithm that, 
 * given a set S of n integers and another integer x, 
 * determines whether or not there exist 
 * two elements in S whose sum is exactly x.
 * Solution: 
 * 1.Merge sort
 * 2.Search from both start and end. 
 */

public class CheckSums {
	static boolean checkSums(int[] S, int x){
		MergeSort.mergeSort(S, 0, S.length - 1);
		int p = 0;
		int q = S.length - 1;
		//从首尾两个方向同时向中间查找
		while(p < q){
			if(p + q == x) 
				return true;
			if(p + q > x) 
				q--;
			else
				p++;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] S = {2, 1, 4, 3, 5, 7, 6, 8};
		int x = 11;
		System.out.println(checkSums(S, x));
	}
}
