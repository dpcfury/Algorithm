package com.dpc.algorithm.leetcode;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring_76 {

    public String minWindow(String s, String t) {
        int start = 0, left = 0, num = t.length();
        int len = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                if (map.get(chs[i]) > 0) {
                    num--;
                }
                map.put(chs[i], map.get(chs[i]) - 1);

            }
            while (num == 0) {
                len = (i - left + 1) < len ? (i - (start = left) + 1) : len;
                if (map.containsKey(chs[left]) && map.get(chs[left]) <= 0) {
                    map.put(chs[left], map.get(chs[left]) + 1);
                    if (map.get(chs[left]) > 0) {
                        num++;
                    }

                }
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
