// Reverse an array arr[]. Reversing an array means rearranging the elements such that the first element becomes the last, the second element becomes second last and so on.

/*Approach 4:
Using Inbuilt Methods - O(n) Time and O(1) Space
The idea is to use inbuilt reverse methods available across different languages. 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A3_ReverseArray4 {

   // function to reverse an array
   public static void reverseArray(List<Integer> arr) {
      Collections.reverse(arr);
   }

   public static void main(String[] args) {
      List<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 6, 5));

      reverseArray(arr);

      for (int i = 0; i < arr.size(); i++)
         System.out.print(arr.get(i) + " ");
   }
}