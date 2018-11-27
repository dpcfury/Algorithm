package com.dpc.algorithm;


public class BST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);

        TreeNode cld_1 = new TreeNode(3);
        TreeNode cld_2 = new TreeNode(6);

        TreeNode cld_3 = new TreeNode(2);
        TreeNode cld_4 = new TreeNode(4);
        TreeNode cld_7 =new TreeNode(7);

        root.setLeft(cld_1);
        root.setRight(cld_2);

        cld_1.setLeft(cld_3);
        cld_1.setRight(cld_4);

        cld_2.setRight(cld_7);


    }


}

class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        boolean result = false;

        //algorithm
       int key =k-root.val;


        return result;
    }

    public boolean search(TreeNode root , int k){
        return false;
    }
}