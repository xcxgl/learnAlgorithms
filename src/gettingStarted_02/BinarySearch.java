package gettingStarted_02;

/**
 * First Part  Foundations
 * Chapter 2  Getting Started
 * Page 39 Exercises 2.3-5 Binary Search
 * 
 */

public class BinarySearch {
	static void search(int[] A, int p, int q, int v){
		//递归终止条件
		if(p >= q){
			if(v == A[p]){
				System.out.println(p);
				return;
			}
			else
				System.out.println("NIL");
				return ;
		}
		int r = (p + q) / 2;
	//if(v <= A[r])
		//先判断v == A[r]在一些情况下可以节省运行时间
		if(v == A[r]){
			System.out.println(r);
			return;
		}
		else if(v < A[r])
			search(A, p, r ,v);
		else
			search(A, r+1, q, v);
	}
	
	public static void main(String[] args){
		int[] A = {1, 2, 3, 4, 5, 6, 7};
		int v = 2;
		search(A, 0, A.length - 1, v);
	}
}
