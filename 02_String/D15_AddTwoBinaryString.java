// Given two binary strings s1 and s2, the task is to return their sum.The input strings may contain leading zeros but the output string should not have any leading zeros.

// Java program to add two binary strings
// using Bit-by-Bit addition
public class S2_AddTwoBinaryString {

   // Function to trim leading zeros from a binary string
   public static String trimLeadingZeros(String s) {

      // Find the position of the first '1'
      int firstOne = s.indexOf('1');
      return (firstOne == -1) ? "0"
            : s.substring(firstOne);
   }
   // This function adds two binary strings and return
   // result as a third string
   public static String addBinary(String s1, String s2) {
      // Trim Leading Zeros
      s1 = trimLeadingZeros(s1);
      s2 = trimLeadingZeros(s2);

      int n = s1.length();
      int m = s2.length();

      // Swap the strings if s1 is of smaller length
      if (n < m) {
         return addBinary(s2, s1);
      }
      int j = m - 1;
      int carry = 0;
      StringBuilder result = new StringBuilder();

      // Traverse both strings from the end
      for (int i = n - 1; i >= 0; i--) {
         // Current bit of s1
         int bit1 = s1.charAt(i) - '0';
         int sum = bit1 + carry;
         // If there are remaining bits in s2, add them
         // to the sum
         if (j >= 0) {
            // Current bit of s2
            int bit2 = s2.charAt(j) - '0';
            sum += bit2;
            j--;
         }

         // Calculate the result bit and update carry
         int bit = sum % 2;
         carry = sum / 2;

         // Update the current bit in result
         result.append((char) (bit + '0'));
      }
      // If there's any carry left, update the result
      if (carry > 0)
         result.append('1');

      return result.reverse().toString();
   }

   public static void main(String[] args) {
      String s1 = "1101";
      String s2 = "111";

      System.out.println(addBinary(s1, s2));
   }
}

/*
Bit-by-bit addition with carry - O(n + m) Time and O(1) Space
The idea is to first trim the leading zeros in the input strings. Now, start from the last characters of the strings and compute the digit sum one by one. If the sum becomes more than 1, then store carry for the next digits. Also consider this carry while calculating the digit sum. After calculating the sum, if an additional carry is generated, prepend a '1' of the result.
*/

/*
  Example:
  Input: s1 = "1101", s2 = "111"
  Output: "10100"
   Explanation: 1101 (13 in decimal) + 0111 (7 in decimal) = 10100 (20 in decimal)
   Input: s1 = "00101", s2 = "00011"
   Output: "1000"
   Explanation: 00101 (5 in decimal) + 00011 (3 in decimal) = 01000 (8 in decimal)
 */