package gettingStarted_02;

/**
 * First Part  Foundations
 * Chapter 2  Getting Started
 * Page 42 Problems 2-4 Inversions
 * Give an algorithm that determines the number of inversions 
 * in any permutation on n elements in n*lgn worst-case time. 
 * (Hint: Modify merge sort.)
 * 
 */

public class InversionsNum {
	/**
	 * 修改mergeSort方法
	 * 计算所有merge和mergeSort返回的逆序对数量和
	 */
	static int mergeSort(int[] A, int p, int r){
		int inversions = 0;
		//p >= r时数组最多只有一个数，不用排序
		if(p < r){
			int q = (p+r)/2;
			inversions += mergeSort(A, p, q);
			inversions += mergeSort(A, q+1, r);
			inversions += merge(A, p, q, r);
		}
		return inversions;
	}
	
	/**
	 * 修改merge()方法
	 * 在合并的之后返回逆序对的数量
	 */
	static int merge(int[] A, int p, int q, int r){
		int reversions = 0;
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i = 0; i < n1; i++){
			L[i] = A[p+i];
		}
		for(int j = 0; j < n2; j++){
			R[j] = A[q+1+j];
		}
		L[n1] = 1000000;
		R[n2] = 1000000;
		int i = 0;
		int j = 0;
		for(int k = p; k <= r; k++){
			if(L[i] <= R[j]){
				A[k] = L[i];
				i++;
			}
			else{
				A[k] = R[j];
				j++;
				//在R[j]出现后，L中L[i]后面还有多少个元素
				//就有多少个与R[j]相关的逆序对
				//因为L中的数字在原来的数组A中全部位于R中数字之前
				reversions = reversions + (L.length - 1 - i);
			}
		}
		return reversions;
		
	}
	
	public static void main(String[] args){
		int[] A = {2, 3, 8, 6, 1};
		System.out.println(mergeSort(A, 0, A.length - 1));
	}
}
