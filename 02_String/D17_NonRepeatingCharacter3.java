/*  [Efficient Approach 2] By Storing Indices (Single Traversal) – O(n) Time and O(MAX_CHAR ) Space
The above approach can be optimized using a single traversal of the string. The idea is to maintain a visited array of size MAX_CHAR initialized to -1, indicating no characters have been seen yet. Now, we iterate through the string:

If a character is seen for the first time, its index is stored in the array. 
If the character is found again then its array value is set to -2 to represent this character is now repeating. 
After the string traversal, traverse the visited array and check if value in the array is not equal to -1 or -2 (means, this character is not repeating). We then find the smallest positive index from these values to find the first non-repeating character. If no such index is found, return '$'.
 */

import java.util.*;

public class D17_NonRepeatingCharacter3 {
    static final int MAX_CHAR = 26;

    public static char nonRep(String s) {
        int[] vis = new int[MAX_CHAR];
        Arrays.fill(vis, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (vis[index] == -1) {
                // Store the index when character is first seen
                vis[index] = i;
            } else {
                // Mark character as repeated
                vis[index] = -2;
            }
        }

        int idx = -1;
        // Find the smallest index of the non-repeating characters
        for (int i = 0; i < MAX_CHAR; i++) {
            if (vis[i] >= 0 && (idx == -1 || vis[i] < vis[idx])) {
                idx = i;
            }
        }
        return (idx == -1) ? '$' : s.charAt(vis[idx]);
    }

    public static void main(String[] args) {
        String s = "aabbccc";
        System.out.println(nonRep(s));
    }
}