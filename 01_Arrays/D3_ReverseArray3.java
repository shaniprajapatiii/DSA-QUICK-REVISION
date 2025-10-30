// Reverse an array arr[]. Reversing an array means rearranging the elements such that the first element becomes the last, the second element becomes second last and so on.

/*Approach 3:
[Expected Approach - 2] By Swapping Elements - O(n) Time and O(1) Space
The idea is to iterate over the first half of the array and swap each element with its corresponding element from the end. So, while iterating over the first half, any element at index i is swapped with the element at index (n - i - 1).
*/

public class D3_ReverseArray3 {

   public static void reverseArray(int[] arr) {
      int n = arr.length;

      // Iterate over the first half
      // and for every index i, swap
      // arr[i] with arr[n - i - 1]
      for (int i = 0; i < n / 2; i++) {
         int temp = arr[i];
         arr[i] = arr[n - i - 1];
         arr[n - i - 1] = temp;
      }
   }

   public static void main(String[] args) {
      int[] arr = { 1, 4, 3, 2, 6, 5 };

      reverseArray(arr);

      for (int i = 0; i < arr.length; i++)
         System.out.print(arr[i] + " ");
   }
}