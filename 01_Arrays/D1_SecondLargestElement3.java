// Given an array of positive integers arr[] of size n, the task is to find second largest distinct element in the array.
// Note: If the second largest element does not exist, return -1.

// Java program to find the second largest element in the array
// using one traversal

public class D1_SecondLargestElement3 {
    
    // function to find the second largest element in the array
    public static int getSecondLargest(int[] arr) {
        int n = arr.length;

        int largest = -1, secondLargest = -1;

        // finding the second largest element
        for (int i = 0; i < n; i++) {

            // If arr[i] > largest, update second largest with
            // largest and largest with arr[i]
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
          
            // If arr[i] < largest and arr[i] > second largest, 
            // update second largest with arr[i]
            else if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(getSecondLargest(arr));
    }
}