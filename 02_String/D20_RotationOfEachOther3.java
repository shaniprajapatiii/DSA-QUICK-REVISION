/*
  [Alternate Approach] Using Rabin Karp Rolling Hash - O(n) Time and O(n) Space
The idea is that when a string is concatenated with itself, all possible rotations of the string will naturally appear as substrings within this concatenated string. To do this efficiently, we use Rolling Hash (with double hashing) to compute hashes of all substrings of length n in s1 + s1, and compare them with the hash of s2.
 */

public class D20_RotationOfEachOther3 {

    public static class RollingHash {
        final int mod = 1000000007;
        final int base1 = 31;
        final int base2 = 37;

        int length;
        String input;

        // preHash[i] = hash of input[0..i-1]
        int[][] preHash;

        // power[i] = base^i for both hash bases
        int[][] power;

        RollingHash(String str) {
            input = str;
            length = str.length();
            preHash = new int[length + 1][2];
            power = new int[length + 1][2];
            power[0][0] = power[0][1] = 1;
            buildHashes();
        }

        int add(int a, int b) {
            return (a + b) % mod;
        }

        int subtract(int a, int b) {
            return (a - b + mod) % mod;
        }

        int multiply(int a, int b) {
            return (int) ((1L * a * b) % mod);
        }

        void buildHashes() {
            for (int i = 0; i < length; i++) {
                preHash[i + 1][0] = add(multiply(preHash[i][0], base1), input.charAt(i));
                preHash[i + 1][1] = add(multiply(preHash[i][1], base2), input.charAt(i));

                power[i + 1][0] = multiply(power[i][0], base1);
                power[i + 1][1] = multiply(power[i][1], base2);
            }
        }

        // returns hash of substring input[left..right-1]
        int[] getHash(int left, int right) {
            int[] result = new int[2];
            for (int b = 0; b < 2; b++) {
                result[b] = subtract(preHash[right][b],
                        multiply(preHash[left][b], power[right - left][b]));
            }
            return result;
        }
    }

    // function to check if s2 is a rotation of s1
    public static boolean areRotations(String s1, String s2) {

        // concatenate s1 with itself to include
        // all possible rotations
        String concat = s1 + s1;
        int n = s1.length();

        // build rolling hash for the concatenated
        // string and s2
        RollingHash rhConcat = new RollingHash(concat);
        RollingHash rhS2 = new RollingHash(s2);

        // compute the full hash of s2
        int[] targetHash = rhS2.getHash(0, n);

        // slide a window of size n over concat
        // and compare hashes
        for (int i = 0; i <= concat.length() - n; i++) {
            // get hash of substring concat[i...i+n-1]
            int[] subHash = rhConcat.getHash(i, i + n);
            if (subHash[0] == targetHash[0] && subHash[1] == targetHash[1])
                return true;
        }

        // no matching rotation found
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aba";

        if (areRotations(s1, s2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
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