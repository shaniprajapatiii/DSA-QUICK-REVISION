// Given a string s consisting of only lowercase English letters, find the minimum number of characters that need to be added to the front of s to make it a palindrome.
// Note: A palindrome is a string that reads the same forward and backward.

public class D19_PalindromeByFrontInsertion1 {

   // function to check if the substring
   // s[i...j] is a palindrome
   public static boolean isPalindrome(String s, int i, int j) {
      while (i < j) {
         // if characters at the ends are not the same,
         // it's not a palindrome
         if (s.charAt(i) != s.charAt(j)) {
            return false;
         }
         i++;
         j--;
      }
      return true;
   }

   public static int minChar(String s) {
      int cnt = 0;
      int i = s.length() - 1;
      // iterate from the end of the string, checking for the
      // longest palindrome starting from the beginning
      while (i >= 0 && !isPalindrome(s, 0, i)) {
         i--;
         cnt++;
      }
      return cnt;
   }

   public static void main(String[] args) {
      String s = "aacecaaaa";
      System.out.println(minChar(s));
   }
}

/*
 * [Naive Approach] Checking all prefixes - O(n^2) Time and O(1) Space
 * The idea is based on the observation that we need to find the longest prefix
 * from given string which is also a palindrome. Then minimum front characters
 * to be added to make given string palindrome will be the remaining characters.
 */