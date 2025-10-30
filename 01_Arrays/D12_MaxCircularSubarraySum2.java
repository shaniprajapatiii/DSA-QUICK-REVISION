// Given a circular array arr[], find the maximum sum of any non-empty subarray. A circular array allows wrapping from the end back to the beginning.
// Note: A subarray may wrap around the end and continue from the beginning, forming a circular segment.

public class D12_MaxCircularSubarraySum2 {

    public static int maxCircularSum(int[] arr) {

        int n = arr.length;
        int suffixSum = arr[n - 1];

        // maxSuffix array to store the value of
        // maximum suffix occurred so far.
        int[] maxSuffix = new int[n + 1];
        maxSuffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum = suffixSum + arr[i];
            maxSuffix[i] = Math.max(maxSuffix[i + 1], suffixSum);
        }
        // circularSum is Maximum sum of circular subarray
        int circularSum = arr[0];
        // normalSum is Maximum sum subarray considering
        // the array is non-circular
        int normalSum = arr[0];

        int currSum = 0;
        int prefix = 0;

        for (int i = 0; i < n; i++) {
            // Kadane's algorithm
            currSum = Math.max(currSum + arr[i], arr[i]);
            normalSum = Math.max(normalSum, currSum);

            // Calculating maximum Circular Sum
            prefix = prefix + arr[i];
            circularSum = Math.max(circularSum, prefix + maxSuffix[i + 1]);
        }

        return Math.max(circularSum, normalSum);
    }

    public static void main(String[] args) {
        int[] arr = { 8, -8, 9, -9, 10, -11, 12 };
        System.out.println(maxCircularSum(arr));
    }
}
/* [Better Approach] Using Prefix and Suffix Sum – O(n) Time and O(n) Space
In a circular array, the maximum subarray sum can be either the maximum
normal sum, which is the highest sum of a non-circular array, or the maximum
circular sum, which includes elements from both the start and the end of the
array. The normal sum can be efficiently calculated using Kadane's algorithm.
And, the circular sum is calculated by combining prefix sum and suffix sum.
*/