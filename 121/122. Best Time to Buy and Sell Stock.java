// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length ==0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i =0; i< prices.length; i++){
            minPrice = (prices[i] < minPrice ) ? prices[i] : minPrice;
            maxProfit = (prices[i] - minPrice) > maxProfit ? prices[i] - minPrice : maxProfit;   
        }
        return maxProfit;
    }
}

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
// Example 2:

// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

class Solution {
    public int maxProfit(int[] prices) {
       int minPrice = prices[0];
       int maxProfit = 0;
       for(int i = 0; i< prices.length; i++ ){
           if(prices[i] < minPrice){
               minPrice = prices[i];
           } else{
               maxProfit += (prices[i] - minPrice);
               minPrice = prices[i];
           }
       }
        return maxProfit;
    }
}
