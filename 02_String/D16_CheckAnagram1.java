// Given two non-empty strings s1 and s2 of lowercase letters, determine if they are anagrams — i.e., if they contain the same characters with the same frequencies.
/* Approach 1:
   [Naive Approach] Using Sorting
The idea is that if the strings are anagrams, then their characters will be the same, just rearranged. Therefore, if we sort the characters in both strings, the sorted strings will be identical if the original strings were anagrams.
   We can simply sort the two given strings and compare them – if they are equal, then the original strings are anagrams of each other.
*/

import java.util.Arrays;

public class D16_CheckAnagram1 {

    public static boolean areAnagrams(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        // Sort both strings
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        // Compare sorted strings
        return Arrays.equals(s1Array, s2Array);
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        if (areAnagrams(s1, s2) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}

/*
 Example:
 Input: s1 = "listen", s2 = "silent"
 Output: true   
    Explanation: Both strings contain the same characters with the same frequencies.
    Time Complexity: O(n log n) due to sorting.
    Space Complexity: O(1) if we ignore the space used for sorting, otherwise O(n) for the character arrays.
*/