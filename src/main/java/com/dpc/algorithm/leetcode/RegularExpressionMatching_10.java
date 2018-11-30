package com.dpc.algorithm.leetcode;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * <p>
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 */
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() != 0 && p.length() == 0) return false;
        if (s.length() == 0) {
            if (p.length() > 1 && p.charAt(1) == '*') {
                if (isMatch(s, p.substring(2))) return true;
            }
            return false;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) return true;
        }


        char s1 = s.charAt(0);
        char p1 = p.charAt(0);

        if (s1 == p1 || p1 == '.') {
            if (p.length() > 1 && p.charAt(1) == '*') {
                if (isMatch(s.substring(1), p.substring(2)) | isMatch(s.substring(1), p)) return true;
            } else {
                if (isMatch(s.substring(1), p.substring(1))) return true;
            }
        }

        return false;
    }

}
