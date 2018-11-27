package com.dpc.algorithm;
/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 * */
public class SumII {

    public  static void main(String[] args){
        Solution1 s = new Solution1();
        int[] input = {2, 3,4};
        int[] index = s.twoSum(input,6);
        System.out.print("index1="+index[0]+",\t"+"index2="+index[1]);
    }

}
class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];

        //algorithm
        int left = 0;
        int right = numbers.length-1;

        while(left < right ){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                result[0]=left+1;
                result[1]=right+1;
                break;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }

        return result;
    }

    public int binaSearch(int[] numbsers,int start ,int end,int key){
        if(start>end)
            return -1;
        int mid = (end+start) /2;

        if(numbsers[mid]==key)
            return mid;
        else if(numbsers[mid] < key){
            return binaSearch(numbsers,mid+1,end,key);
        }else
            return binaSearch(numbsers,start,mid-1,key);

    }
}