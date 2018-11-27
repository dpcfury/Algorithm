package com.dpc.algorithm.mi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] prices = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prices[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        if (canCombined(prices, target))
            System.out.println(1);
        else
            System.out.println(0);

    }

    private static boolean canCombined(int[] prices, int target) {
        boolean[][] canComnined = new boolean[prices.length][target + 1];
        canComnined[0][0] = true;
        for (int i = 1; i < prices.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (prices[i] <= j)
                    canComnined[i][j] |= (canComnined[i - 1][j - prices[i]] | canComnined[i - 1][j]);
                else
                    canComnined[i][j] = canComnined[i - 1][j];

            }
        }
        return canComnined[prices.length - 1][target];
    }

    private static boolean subSetSum(int[] nums, int sum) {
        int rowLen = nums.length + 1;
        int columnLen = sum + 1;
        boolean[][] dp = new boolean[rowLen][columnLen];
        dp[0][0] = true;
//        for (int j = 1; j < columnLen; j++) dp[0][j] = false;
        for (int i = 1; i < rowLen; i++)
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i - 1] < 0) dp[i][j] |= dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
            }
        return dp[rowLen - 1][sum];
    }
}
