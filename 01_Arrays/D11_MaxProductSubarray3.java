// Given an array arr[] consisting of positive, negative, and zero values, find the maximum product that can be obtained from any contiguous subarray of arr[].

public class D11_MaxProductSubarray3 {

    public static int maxProduct(int[] arr) {

        int n = arr.length;
        int maxProd = Integer.MIN_VALUE;

        // leftToRight to store product from left to Right
        int leftToRight = 1;

        // rightToLeft to store product from right to left
        int rightToLeft = 1;

        for (int i = 0; i < n; i++) {
            if (leftToRight == 0)
                leftToRight = 1;
            if (rightToLeft == 0)
                rightToLeft = 1;

            // calculate product from index left to right
            leftToRight *= arr[i];

            // calculate product from index right to left
            int j = n - i - 1;
            rightToLeft *= arr[j];
            maxProd = Math.max(leftToRight,
                    Math.max(rightToLeft, maxProd));
        }
        return maxProd;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };
        System.out.println(maxProduct(arr));
    }
}

// [Expected Approach - 2] By Traversing in Both Directions - O(n) Time and O(1)
// Space
// We will follow a simple approach that is to traverse from the start and keep
// track of the running product and if the running product is greater than the
// max product, then we update the max product. Also, if we encounter '0' then
// make product of all elements till now equal to 1 because from the next
// element, we will start a new subarray.

// But what is the problem with this approach?

// Problem will occur when our array will contain odd no. of negative elements.
// In that case, we have to reject one negative element so that we can even no.
// of negative elements and their product can be positive. Now, since subarray
// should be contiguous so we can't simply reject any one negative element. We
// have to either reject the first negative element or the last negative
// element.

// Now, if we traverse from start then only the last negative element can be
// rejected and if we traverse from the last then the first negative element can
// be rejected. So we will traverse from both ends and find the maximum product
// subarray.