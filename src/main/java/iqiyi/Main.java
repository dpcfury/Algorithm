package iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] s1 = new int[3];
        int[] s2 = new int[3];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 3; i++) {
            char[] s = input.substring(0, 3).toCharArray();
            s1[i] = s[i] - '0';
            sum1 += s1[i];
        }
        for (int i = 0; i < 3; i++) {
            char[] s = input.substring(3, 6).toCharArray();
            s2[i] = s[i] - '0';
            sum2 += s2[i];
        }

        if (sum1 == sum2) System.out.println(0);
        else if (sum1 < sum2) {
            System.out.println(getCount(s1, s2, sum2 - sum1));
        } else {
            System.out.println(getCount(s2, s1, sum1 - sum2));
        }

    }


    private static int getCount(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k <= 0) {
                return count;
            }
            int cur = 9 - nums[i];
            k -= cur;
            count++;
        }
        return count;

    }

    private static int getCount(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = nums2.length - 1;
        int count = 0;
        while (i < nums1.length && j >= 0 && k > 0) {
            int profit1 = 9 - nums1[i];
            int profit2 = nums2[j];

            if (profit1 >= profit2) {
                k -= profit1;
                i++;
            } else {
                k -= profit2;
                j--;
            }
            count++;
        }
        return count;
    }

}
