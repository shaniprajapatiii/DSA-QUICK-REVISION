// Given an array of integers arr[], move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.

/* Approach 3:
[Expected Approach] One Traversal
The idea is similar to the previous approach where we took a pointer, say count to track where the next non-zero element should be placed. However, on encountering a non-zero element, instead of directly placing the non-zero element at arr[count], we will swap the non-zero element with arr[count]. This will ensure that if there is any zero present at arr[count], it is pushed towards the end of array and is not overwritten.
*/

public class A2_MoveAllZeroToEndOfArray3 {

   public static void pushZerosToEnd(int[] arr) {

      // Pointer to track the position
      // for next non-zero element
      int count = 0;

      for (int i = 0; i < arr.length; i++) {

         // If the current element is non-zero
         if (arr[i] != 0) {

            // Swap the current element with
            // the 0 at index 'count'
            int temp = arr[i];
            arr[i] = arr[count];
            arr[count] = temp;

            // Move 'count' pointer to
            // the next position
            count++;
         }
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