/* Given an array arr[] representing the heights of towers and a positive integer k, we can modify each tower’s height exactly once by either adding k or subtracting k. After these modifications, find the minimum possible difference between the tallest and the shortest tower.
   Note: It is compulsory to increase or decrease the height by k for each tower. After the operation, the resultant array should not contain any negative integers.
*/
/*
[Approach] Using Sorting - O(n logn) Time and O(1) Space
We bring the towers closer by increasing the shorter ones and decreasing the taller ones. After sorting, we try splitting the array at some point: towers on the left are increased by +k, and towers on the right are decreased by -k.
*/

import java.util.Arrays;

public class A9_MinAndMaxDifference {

   public static int getMinDiff(int[] arr, int k) {
      int n = arr.length;
      Arrays.sort(arr);
      int res = arr[n - 1] - arr[0];

      // For all indices i, increment arr[0...i-1] by k and
      // decrement arr[i...n-1] by k
      for (int i = 1; i < arr.length; i++) {

         // Impossible to decrement height of ith tower by k, continue

         if (arr[i] - k < 0) {
            continue;
         }

         int minH = Math.min(arr[0] + k, arr[i] - k);
         int maxH = Math.max(arr[i - 1] + k, arr[n - 1] - k);
         res = Math.min(res, maxH - minH);
      }
      return res;
   }

   public static void main(String[] args) {
      int k = 2;
      int[] arr = { 1, 5, 8, 10 };

      int ans = getMinDiff(arr, k);
      System.out.println(ans);
   }
}

/*
 * Example :
 * Input: k = 2, arr[] = [1, 5, 8, 10]
 * Output: 5
 * Explanation: The array can be modified as [1+k, 5-k, 8-k, 10-k]= [3, 3, 6,
 * 8]. The difference between the largest and the smallest is 8 - 3 = 5.
 * 
 * Input: k = 3, arr[] = [3, 9, 12, 16, 20]
 * Output: 11
 * Explanation: The array can be modified as [3+k, 9+k, 12-k, 16-k, 20-k] = [6,
 * 12, 9, 13, 17]. The difference between the largest and the smallest is 17 - 6
 * = 11.
 */