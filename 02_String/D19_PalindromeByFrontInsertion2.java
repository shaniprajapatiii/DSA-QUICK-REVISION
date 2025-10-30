// Given a string s consisting of only lowercase English letters, find the minimum number of characters that need to be added to the front of s to make it a palindrome.
// Note: A palindrome is a string that reads the same forward and backward.

public class D19_PalindromeByFrontInsertion2 {

   public static int[] computeLPSArray(String pat) {
      int n = pat.length();
      int[] lps = new int[n];
      // lps[0] is always 0
      lps[0] = 0;
      int len = 0;
      // loop calculates lps[i] for i = 1 to n-1
      int i = 1;
      while (i < n) {
         // if the characters match, increment len
         // and set lps[i]
         if (pat.charAt(i) == pat.charAt(len)) {
            len++;
            lps[i] = len;
            i++;
         }
         // if there is a mismatch
         else {
            // if len is not zero, update len to
            // the last known prefix length
            if (len != 0) {
               len = lps[len - 1];
            }
            // no prefix matches, set lps[i] to 0
            else {
               lps[i] = 0;
               i++;
            }
         }
      }
      return lps;
   }

   // returns minimum character to be added at
   // front to make string palindrome
   public static int minChar(String s) {
      int n = s.length();
      String rev = new StringBuilder(s).reverse().toString();

      // get concatenation of string, special character
      // and reverse string
      s = s + "$" + rev;

      // get LPS array of this concatenated string
      int[] lps = computeLPSArray(s);

      // by subtracting last entry of lps array from
      // string length, we will get our result
      return (n - lps[lps.length - 1]);
   }

   public static void main(String[] args) {
      String s = "aacecaaaa";
      System.out.println(minChar(s));
   }
}

/*
 * [Expected Approach 1] Using lps array of KMP Algorithm - O(n) Time and O(n)
 * Space
 * The key observation is that the longest palindromic prefix of a string
 * becomes the longest palindromic suffix of its reverse.
 * Given a string s = "aacecaaaa", its reverse revS = "aaaacecaa". The longest
 * palindromic prefix of s is "aacecaa".
 * 
 * To find this efficiently, we use the LPS array from the KMP algorithm. We
 * concatenate the original string with a special character and its reverse: s +
 * '$' + revS.
 * The LPS array for this combined string helps identify the longest prefix of s
 * that matches a suffix of revS, which also represents the palindromic prefix
 * of s.
 */