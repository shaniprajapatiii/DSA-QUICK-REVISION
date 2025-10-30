// Given a string s, convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.

public class S1_StringToInteger {
   public static int myAtoi(String s) {
      int sign = 1, res = 0, idx = 0;
      // Ignore leading whitespaces
      while (idx < s.length() && s.charAt(idx) == ' ') {
         idx++;
      }
      // Store the sign of number
      if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
         if (s.charAt(idx++) == '-') {
            sign = -1;
         }
      }
      // Construct the number digit by digit
      while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {

         // Handling overflow/underflow test case
         if (res > Integer.MAX_VALUE / 10 ||
               (res == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
         }

         // Append current digit to the result
         res = 10 * res + (s.charAt(idx++) - '0');
      }
      return res * sign;
   }

   public static void main(String[] args) {
      String s = "  -0012g4";
      System.out.println(myAtoi(s));
   }
}

/*
 * Approach:
 * The basic idea is to follow the atoi() algorithm in order and covering all
 * the edge cases:
 * 
 * Skip the leading whitespaces by iterating from the first character.
 * Now, check for at most one sign character ('+' or '-') and maintain a sign
 * variable to keep track of the sign of the number.
 * Finally, read all the digits and construct the number until the first
 * non-digit character is encountered or end of the input string is reached.
 * While constructing the number, if the number becomes greater than 231 - 1,
 * print 231 - 1. Similarly, if the number becomes less than -231, print -231.
 */

// Skip any leading whitespaces.
// Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
// Read the integer by ignoring leading zeros until a non-digit character is
// encountered or end of the string is reached. If no digits are present, return
// 0.
// If the integer is greater than 231 – 1, then return 231 – 1 and if the
// integer is smaller than -231, then return -231.