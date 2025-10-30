//  Stock Buy and Sell - Max one Transaction Allowed
/*
Approach 2:
[Expected Approach] One Traversal Solution - O(n) Time and O(1) Space
In order to maximize the profit, we need to minimize the cost price and maximize the selling price. So at every step, we keep track of the minimum buy price of stock encountered so far. For every price, we subtract with the minimum so far and if we get more profit than the current result, we update the result. 
*/

// Java Program to solve stock buy and sell
// using one traversal

public class D8_Stock_BuyAndSell_MOT2 {

   public static int maxProfit(int[] prices) {
      int minSoFar = prices[0];
      int res = 0;

      // Update the minimum value seen so far
      // if we see smaller
      for (int i = 1; i < prices.length; i++) {
         minSoFar = Math.min(minSoFar, prices[i]);

         // Update result if we get more profit
         res = Math.max(res, prices[i] - minSoFar);
      }
      return res;
   }

   public static void main(String[] args) {
      int[] prices = { 7, 10, 1, 3, 6, 9, 2 };
      System.out.println(maxProfit(prices));
   }
}