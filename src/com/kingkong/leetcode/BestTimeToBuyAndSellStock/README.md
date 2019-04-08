# [121. Best Time to Buy and Sell Stock (Easy)](https://leetcode.com/problems/average-of-levels-in-binary-tree/)

## Description


Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

**Example:**

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

## 解法 1

通过循环遍历数组找到最低的买入价, 如果高于买入价则更新最大利润;

时间复杂度: 需要遍历一遍数组 O(n)
空间复杂度: 需要变量存储买入价与最大利润, O(1)

```java
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int buyPrice = prices[0], maxProfit = 0;

        for (int i = 1; i < prices.length; ++i) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }
        return maxProfit;
    }
}
```
