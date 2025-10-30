// Reverse an array arr[]. Reversing an array means rearranging the elements such that the first element becomes the last, the second element becomes second last and so on.

/*Approach 2:
[Expected Approach - 1] Using Two Pointers - O(n) Time and O(1) Space
The idea is to maintain two pointers: left and right, such that left points at the beginning of the array and right points to the end of the array. 

While left pointer is less than the right pointer, swap the elements at these two positions. After each swap, increment the left pointer and decrement the right pointer to move towards the center of array. This will swap all the elements in the first half with their corresponding element in the second half.
*/

public class D3_ReverseArray2 {

   // function to reverse an array
   public static void reverseArray(int[] arr) {

      // Initialize left to the beginning
      // and right to the end
      int left = 0, right = arr.length - 1;

      // Iterate till left is less than right
      while (left < right) {

         // Swap the elements at left
         // and right position
         int temp = arr[left];
         arr[left] = arr[right];
         arr[right] = temp;

         // Increment the left pointer
         left++;

         // Decrement the right pointer
         right--;
      }
   }

   public static void main(String[] args) {
      int[] arr = { 1, 4, 3, 2, 6, 5 };

      reverseArray(arr);

      for (int i = 0; i < arr.length; i++)
         System.out.print(arr[i] + " ");
   }
}