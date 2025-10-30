// Given two non-empty strings s1 and s2 of lowercase letters, determine if they are anagrams — i.e., if they contain the same characters with the same frequencies.
/* Approach 2:
   [Expected Approach 1] Using Hash Map or Dictionary - O(n + m) Time and O(1) Space
The idea is to use a hash map or dictionary count the frequency of each character in both the input strings. If the frequency of every character matches in both strings, then the strings are anagrams. 
*/

import java.util.HashMap;

public class D16_CheckAnagram2 {

    public static boolean areAnagrams(String s1, String s2) {
        
        if(s1.length() != s2.length()){
            return false;
        }
        // create a hashmap to store 
        // character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();

        // count frequency of each
        // character in string s1
        for (char ch : s1.toCharArray())
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

        // count frequency of each
        // character in string s2 
        for (char ch : s2.toCharArray())  
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

        // check if all frequencies are zero
        for (var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";
        System.out.println(areAnagrams(s1, s2) ? "true" : "false");

    }
}

/*
 * Step by Step Approach:
 * 
 * First, count the occurrences of each character in the first string using a
 * HashMap.
 * Then, iterate through the second string and decrement the corresponding count
 * for each character in the same HashMap.
 * After processing both strings, check the HashMap: if all character counts are
 * zero, the strings are anagrams
 * Any non-zero count indicates a mismatch in character frequency, meaning the
 * strings are not anagrams.
 */