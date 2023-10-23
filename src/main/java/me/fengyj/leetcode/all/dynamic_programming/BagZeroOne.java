package me.fengyj.leetcode.all.dynamic_programming;

import java.util.Arrays;

public class BagZeroOne {

    public int maxValue(int[] weights, int[] values, int bag) {

        int[] cacheValues = new int[bag + 1];
        int[] cacheWeights = new int[bag + 1];
        Arrays.fill(cacheValues, 0);
        Arrays.fill(cacheWeights, 0);

        for (int i = 0; i < weights.length; i++) {

            for (int b = bag; b >= 1; b--) {

                int bagAvailable = b - cacheWeights[b];
                if (bagAvailable >= weights[i]) {
                    cacheValues[b] = cacheValues[b - 1] + values[i];
                    cacheWeights[b] = cacheWeights[b - 1] + weights[i];
                }
                else {
                    bagAvailable = b - weights[i];
                    if (bagAvailable >= 0) {
                        cacheValues[b] = Math.max(cacheValues[bagAvailable] + values[i], cacheValues[b - 1]);
                        cacheWeights[b] = Math.max(cacheWeights[bagAvailable] + weights[i], cacheWeights[b - 1]);
                    }
                }
            }
        }

        return cacheValues[bag];
    }
}
