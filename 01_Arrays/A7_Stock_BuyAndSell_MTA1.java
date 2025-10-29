// Stock Buy and Sell - Multiple Transaction Allowed
/* Given an array prices[] representing stock prices, find the maximum total profit that can be earned by buying and selling the stock any number of times.
   Note: We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.
*/

/*
Approach 1:
[Naive Approach] By Trying All Possibility - O(2n) Time and O(n) Space
The idea is to use recursion to simulate all choices of buying and selling. For each day, you can either skip it or buy on that day. If you buy at day i, then you try all possible selling days j > i where price[j] > price[i].
*/

public class A7_Stock_BuyAndSell_MTA1 {

   // Recursive function to find max profit
   public static int maxProfitRec(int[] price, int start, int end) {
      int res = 0;

      // Try every possible pair of buy (i) and sell (j)
      for (int i = start; i < end; i++) {
         for (int j = i + 1; j <= end; j++) {

            // Valid transaction if selling price > buying price
            if (price[j] > price[i]) {

               // Current profit + profit from left and right parts
               int curr = (price[j] - price[i]) +
                     maxProfitRec(price, start, i - 1) +
                     maxProfitRec(price, j + 1, end);
               res = Math.max(res, curr);
            }
         }
      }
      return res;
   }

   public static int maxProfit(int[] prices) {
      return maxProfitRec(prices, 0, prices.length - 1);
   }

   public static void main(String[] args) {
      int[] prices = { 100, 180, 260, 310, 40, 535, 695 };
      System.out.println(maxProfit(prices));
   }
}

/*
 * Explanation:
 * Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
 * Output: 865
 * Explanation: Buy the stock on day 0 and sell it on day 3 = 310 - 100 = 210
 * and Buy the stock on day 4 and sell it on day 6 = 695 - 40 = 655 so the
 * Maximum Profit is = 210 + 655 = 865.
 * 
 * Input: prices[] = [4, 2]
 * Output: 0
 * Explanation: Stock prices keep decreasing, there is no chance to sell at a
 * higher price after buying, so no profit can be made.
 */