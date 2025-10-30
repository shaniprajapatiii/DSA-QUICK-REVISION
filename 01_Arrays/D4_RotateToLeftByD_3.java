// Given an array of integers arr[] of size n, the task is to rotate the array elements to the left by d positions.
/*
Approach 4:
[Expected Approach 2] Using Reversal Algorithm - O(n) Time and O(1) Space
The idea is based on the observation that if we left rotate the array by d positions, the last (n - d) elements will be at the front and the first d elements will be at the end. 

Reverse the subarray containing the first d elements of the array.
Reverse the subarray containing the last (n - d) elements of the array.
Finally, reverse all the elements of the array.
*/

// Java Code to left rotate an array using Reversal Algorithm

public class D4_RotateToLeftByD_3 {

    // Function to rotate an array by d elements to the left
    public static void rotateArr(int[] arr, int d) {
        int n = arr.length;

        // Handle the case where d > size of array
        d %= n;

        // Reverse the first d elements
        reverse(arr, 0, d - 1);

        // Reverse the remaining n-d elements
        reverse(arr, d, n - 1);

        // Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    // Function to reverse a portion of the array
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
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

/*
 * Approach 3:
 * [Expected Approach 1] Using Juggling Algorithm - O(n) Time and O(1) Space
 * The idea is to use Juggling Algorithm which is based on rotating elements in
 * cycles. Each cycle is independent and represents a group of elements that
 * will shift among themselves during the rotation. If the starting index of a
 * cycle is i, then next elements of the cycle can be found at indices (i + d) %
 * n, (i + 2d) % n, (i + 3d) % n ... and so on till we return to the original
 * index i.
 * 
 * So for any index i, we know that after rotation, the element that will occupy
 * this position is arr[(i + d) % n]. Consequently, for every index in the
 * cycle, we will place the element that should be in that position after the
 * rotation is completed.
 * 
 * Please refer Juggling Algorithm for Array Rotation to know more about the
 * implementation.
 */
