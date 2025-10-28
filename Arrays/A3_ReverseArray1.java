// Reverse an array arr[]. Reversing an array means rearranging the elements such that the first element becomes the last, the second element becomes second last and so on.

/*Approach 1:
[Naive Approach] Using a temporary array - O(n) Time and O(n) Space
The idea is to use a temporary array to store the reverse of the array.

Create a temporary array of same size as the original array. 
Now, copy all elements from original array to the temporary array in reverse order.
Finally, copy all the elements from temporary array back to the original array.
*/

public class A3_ReverseArray1 {

   public static void reverseArray(int[] arr) {
      int n = arr.length;

      // Temporary array to store elements
      // in reversed order
      int[] temp = new int[n];

      // Copy elements from original array
      // to temp in reverse order
      for (int i = 0; i < n; i++)
         temp[i] = arr[n - i - 1];

      // Copy elements back to original array
      for (int i = 0; i < n; i++)
         arr[i] = temp[i];
   }

   public static void main(String[] args) {
      int[] arr = { 1, 4, 3, 2, 6, 5 };

      reverseArray(arr);

      for (int i = 0; i < arr.length; i++)
         System.out.print(arr[i] + " ");
   }
}
