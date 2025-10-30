import java.util.ArrayList;

public class D18_PatternSearchingKMP_Algo {

   public static void constructLps(String pat, int[] lps) {

      // len stores the length of longest prefix which
      // is also a suffix for the previous index
      int len = 0;
      // lps[0] is always 0
      lps[0] = 0;
      int i = 1;
      while (i < pat.length()) {
         // If characters match, increment the size of lps
         if (pat.charAt(i) == pat.charAt(len)) {
            len++;
            lps[i] = len;
            i++;
         }
         // If there is a mismatch
         else {
            if (len != 0) {
               // Update len to the previous lps value
               // to avoid redundant comparisons
               len = lps[len - 1];
            } else {
               // If no matching prefix found, set lps[i] to 0
               lps[i] = 0;
               i++;
            }
         }
      }
   }

   public static ArrayList<Integer> search(String pat, String txt) {
      int n = txt.length();
      int m = pat.length();

      int[] lps = new int[m];
      ArrayList<Integer> res = new ArrayList<>();

      constructLps(pat, lps);
      // Pointers i and j, for traversing
      // the text and pattern
      int i = 0;
      int j = 0;

      while (i < n) {
         // If characters match, move both pointers forward
         if (txt.charAt(i) == pat.charAt(j)) {
            i++;
            j++;
            // If the entire pattern is matched
            // store the start index in result
            if (j == m) {
               res.add(i - j);
               // Use LPS of previous index to
               // skip unnecessary comparisons
               j = lps[j - 1];
            }
         }

         // If there is a mismatch
         else {
            // Use lps value of previous index
            // to avoid redundant comparisons
            if (j != 0)
               j = lps[j - 1];
            else
               i++;
         }
      }
      return res;
   }

   public static void main(String[] args) {
      String txt = "aabaacaadaabaaba";
      String pat = "aaba";

      ArrayList<Integer> res = search(pat, txt);
      for (int i = 0; i < res.size(); i++)
         System.out.print(res.get(i) + " ");
   }
}

/*
 * KMP Pattern Matching Algorithm
 * Terminologies used in KMP Algorithm:
 * 
 * text (txt): The main string in which we want to search for a pattern.
 * pattern (pat): The substring we are trying to find within the text.
 * Match: A match occurs when all characters of the pattern align exactly with a
 * substring of the text.
 * LPS Array (Longest Prefix Suffix): For each position i in the pattern, lps[i]
 * stores the length of the longest proper prefix which is also a suffix in the
 * substring pat[0...i].
 * Proper Prefix: A proper prefix is a prefix that is not equal to the whole
 * string.
 * Suffix: A suffix is a substring that ends at the current position.
 * The LPS array helps us determine how much we can skip in the pattern when a
 * mismatch occurs, thus avoiding redundant comparisons.
 * Problem Statement:
 * 
 * Given two strings: txt, representing the main text, and pat, representing the
 * pattern to be searched.
 * Find and return all starting indices in txt where the string pat appears as a
 * substring.
 * The matching should be exact, and the indices should be 0-based, meaning the
 * first character of txt is considered to be at index 0.
 */

/*
 * The KMP algorithm works in two main steps:
 * 
 * 1. Preprocessing Step – Build the LPS Array
 * 
 * First, we process the pattern to create an array called LPS (Longest Prefix
 * Suffix).
 * This array tells us:
 * "If a mismatch happens at this point, how far back in the pattern can we jump without missing any potential matches?"
 * It helps us avoid starting from the beginning of the pattern again after a
 * mismatch.
 * This step is done only once, before we start searching in the text.
 * 2. Matching Step – Search the Pattern in the Text
 * 
 * Now, we start comparing the pattern with the text, one character at a time.
 * If the characters match: Move forward in both the text and the pattern.
 * If the characters don’t match:
 * => If we're not at the start of the pattern, we use the LPS value at the
 * previous index (i.e., lps[j - 1]) to move the pattern pointer j back to that
 * position. This means: jump to the longest prefix that is also a suffix — no
 * need to recheck those characters.
 * => If we're at the start (i.e., j == 0), simply move the text pointer i
 * forward to try the next character.
 * If we reach the end of the pattern (i.e., all characters matched), we found a
 * match! Record the starting index and continue searching.
 */