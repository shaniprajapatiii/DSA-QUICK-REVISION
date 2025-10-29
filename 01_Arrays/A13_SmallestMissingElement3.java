// Given an unsorted array arr[] with both positive and negative elements, find the smallest positive number missing from the array.

public class A13_SmallestMissingElement3 {

    public static int missingNumber(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // if arr[i] is within the range [1, n] and arr[i]
            // is not placed at (arr[i]-1)th index in arr
            while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                // then swap arr[i] and arr[arr[i]-1] to
                // place arr[i] to its corresponding index
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }

        // If any number is not at its corresponding index
        // then it is the missing number
        for (int i = 1; i <= n; i++) {
            if (i != arr[i - 1]) {
                return i;
            }
        }
        // If all number from 1 to n are present then n+1
        // is smallest missing number
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -3, 4, 1, 1, 7 };
        System.out.println(missingNumber(arr));
    }
}

/*
 * [Expected Approach] Using Cycle Sort - O(n) Time and O(1) Space
 * The idea is similar to Cycle Sort and move each element in the array to its
 * correct position based on its value. So for each number, say x, such that 1 ≤
 * x ≤ n, is placed at the (x - 1)th index.
 * 
 * Finally, iterate through the array and check if the numbers are in the
 * expected indexes or not. The first place where the number doesn’t match its
 * index gives us the first missing positive number. If all the numbers from 1
 * to n, are at their correct indexes, then the next number i.e., n + 1, is the
 * smallest missing positive number.
 */