package com.dpc.algorithm;

public class SumTwo {
    public  static void main(String[] args){
        Solution s = new Solution();
        int[] input = {3,2,4};
        int[] index = s.twoSum(input,6);
        System.out.print("["+index[0]+","+index[1]+"]");
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}