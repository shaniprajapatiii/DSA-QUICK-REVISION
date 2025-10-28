/* Given an array of integers arr[] representing a permutation (i.e., all elements are unique and arranged in some order), find the next lexicographically greater permutation by rearranging the elements of the array.
If such a permutation does not exist (i.e., the array is the last possible permutation), rearrange the elements to form the lowest possible order (i.e., sorted in ascending order). 
*/

/*
Approach 1:
[Naive Approach] Generate All Permutations - O(n! * n) Time and O(n! * n) Space
The idea is that we would first generate all possible permutations of a given array and sort them. Once sorted, we locate the current permutation within this list. The next permutation is simply the next arrangement in the sorted order. If the current arrangement is the last in the list then display the first permutation (smallest permutation).
*/

import java.util.*;

public class A5_NextPermutation1 {

   // Function to generate all possible permutations
   public static void generatePermutations(List<List<Integer>> res,
         int[] arr, int idx) {

      // Base case: if idx reaches the end of array
      if (idx == arr.length - 1) {
         List<Integer> temp = new ArrayList<>();
         for (int x : arr)
            temp.add(x);
         res.add(temp);
         return;
      }

      // Generate all permutations by swapping
      for (int i = idx; i < arr.length; i++) {
         swap(arr, idx, i);

         // Recur for the next index
         generatePermutations(res, arr, idx + 1);

         // Backtrack to restore original array
         swap(arr, idx, i);
      }
   }

   public static void swap(int[] arr, int i, int j) {
      int t = arr[i];
      arr[i] = arr[j];
      arr[j] = t;
   }

   // Function to find the next permutation
   public static void nextPermutation(int[] arr) {

      List<List<Integer>> res = new ArrayList<>();
      // Generate all permutations
      generatePermutations(res, arr, 0);

      // Sort all permutations lexicographically
      Collections.sort(res, (a, b) -> {
         for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
               return a.get(i) - b.get(i);
            }
         }
         return 0;
      });

      // Find the current permutation index
      for (int i = 0; i < res.size(); i++) {

         // If current permutation matches input
         boolean match = true;
         for (int j = 0; j < arr.length; j++) {
            if (arr[j] != res.get(i).get(j)) {
               match = false;
               break;
            }
         }

         if (match) {
            // If it's not the last permutation
            if (i < res.size() - 1) {
               for (int j = 0; j < arr.length; j++) {
                  arr[j] = res.get(i + 1).get(j);
               }
            }
            // If it's the last permutation
            else {
               for (int j = 0; j < arr.length; j++) {
                  arr[j] = res.get(0).get(j);
               }
            }

            break;
         }
      }
   }

   public static void main(String[] args) {

      int[] arr = { 2, 4, 1, 7, 5, 0 };

      nextPermutation(arr);

      for (int x : arr) {
         System.out.print(x + " ");
      }
   }
}

/*
 * Explanation ==>
 * Input: arr[] = [2, 4, 1, 7, 5, 0]
 * Output: [2, 4, 5, 0, 1, 7]
 * Explanation: The next lexicographically greater arrangement of the elements
 * in the array arr[] is [2, 4, 5, 0, 1, 7].
 * 
 * Input: arr[] = [3, 2, 1]
 * Output: [1, 2, 3]
 * Explanation: This is the last permutation, so we return the lowest possible
 * permutation (ascending order).
 * 
 * Input: arr[] = [1, 3, 5, 4, 2]
 * Output: [1, 4, 2, 3, 5]
 * Explanation: The next lexicographically greater arrangement of the elements
 * in the array arr[] is [1, 4, 2, 3, 5].
 */