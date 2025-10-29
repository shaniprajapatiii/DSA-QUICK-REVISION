// Given a circular array arr[], find the maximum sum of any non-empty subarray. A circular array allows wrapping from the end back to the beginning.
// Note: A subarray may wrap around the end and continue from the beginning, forming a circular segment.

public class A12_MaxCircularSubarraySum3 {

    public static int maxCircularSum(int[] arr) {

        int totalSum = 0;
        int currMaxSum = 0, currMinSum = 0;
        int maxSum = arr[0], minSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            // Kadane's to find maximum sum subarray
            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            // Kadane's to find minimum sum subarray
            currMinSum = Math.min(currMinSum + arr[i], arr[i]);
            minSum = Math.min(minSum, currMinSum);

            // Sum of all the elements of input array
            totalSum += arr[i];
        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;
        // If the minimum subarray is equal to total Sum
        // then we just need to return normalSum
        if (minSum == totalSum)
            return normalSum;

        return Math.max(normalSum, circularSum);
    }

    public static void main(String[] args) {
        int[] arr = { 8, -8, 9, -9, 10, -11, 12 };
        System.out.println(maxCircularSum(arr));
    }
}
/*
 * [Expected Approach] Using Kadane's Algorithm – O(n) Time and O(1) Space
 * This approach is similar to the previous one, but the key difference is that
 * we're using Kadane's algorithm to find the circular subarray sum as well. The
 * maximum sum of a circular subarray can be defined as the total sum of the
 * array minus the sum of a subarray in the middle. So, to maximize the circular
 * subarray sum, we need to minimize the subarray sum.
 */