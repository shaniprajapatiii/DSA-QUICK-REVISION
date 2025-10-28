/*
Approach 2:
[Expected Approach] Generating Only Next - O(n) Time and O(1) Space
Observations of Next permutation: 

To get the next permutation we change the number in a position which is as right as possible.
The first number to be moved is the rightmost number smaller than its next.
The number to come in-place is the rightmost greater number on right side of the pivot.
Each permutation (except the very first) has an increasing suffix. Now if we change the pattern from the pivot point (where the increasing suffix breaks) to its next possible lexicographic representation we will get the next greater permutation. 
*/

public class A5_NextPermutaion2 {

   public static void nextPermutation(int[] arr) {

      int n = arr.length;
      // Find the pivot index
      int pivot = -1;
      for (int i = n - 2; i >= 0; i--) {
         if (arr[i] < arr[i + 1]) {
            pivot = i;
            break;
         }
      }
      // If pivot point does not exist,
      // reverse the whole array
      if (pivot == -1) {
         reverse(arr, 0, n - 1);
         return;
      }

      // Find the element from the right
      // that is greater than pivot
      for (int i = n - 1; i > pivot; i--) {
         if (arr[i] > arr[pivot]) {
            swap(arr, i, pivot);
            break;
         }
      }

      // Reverse the elements from pivot + 1 to the end
      reverse(arr, pivot + 1, n - 1);
   }

   // Helper method to reverse array
   private static void reverse(int[] arr, int start, int end) {
      while (start < end) {
         swap(arr, start++, end--);
      }
   }

   // Helper method to swap two elements
   private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public static void main(String[] args) {
      int[] arr = { 2, 4, 1, 7, 5, 0 };
      nextPermutation(arr);

      for (int i = 0; i < arr.length; i++)
         System.out.print(arr[i] + " ");
   }
}

/*
   Let's try some examples to see if we can recognize some patterns.
   
   [1, 2, 3, 4, 5]: next is [1, 2, 3, 5, 4]
   Observation: 4 moves and 5 comes in place of it
   
   [1, 2, 3, 5, 4]: next is [1, 2, 4, 3, 5]
   Observation: 3 moves, 4 comes in place of it. 3 comes before 5 (mainly 3 and
   5 are in sorted order)
   
   [1, 2, 3, 6, 5, 4]: next is [1, 2, 4, 3, 5, 6]
   Observation: 3 moves, 4 comes in place of it. [3, 5 and 6 are placed in
   sorted order]
   
   [3, 2, 1]: next is [1, 2, 3]
   Observation: All elements are reverse sorted. Result is whole array sorted.
   
   
   Step-By-Step Approach:
   
   Iterate over the given array from end and find the first index (pivot) which
   doesn't follow property of non-increasing suffix, (i.e, arr[i] < arr[i + 1]).
   If pivot index does not exist, then the given sequence in the array is the
   largest as possible. So, reverse the complete array. For example, for [3, 2,
   1], the output would be [1, 2, 3]
   Otherwise, Iterate the array from the end and find for the successor
   (rightmost greater element) of pivot in suffix.
   Swap the pivot and successor
   Minimize the suffix part by reversing the array from pivot + 1 till n.
 */