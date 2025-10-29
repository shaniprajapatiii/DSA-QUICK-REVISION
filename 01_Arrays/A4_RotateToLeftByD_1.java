// Given an array of integers arr[] of size n, the task is to rotate the array elements to the left by d positions.

/* Explanation:
Input: arr[] = {1, 2, 3}, d = 4
Output: {2, 3, 1}
Explanation: The array is rotated as follows:

After first left rotation, arr[] = {2, 3, 1}
After second left rotation, arr[] = {3, 1, 2}
After third left rotation, arr[] = {1, 2, 3}
After fourth left rotation, arr[] = {2, 3, 1}
*/

/* Approach 1:
[Naive Approach] Rotate one by one - O(n * d) Time and O(1) Space
In each iteration, shift the elements by one position to the left in a circular fashion (the first element becomes the last). Perform this operation d times to rotate the elements to the left by d positions.
*/

// Java Program to left rotate the array by d positions
// by rotating one element at a time

public class A4_RotateToLeftByD_1 {

    // Function to left rotate array by d positions
    public static void rotateArr(int[] arr, int d) {
        int n = arr.length;

        // Repeat the rotation d times
        for (int i = 0; i < d; i++) {

            // Left rotate the array by one position
            int first = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = first;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;

        rotateArr(arr, d);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
