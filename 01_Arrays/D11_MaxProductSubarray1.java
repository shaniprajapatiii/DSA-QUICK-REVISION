// Given an array arr[] consisting of positive, negative, and zero values, find the maximum product that can be obtained from any contiguous subarray of arr[].

public class D11_MaxProductSubarray1 {

    public static int maxProduct(int arr[]) {

        int n = arr.length;

        // Initializing result
        int maxProd = arr[0];

        for (int i = 0; i < n; i++) {
            int mul = 1;

            // traversing in current subarray
            for (int j = i; j < n; j++) {
                mul *= arr[j];

                // updating result every time
                // to keep track of the maximum product
                maxProd = Math.max(maxProd, mul);
            }
        }
        return maxProd;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 6, -3, -10, 0, 2 };
        System.out.println(maxProduct(arr));
    }
}

// [Naive Approach] Using Two Nested Loops – O(n^2) Time and O(1) Space
// The idea is to traverse over every contiguous subarray, find the product of each of these subarrays and return the maximum product among all the subarrays.