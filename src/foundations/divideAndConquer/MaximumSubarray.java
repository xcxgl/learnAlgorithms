package foundations.divideAndConquer;

/**
 * First Part  Foundations
 * Chapter 4  Divide-and-Conquer
 * Page 71 Maximum Subarray
 * 
 */

public class MaximumSubarray {
	
	
	/*跨越中点的子数组，求其最大子数组*/
	static int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high){
		int leftSum = -100000000;
		int tempSum = 0;
		int maxLeft = -1;
		for(int i = mid; i >= low; i--){
			tempSum = tempSum + A[i];
			if(tempSum > leftSum){
				leftSum = tempSum;
				maxLeft = i;
			}
		}
		int rightSum = -100000000;
		tempSum = 0;
		int maxRight = -1;
		for(int j = mid + 1; j <= high; j++){
			tempSum = tempSum + A[j];
			if(tempSum > rightSum){
				rightSum = tempSum;
				maxRight = j;
			}
		}
		int[] result = {maxLeft, maxRight, leftSum + rightSum};
		return result;
	}
	
	
	/*对整个数组，分三种情况计算最大子数组 */
	static int[] findMaximumSubarray(int[] A, int low, int high){
		//A中只有一个元素时，则和就是这个元素的值
		if(high == low){
			int[] result = {low, high, A[low]};
			return result;
		}
		//其他情况，则继续划分子数组，计算三种情况的结果
		int mid = (low + high) / 2;
		//左子数组
		int[] leftResult = findMaximumSubarray(A, low, mid);
		//右子数组
		int[] rightResult = findMaximumSubarray(A, mid + 1, high);
		//跨越中点的子数组
		int[] crossResult = findMaxCrossingSubarray(A, low, mid, high);
		if(leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2])
			return leftResult;
		else if(rightResult[2] >= leftResult[2] && rightResult[2] >= crossResult[2])
			return rightResult;
		else
			return crossResult;
		
	}
	
	public static void main(String[] args){
		int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		int[] result = findMaximumSubarray(A, 0, A.length - 1);
		System.out.println("最大子数组位置为从 " + (result[0]+1) + " 到 " + (result[1]+1) + ", 其和为 " +result[2]);
	}
}
