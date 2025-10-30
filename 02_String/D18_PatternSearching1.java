import java.util.*;

public class D18_PatternSearching1 {

   public static ArrayList<Integer> computeLPSArray(String pattern) {
      int n = pattern.length();
      ArrayList<Integer> lps = new ArrayList<>();
      for (int k = 0; k < n; k++)
         lps.add(0);

      // length of the previous longest prefix suffix
      int len = 0;
      int i = 1;

      while (i < n) {
         if (pattern.charAt(i) == pattern.charAt(len)) {
            len++;
            lps.set(i, len);
            i++;
         } else {
            if (len != 0) {
               // fall back in the pattern
               len = lps.get(len - 1);
            } else {
               lps.set(i, 0);
               i++;
            }
         }
      }

      return lps;
   }

   public static void main(String[] args) {
      String pattern = "aabaaac";
      ArrayList<Integer> lps = computeLPSArray(pattern);

      System.out.println("LPS Array: " + lps);
   }
}

/*
 Naive Approach and How KMP Overcomes It
In the naive string matching algorithm, we align the pattern at every position in the text and compare characters one by one. If a mismatch occurs, we shift the pattern by one position and start over. This can lead to rechecking the same characters multiple times, especially in cases with repeated characters. For example, searching "aaaab" in "aaaaaaaab" causes many unnecessary comparisons which lead to a time complexity of O(n × m).

The KMP algorithm avoids this inefficiency by preprocessing the pattern using an auxiliary array called LPS (Longest Prefix Suffix). This array stores the length of the longest proper prefix which is also a suffix for every prefix of the pattern. When a mismatch occurs, KMP uses this information to shift the pattern intelligently, skipping over positions that are guaranteed not to match — instead of starting over. This ensures that each character in the text is compared at most once, reducing the time complexity to O(n + m).

Proper Prefix : A proper prefix of a string is a prefix that is not equal to the string itself.
For example, proper prefixes of "abcd" are: "", "a", "ab", and "abc".

LPS (Longest Prefix Suffix) Array
The LPS array stores, for every position in the pattern, the length of the longest proper prefix which is also a suffix of the substring ending at that position.
It helps the KMP algorithm determine how much to shift the pattern when a mismatch occurs, without rechecking matched characters.

Example of lps[] construction:

Example 1: Pattern "aabaaac"

At index 0: "a" → No proper prefix/suffix → lps[0] = 0
At index 1: "aa" → "a" is both prefix and suffix → lps[1] = 1
At index 2: "aab" → No prefix matches suffix → lps[2] = 0
At index 3: "aaba" → "a" is prefix and suffix → lps[3] = 1
At index 4: "aabaa" → "aa" is prefix and suffix → lps[4] = 2
At index 5: "aabaaa" → "aa" is prefix and suffix → lps[5] = 2
At index 6: "aabaaac" → Mismatch, so reset → lps[6] = 0
Final lps[]: [0, 1, 0, 1, 2, 2, 0]

Example 2: Pattern "abcdabca"

At index 0: lps[0] = 0
At index 1: lps[1] = 0
At index 2:lps[2] = 0
At index 3: lps[3] = 0 (no repetition in "abcd")
At index 4: lps[4] = 1 ("a" repeats)
At index 5: lps[5] = 2 ("ab" repeats)
At index 6: lps[6] = 3 ("abc" repeats)
At index 7: lps[7] = 1 (mismatch, fall back to "a")
Final LPS: [0, 0, 0, 0, 1, 2, 3, 1]

Note: lps[i] could also be defined as the longest prefix which is also a proper suffix. We need to use it properly in one place to make sure that the whole substring is not considered.

Algorithm for Construction of LPS Array
The value of lps[0] is always 0 because a string of length one has no non-empty proper prefix that is also a suffix. We maintain a variable len, initialized to 0, which keeps track of the length of the previous longest prefix suffix. As we traverse the pattern from index 1 onward, we compare the current character pat[i] with pat[len]. Based on this comparison, we have three possible cases:

Case 1: pat[i] == pat[len]

This means the current character continues the existing prefix-suffix match.
→ We increment len by 1 and assign lps[i] = len.
→ Then, move to the next index.

Case 2: pat[i] != pat[len] and len == 0

There is no prefix that matches any suffix ending at i, and we can't fall back to any earlier matching pattern.
→ So we set lps[i] = 0 and simply move to the next character.

Case 3: pat[i] != pat[len] and len > 0

We cannot extend the previous matching prefix-suffix. However, there might still be a shorter prefix which is also a suffix that matches the current position.
Instead of comparing all prefixes manually, we reuse previously computed LPS values.
→ Since pat[0...len-1] equals pat[i-len...i-1], we can fall back to lps[len - 1] and update len.
→ This reduces the prefix size we're matching against and avoids redundant work.
We do not increment i immediately in this case — instead, we retry the current pat[i] with the new updated len.
 */