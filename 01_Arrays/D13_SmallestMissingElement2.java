// Given an unsorted array arr[] with both positive and negative elements, find the smallest positive number missing from the array.

public class D13_SmallestMissingElement2 {

    public static int missingNumber(int[] arr) {
        int n = arr.length;

        // To mark the occurrence of elements
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            // if element is in range from 1 to n
            // then mark it as visited
            if (arr[i] > 0 && arr[i] <= n)
                vis[arr[i] - 1] = true;
        }
        // Find the first element which is unvisited
        // in the original array
        for (int i = 1; i <= n; i++) {
            if (!vis[i - 1]) {
                return i;
            }
        }
        // if all elements from 1 to n are visited
        // then n+1 will be first positive missing number
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -3, 4, 1, 1, 7 };
        System.out.println(missingNumber(arr));
    }
}

/*
 * [Better approach] Using Visited Array - O(n) Time and O(n) Space
 * The idea is to create a visited array, to keep track of which numbers from
 * the original array were present. For each positive number in the input array,
 * we mark its corresponding position in the visited array. After that, we go
 * through the visited array to find the first position that isn’t visited. The
 * first unvisited index tells us the first missing positive number.
 * Note that we are marking numbers within the range from 1 to n only.
 */