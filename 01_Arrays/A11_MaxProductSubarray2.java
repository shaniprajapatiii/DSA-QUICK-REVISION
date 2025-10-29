// Given an array arr[] consisting of positive, negative, and zero values, find the maximum product that can be obtained from any contiguous subarray of arr[].

public class A11_MaxProductSubarray2 {

    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int maxProduct(int[] arr) {
        int n = arr.length;

        // max product ending at the current index
        int currMax = arr[0];

        // min product ending at the current index
        int currMin = arr[0];

        // Initialize overall max product
        int maxProd = arr[0];

        // Iterate through the array
        for (int i = 1; i < n; i++) {

            // Temporary variable to store the maximum product ending
            // at the current index
            int temp = max(arr[i], arr[i] * currMax, arr[i] * currMin);

            // Update the minimum product ending at the current index
            currMin = min(arr[i], arr[i] * currMax, arr[i] * currMin);

            // Update the maximum product ending at the current index
            currMax = temp;

            // Update the overall maximum product
            maxProd = Math.max(maxProd, currMax);
        }

        return maxProd;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };
        System.out.println(maxProduct(arr));
    }
}

// [Expected Approach - 1] Greedy Min-Max Product - O(n) Time and O(1) Space
// Let's assume that the input array has only positive elements. Then, we can
// simply iterate from left to right keeping track of the maximum running
// product ending at any index. The maximum product would be the product ending
// at the last index. The problem arises when we encounter zero or a negative
// element.

/*
 * If we encounter zero, then all the subarrays containing this zero will have
 * product = 0, so zero simply resets the product of the subarray.
 * 
 * If we encounter a negative number, we need to keep track of the minimum
 * product as well as the maximum product ending at the previous index. This is
 * because when we multiply the minimum product with a negative number, it can
 * give us the maximum product. So, keeping track of minimum product ending at
 * any index is important as it can lead to the maximum product on encountering
 * a negative number.
 */