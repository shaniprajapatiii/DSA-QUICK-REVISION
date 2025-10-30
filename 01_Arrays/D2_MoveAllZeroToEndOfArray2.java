// Given an array of integers arr[], move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.

/* Approach 2:
[Better Approach] Two Traversals
The idea is to move all the zeros to the end of the array while maintaining the relative order of non-zero elements using two traversals.

First Traversal: Shift non-zero elements

Traverse the array and maintain the count of non-zero elements. This count is initialized with 0 and keeps track of where the next non-zero element should be placed in the array.
If the element is non-zero, place it at arr[count] and increment count by 1.
After traversing all the elements, all non-zero elements will be shifted to the front while maintaining their original order.

Second Traversal: Fill remaining positions with zeros

After the first traversal, all non-zero elements will be at the start of the array and count will store the index where the first zero should be placed.
Iterate from count to the end of array and fill all indices with 0.
 */

public class D2_MoveAllZeroToEndOfArray2 {

   public static void pushZerosToEnd(int[] arr) {

      // Count of non-zero elements
      int count = 0;

      // If the element is non-zero, replace the element at
      // index 'count' with this element and increment count
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] != 0) {
            arr[count++] = arr[i];
         }
      }

      // Now all non-zero elements have been shifted to
      // the front. Make all elements 0 from count to end.
      while (count < arr.length) {
         arr[count++] = 0;
      }
   }

   public static void main(String[] args) {
      int[] arr = { 1, 2, 0, 4, 3, 0, 5, 0 };
      pushZerosToEnd(arr);
      for (int num : arr) {
         System.out.print(num + " ");
      }
   }
}