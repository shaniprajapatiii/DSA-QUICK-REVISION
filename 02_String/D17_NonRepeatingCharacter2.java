// Given a string s of lowercase English letters, the task is to find the first non-repeating character. If there is no such character, return '$'.
/*
 [Efficient Approach 1] Using Frequency Array (Two Traversal) – O(2*n) Time and O(MAX_CHAR ) Space
The efficient approach is to either use an array of size MAX_CHAR  to store the frequencies of each character. Traverse the input string twice:

First traversal is to count the frequency of each character.  
Second traversal to find the first character in string with a frequency of one.
 */

public class D17_NonRepeatingCharacter2 {
    private static final int MAX_CHAR = 26;

    public static char nonRep(String s) {
        int[] freq = new int[MAX_CHAR];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Find the first character with frequency 1
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c;
            }
        }
        return '$';
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(nonRep(s));
    }
}