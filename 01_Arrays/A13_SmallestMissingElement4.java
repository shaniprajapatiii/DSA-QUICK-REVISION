// Given an unsorted array arr[] with both positive and negative elements, find the smallest positive number missing from the array.

public class A13_SmallestMissingElement4 {

    public static int partition(int[] arr) {
        int pivotIdx = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Move positive elements to the left
            if (arr[i] > 0) {
                int temp = arr[i];
                arr[i] = arr[pivotIdx];
                arr[pivotIdx] = temp;
                pivotIdx++;
            }
        }
        // return index of the first non-positive number
        return pivotIdx;
    }

    public static int missingNumber(int[] arr) {
        int k = partition(arr);

        // Traverse the positive part of the array
        for (int i = 0; i < k; i++) {
            // Find the absolute value to get the original number
            int val = Math.abs(arr[i]);
            // If val is within range, then mark the element at
            // index val-1 to negative
            if (val - 1 < k && arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            }
        }
        // Find first unmarked index
        for (int i = 0; i < k; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        // If all numbers from 1 to k are marked
        // then missing number is k + 1
        return k + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -3, 4, 1, 1, 7 };
        System.out.println(missingNumber(arr));
    }
}

/*
 * [Alternate Approach - 1] By Negating Array Elements – O(n) Time and O(1)
 * Space
 * The main idea of this approach is to first move all positive integers to the
 * left side of the array. Then, for the left segment, it marks the presence of
 * a number val (where 1 ≤ val ≤ k) by making the element at index (val - 1)
 * negative. This marking helps identify which numbers are present. Finally, it
 * scans the marked segment to find the first index that remains positive,
 * indicating the smallest missing positive number. If all positions are marked,
 * the missing number is k + 1.
 */