// Given an unsorted array arr[] with both positive and negative elements, find the smallest positive number missing from the array.

import java.util.Arrays;

public class D13_SmallestMissingElement1 {

    public static int missingNumber(int[] arr) {
        Arrays.sort(arr);

        // res will hold the current smallest missing number,
        // initially set to 1
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            // If we have found 'res' in the array,
            // 'res' is no longer missing, so increment it
            if (arr[i] == res) {
                res++;
            }
            // If the current element is larger than 'res',
            // 'res' cannot be found in the array,
            // so it is our final answer
            else if (arr[i] > res) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -3, 4, 1, 1, 7 };
        System.out.println(missingNumber(arr));
    }
}

/*  [Naive approach] By Sorting - O(n*log n) Time and O(1) Space
The idea is to sort the array and assume the missing number as 1. Now, iterate over the array and for each element arr[i],

If arr[i] == missing number, then increment missing number by 1.
If arr[i] < missing number, then continue to search for the missing number.
If arr[i] > missing number, then break and return the missing number as the answer.
*/

/*
 * Example :
 * Input: arr[] = [2, -3, 4, 1, 1, 7]
 * Output: 3
 * Explanation: 3 is the smallest positive number missing from the array.
 * 
 * Input: arr[] = [5, 3, 2, 5, 1]
 * Output: 4
 * Explanation: 4 is the smallest positive number missing from the array.
 * 
 * Input: arr[] = [-8, 0, -1, -4, -3]
 * Output: 1
 * Explanation: 1 is the smallest positive number missing from the array.
 */