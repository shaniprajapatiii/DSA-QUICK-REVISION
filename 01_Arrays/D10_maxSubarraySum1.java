// Given an integer array arr[], find the subarray (containing at least one element) which has the maximum possible sum, and return that sum.
// Note: A subarray is a continuous part of an array.

/*
Approach 1:
[Naive Approach] By iterating over all subarrays - O(n^2) Time and O(1) Space
The idea is to run two nested loops to iterate over all possible subarrays and find the maximum sum. The outer loop will mark the starting point of a subarray and inner loop will mark the ending point of the subarray.
*/

public class D10_maxSubarraySum1 {

   public static int maxSubarraySum(int[] arr) {
      int res = arr[0];

      // Outer loop for starting point of subarray
      for (int i = 0; i < arr.length; i++) {
         int currSum = 0;

         // Inner loop for ending point of subarray
         for (int j = i; j < arr.length; j++) {
            currSum = currSum + arr[j];

            // Update res if currSum is greater than res
            res = Math.max(res, currSum);
         }
      }
      return res;
   }

   public static void main(String[] args) {
      int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
      System.out.println(maxSubarraySum(arr));
   }
}

/* Example :
Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.

Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray [-2] has the largest sum -2.

Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
 */