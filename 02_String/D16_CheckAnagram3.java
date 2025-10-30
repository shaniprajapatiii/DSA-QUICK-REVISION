// Given two non-empty strings s1 and s2 of lowercase letters, determine if they are anagrams — i.e., if they contain the same characters with the same frequencies.
/* Approach 3:
   [Expected Approach 2] Using Frequency Array - O(n + m) Time and O(1) Space
Instead of using a hash map to store the frequency of each character, we can create a frequency array of size 26 by using characters as index in this array. The frequency of ‘a’ is going to be stored at index 0, ‘b’ at 1, and so on. To find the index of a character, we subtract character a’s ASCII value from the ASCII value of the character. 

Count character frequency in the first string, then for each character in the second string, decrement its count from the frequency array. If the strings are anagrams, all positions in the frequency array will be zero. Any non-zero position means the frequency of that character is not equal in both the strings.
*/

public class D16_CheckAnagram3 {

    public static boolean areAnagrams(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        // for lowercase a-z
        int[] freq = new int[26];

        // Count frequency of each character in s1
        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;

        // Subtract frequency using characters from s2
        for (int i = 0; i < s2.length(); i++)
            freq[s2.charAt(i) - 'a']--;

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        if (areAnagrams(s1, s2))
            System.out.println("true");
        else
            System.out.println("false");
    }
}