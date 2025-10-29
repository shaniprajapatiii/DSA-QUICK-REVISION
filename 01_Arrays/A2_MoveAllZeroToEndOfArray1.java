// Given an array of integers arr[], move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.

/* Approach 1:
[Naive Approach] Using Temporary Array - O(n) Time and O(n) Space
The idea is to create a temporary array of same size as the input array arr[].

1.First, copy all non-zero elements from arr[] to the temporary array.
2. Then, fill all the remaining positions in temporary array with 0.
3. Finally, copy all the elements from temporary array to arr[]. */

public class A2_MoveAllZeroToEndOfArray1 {

   public static void pushZerosToEnd(int[] arr) {
      int n = arr.length;
      int[] temp = new int[n];

      // to keep track of the index in temp[]
      int j = 0;

      // Copy non-zero elements to temp[]
      for (int i = 0; i < n; i++) {
         if (arr[i] != 0) {
            temp[j++] = arr[i];
         }
      }

      // Fill remaining positions in temp[] with zeros
      while (j < n) {
         temp[j++] = 0;
      }

      // Copy all the elements from temp[] to arr[]
      for (int i = 0; i < n; i++) {
         arr[i] = temp[i];
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
