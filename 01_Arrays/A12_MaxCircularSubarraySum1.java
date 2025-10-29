// Given a circular array arr[], find the maximum sum of any non-empty subarray. A circular array allows wrapping from the end back to the beginning.
// Note: A subarray may wrap around the end and continue from the beginning, forming a circular segment.

public class A12_MaxCircularSubarraySum1 {

    public static int maxCircularSum(int[] arr) {

        int n = arr.length;
        int res = arr[0];
        // Subarray that starts with index i
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            // Considering all possible endpoints of the
            // Subarray that begins with index i
            for (int j = 0; j < n; j++) {
                // Circular index
                int idx = (i + j) % n;
                currSum = currSum + arr[idx];
                res = Math.max(res, currSum);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 8, -8, 9, -9, 10, -11, 12 };
        System.out.println(maxCircularSum(arr));
    }
}

// [Naive Approach] Considering All Possible Subarrays – O(n^2) Time and O(1) Space
// The idea is to consider every element as the beginning of the subarray, and calculate the maximum possible sum, which includes both circular and linear subarrays starting from that element.