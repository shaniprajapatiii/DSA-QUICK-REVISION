// Given an array of positive integers arr[] of size n, the task is to find second largest distinct element in the array.
// Note: If the second largest element does not exist, return -1.

// Java program to find second largest element in an array
// using Sorting

import java.util.Arrays;

public class First_SecondLargestElement1 {
    
    // function to find the second largest element
    public static int getSecondLargest(int[] arr) {
        int n = arr.length;
        
        // Sort the array in non-decreasing order
        Arrays.sort(arr);
        
        // start from second last element as last element is the largest
        for (int i = n - 2; i >= 0; i--) {
            
            // return the first element which is not equal to the 
            // largest element
            if (arr[i] != arr[n - 1]) {
                return arr[i];
            }
        }
        
        // If no second largest element was found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 35, 1, 10, 34, 1 };
        System.out.println(getSecondLargest(arr));
    }
}