package com.dpc.algorithm.mi;

import java.util.Scanner;

public class Main {
    private static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lineOne = sc.nextLine().split(" ");
        int n = Integer.valueOf(lineOne[0]);
        int m = Integer.valueOf(lineOne[1]);
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) nums[i] = sc.nextInt();

        System.out.println(solve(n, m, nums));

    }

    private static int solve(int n, int m, int[] nums) {
        int i, j, k, temp, maxt;
        int[][] f = new int[n + 1][m + 1];
        for (i = 1; i <= n; i++)
            f[i][1] = f[i - 1][1] + nums[i];

        for (j = 2; j <= m; j++)
            for (i = j; i <= n; i++) {
                for (k = 1, temp = MAX; k < i; k++) {
                    maxt = max(f[i][1] - f[k][1], f[k][j - 1]);
                    if (temp > maxt)
                        temp = maxt;
                }
                f[i][j] = temp;
            }

        return f[n][m];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
