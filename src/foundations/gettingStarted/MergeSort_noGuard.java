package foundations.gettingStarted;

/**
 * First Part  Foundations
 * Chapter 2  Getting Started
 * Page 37 Rewrite the MERGE procedure so that it does not use sentinels,
 * instead stopping once either array L or R has had all its elements 
 * copied back to A and then copying the remainder of the other array
 * back into A.
 */

public class MergeSort_noGuard {
	static void mergeSort(int[] A, int p, int r){
		//p >= r时数组最多只有一个数，不用排序
		if(p < r){
			int q = (p+r)/2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	//Rewrite merge() method
	static void merge(int[] A, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i = 0; i < n1; i++){
			L[i] = A[p+i];
		}
		for(int j = 0; j < n2; j++){
			R[j] = A[q+1+j];
		}
//		L[n1] = 1000000;
//		R[n2] = 1000000;
		int i = 0;
		int j = 0;
		int k = p;
		for(k = p; k <= r; k++){
			if(L[i] <= R[j]){
				A[k] = L[i];
				i++;
			}
			else{
				A[k] = R[j];
				j++;
			}
			//判断L和R是否全部被复制进A
			if(i > n1 - 1 || j > n2 - 1)
				break;
		}
		//剩余部分直接复制入A
		for(int m = i; m < n1; m++)
			A[++k] = L[m];
		for(int n = j; n < n2; n++)
			A[++k] = R[n];
		
	}
	
	public static void main(String[] args){
		int[] A = {5, 2, 4, 7, 1, 3, 2, 6};
		mergeSort(A, 0, A.length - 1);
		System.out.print("Result:");
		for(int i = 0; i < A.length; i++){
			System.out.print(" " + A[i]);
		}
	}
}
