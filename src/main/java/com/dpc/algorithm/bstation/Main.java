package com.dpc.algorithm.bstation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
        int target = sc.nextInt();

        for (List<Integer> res : combinationSum(nums, target)) {
            System.out.println(res.get(0) + " " + res.get(1));
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, 0, target, 2);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start, int remain, int k) {
        if (remain == 0 && k == 0)
            res.add(new ArrayList<>(tempList));
        else if (remain < 0 || k == 0)
            return;
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(res, tempList, nums, i, remain - nums[i], k - 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
