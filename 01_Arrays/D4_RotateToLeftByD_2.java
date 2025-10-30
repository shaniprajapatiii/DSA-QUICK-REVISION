// Given an array of integers arr[] of size n, the task is to rotate the array elements to the left by d positions.

/* Approach 2:
[Better Approach] Using Temporary Array - O(n) Time and O(n) Space
This problem can be solved using the below idea:

The idea is to use a temporary array of size n, where n is the length of the original array. If we left rotate the array by d positions, the last n - d elements will be at the front and the first d elements will be at the end.

Copy the last (n - d) elements of original array into the first n - d positions of temporary array.
Then copy the first d elements of the original array to the end of temporary array. 
Finally, copy all the elements of temporary array back into the original array.
*/

// Java Program to left rotate the array by d positions
// using temporary array

public class D4_RotateToLeftByD_2 {

    // Function to rotate array
    public static void rotateArr(int[] arr, int d) {
        int n = arr.length;

        // Handle case when d > n
        d %= n;

        // Storing rotated version of array
        int[] temp = new int[n];

        // Copy last n - d elements to the front of temp
        for (int i = 0; i < n - d; i++)
            temp[i] = arr[d + i];

        // Copy the first d elements to the back of temp
        for (int i = 0; i < d; i++)
            temp[n - d + i] = arr[i];

        // Copying the elements of temp in arr
        // to get the final rotated array
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;

        rotateArr(arr, d);

        // Print the rotated array
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
