package me.fengyj.leetcode.all.dynamic_programming;

public class No_188_BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {

        if(k == 0 || prices.length <= 1) return 0;

        int rounds = Math.min(k, prices.length - 1);

        int[][] cache = new int[prices.length][Math.min(2, rounds) * 2]; // days * rounds * (buy and sell)

        for(int r = 0; r < rounds; r++){

            int rBuy = r == 0 ? 0 : 2;
            int rSell = rBuy + 1;
            cache[0][rBuy] = -prices[0];
            cache[0][rSell] = 0;
            for(int t = 1; t < prices.length; t++) {

                /*
        t0          	t1                                  	t2
r0-b	-p[t0]         	max(r0-b[t0], -p[t1])       	        max(r0-b[t1], -p[t2])
r0-s	0              	max(r0-s[t0], r0-b[t1] + p[t1])	        max(r0-s[t1], r0-b[t2] + p[t2])
r1-b	-p[t0]         	max(r1-b[t0], r0-s[t0]-p[t1])   	    max(r1-b[t1], r0-s[t1]-p[t2])
r1-s	0	            max(r1-s[t0], r1-b[t1] + p[t1])	        max(r1-s[t1], r1-b[t2] + p[t2])
                 */

                int prevRoundSell = r == 0 ? 0 : cache[t - 1][rSell - 2];
                int prevBuy = cache[t - 1][rBuy];
                cache[t][rBuy] = Math.max(prevBuy, prevRoundSell - prices[t]);
                int prevSell = cache[t - 1][rSell];
                cache[t][rSell] = Math.max(prevSell, cache[t][rBuy] + prices[t]);
            }
            if(r == 0) continue;

            for(int t = 1; t < prices.length; t++) {
                cache[t][0] = cache[t][rBuy];
                cache[t][1] = cache[t][rSell];
            }
        }

        return cache[prices.length - 1][cache[prices.length - 1].length - 1];
    }
}
