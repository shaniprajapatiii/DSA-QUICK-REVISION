// Given a string s of lowercase English letters, the task is to find the first non-repeating character. If there is no such character, return '$'.
/*
 [Naive Approach] Using Nested Loop – O(n^2) Time and O(1) Space
The idea is to use two nested loops, the outer loop for picking an element and the inner loop for finding another occurrence of the picked character in the string. As soon as we find a character which has only one occurrence in the input string, return it. If all characters have multiple occurrences, return '$'.
 */

public class D17_NonRepeatingCharacter1 {

    public static char nonRep(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            boolean found = false;

            for (int j = 0; j < n; ++j) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return s.charAt(i);
        }

        return '$';
    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(nonRep(s));
    }
}