// Stock Buy and Sell - Multiple Transaction Allowed
/*
Approach 3:
[Expected Approach] By Accumulating Profit - O(n) Time and O(1) Space
The idea is that profit only comes when prices rise. If the price goes up from one day to the next, we can think of it as buying yesterday and selling today. Instead of waiting for the exact bottom and top, we simply grab every small upward move. Adding these small gains together is the same as if we had bought at each valley and sold at each peak because every rise between them gets counted.
*/

public class A7_Stock_BuyAndSell_MTA3 {

   public static int maxProfit(int[] prices) {
      int res = 0;

      // Keep on adding the difference between
      // adjacent when the prices are increasing
      for (int i = 1; i < prices.length; i++) {
         if (prices[i] > prices[i - 1])
            res += prices[i] - prices[i - 1];
      }

      return res;
   }

   public static void main(String[] args) {
      int[] prices = { 100, 180, 260, 310, 40, 535, 695 };
      System.out.println(maxProfit(prices));
   }
}