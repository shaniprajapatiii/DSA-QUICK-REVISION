// Given an array arr[] consisting of n integers, find all the array elements which occurs more than floor(n/3) times.
// Note: The returned array of majority elements should be sorted.

/*  Approach 1:
[Naive Approach] Using Nested Loops - O(n^2) Time and O(1) Space
The idea is to iterate over all elements and count the frequency of the element in the array. If the frequency of the element is greater than floor(n/3), add it to the result. To avoid adding duplicate elements into the result, we can check if the element is already present in the result. We can stop the iteration if we have already found two majority elements.
*/

import java.util.ArrayList;

public class A6_MajorityElement2_1 {

   public static ArrayList<Integer> findMajority(int[] arr) {
      int n = arr.length;
      ArrayList<Integer> res = new ArrayList<>();

      for (int i = 0; i < n; i++) {
         // Count the frequency of arr[i]
         int cnt = 0;
         for (int j = i; j < n; j++) {
            if (arr[j] == arr[i])
               cnt += 1;
         }

         // Check if arr[i] is a majority element
         if (cnt > (n / 3)) {
            // Add arr[i] only if it is not already present
            if (res.size() == 0 || arr[i] != res.get(0)) {
               res.add(arr[i]);
            }
         }

         // If we have found two majority elements,
         // we can stop our search
         if (res.size() == 2) {
            if (res.get(0) > res.get(1))
               java.util.Collections.swap(res, 0, 1);
            break;
         }
      }

      return res;
   }

   public static void main(String[] args) {
      int[] arr = { 2, 2, 3, 1, 3, 2, 1, 1 };
      ArrayList<Integer> res = findMajority(arr);
      for (int ele : res)
         System.out.print(ele + " ");
   }
}
