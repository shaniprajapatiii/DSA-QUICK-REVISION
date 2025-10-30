// Given a string s consisting of only lowercase English letters, find the minimum number of characters that need to be added to the front of s to make it a palindrome.
// Note: A palindrome is a string that reads the same forward and backward.

public class D19_PalindromeByFrontInsertion3 {

    // manacher's algorithm for finding longest
    // palindromic substrings
    public static class manacher {
        // array to store palindrome lengths centered
        // at each position
        int[] p;
        // modified string with separators and sentinels
        String ms;

        manacher(String s) {
            StringBuilder sb = new StringBuilder("@");
            for (char c : s.toCharArray()) {
                sb.append("#").append(c);
            }
            sb.append("#$");
            ms = sb.toString();
            runManacher();
        }

        // core Manacher's algorithm
        void runManacher() {
            int n = ms.length();
            p = new int[n];
            int l = 0, r = 0;

            for (int i = 1; i < n - 1; ++i) {
                if (i < r)
                    p[i] = Math.min(r - i, p[r + l - i]);

                // expand around the current center
                while (ms.charAt(i + 1 + p[i]) == ms.charAt(i - 1 - p[i]))
                    p[i]++;

                // update center if palindrome goes beyond
                // current right boundary
                if (i + p[i] > r) {
                    l = i - p[i];
                    r = i + p[i];
                }
            }
        }

        // returns the length of the longest palindrome
        // centered at given position
        int getLongest(int cen, int odd) {
            int pos = 2 * cen + 2 + (odd == 0 ? 1 : 0);
            return p[pos];
        }

        // checks whether substring s[l...r] is a palindrome
        boolean check(int l, int r) {
            int len = r - l + 1;
            int longest = getLongest((l + r) / 2, len % 2);
            return len <= longest;
        }
    }

    // returns the minimum number of characters to add at the
    // front to make the given string a palindrome
    public static int minChar(String s) {
        int n = s.length();
        manacher m = new manacher(s);

        // scan from the end to find the longest
        // palindromic prefix
        for (int i = n - 1; i >= 0; --i) {
            if (m.check(0, i))
                return n - (i + 1);
        }

        return n - 1;
    }

    public static void main(String[] args) {
        String s = "aacecaaaa";
        System.out.println(minChar(s));
    }
}

/*
 * [Expected Approach 2] Using Manacher's Algorithm
 * The idea is to use Manacher’s algorithm to efficiently find all palindromic
 * substrings in linear time.
 * We transform the string by inserting special characters (#) to handle both
 * even and odd length palindromes uniformly.
 * After preprocessing, we scan from the end of the original string and use the
 * palindrome radius array to check if the prefix s[0...i] is a palindrome. The
 * first such index i gives us the longest palindromic prefix, and we return n -
 * (i + 1) as the minimum characters to add.
 */