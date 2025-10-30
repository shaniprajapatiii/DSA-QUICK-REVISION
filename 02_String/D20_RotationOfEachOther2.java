/*
 [Expected Approach] Using KMP Algorithm - O(n) Time and O(n) Space
The idea is that when a string is concatenated with itself, all possible rotations of the string will naturally appear as substrings within this concatenated string. To determine if another string is a rotation of the first, we can use KMP Algorithm to check if the second string exists as a substring in the concatenated form of the first string. 
 */

public class D20_RotationOfEachOther2 {

    public static int[] computeLPSArray(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        // length of the previous longest prefix suffix
        int len = 0;
        // lps[0] is always 0
        lps[0] = 0;
        // loop calculates lps[i] for i = 1 to n-1
        int i = 1;
        while (i < n) {
            // if the characters match, increment len
            // and extend the matching prefix
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            // if there is a mismatch
            else {
                // if len is not zero, update len to
                // last known prefix length
                if (len != 0) {
                    len = lps[len - 1];
                }
                // no prefix matches, set lps[i] = 0
                // and move to the next character
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // function to check if s1 and s2 are rotations of each other
    public static boolean areRotations(String s1, String s2) {
        String txt = s1 + s1;
        String pat = s2;

        // search the pattern string s2 in the concatenation string
        int n = txt.length();
        int m = pat.length();
        // create lps[] that will hold the longest prefix suffix
        // values for pattern
        int[] lps = computeLPSArray(pat);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                return true;
            }
            // mismatch after j matches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {

                // do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aba";
        System.out.println(areRotations(s1, s2) ? "true" : "false");
    }
}

/*
 * Input: s1 = "abcd", s2 = "cdab"
 * Output: true
 * Explanation: After 2 right rotations, s1 will become equal to s2.
 * 
 * Input: s1 = "aab", s2 = "aba"
 * Output: true
 * Explanation: After 1 left rotation, s1 will become equal to s2.
 * 
 * Input: s1 = "abcd", s2 = "acbd"
 * Output: false
 * Explanation: Strings are not rotations of each other.
 */