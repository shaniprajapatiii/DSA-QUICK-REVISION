// Given an array arr[] consisting of n integers, find all the array elements which occurs more than floor(n/3) times.
// Note: The returned array of majority elements should be sorted.

/*  Approach 2:
[Better Approach] Using Hash Map or Dictionary - O(n) Time and O(n) Space
The idea is to use a hash map or dictionary to count the frequency of each element in the array. After counting, iterate over the hash map and if the frequency of any element is greater than (n/3), push it into the result. Finally, the majority elements are returned after sorting.
*/

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class A6_MajorityElement2_2 {

   public static ArrayList<Integer> findMajority(int[] arr) {
      int n = arr.length;
      HashMap<Integer, Integer> freq = new HashMap<>();
      ArrayList<Integer> res = new ArrayList<>();

      // find frequency of each number
      for (int ele : arr)
         freq.put(ele, freq.getOrDefault(ele, 0) + 1);

      // Iterate over each key-value
      // pair in the hash map
      for (Map.Entry<Integer, Integer> it : freq.entrySet()) {
         int ele = it.getKey();
         int cnt = it.getValue();

         // Add the element to the result if its
         // frequency is greater than n / 3
         if (cnt > n / 3)
            res.add(ele);
      }

      // Sort result if there are two elements
      // and they are out of order
      if (res.size() == 2 && res.get(0) > res.get(1)) {
         int temp = res.get(0);
         res.set(0, res.get(1));
         res.set(1, temp);
      }

      return res;
   }

   public static void main(String[] args) {
      int[] arr = { 2, 2, 3, 1, 3, 2, 1, 1 };
      ArrayList<Integer> res = findMajority(arr);
      for (int ele : res) {
         System.out.print(ele + " ");
      }
   }
}
