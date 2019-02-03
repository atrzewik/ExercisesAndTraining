package com.trzewik.algorithmicExercises;

public class RangeSumOfBST {

    private int rangeSum;

    public int rangeSumBST(TreeNode root, int L, int R) {
        rangeSum = 0;
        setRangeSum(root, L, R);
        return rangeSum;
    }

    private void setRangeSum(TreeNode root, int min, int max) {
        if (isRootNotNull(root)) {
            rangeSum += valueToAdd(root.val, min, max);
            setRangeSum(root.left, min, max);
            setRangeSum(root.right, min, max);
        }
    }

    private int valueToAdd(int summand, int min, int max) {
        return summand >= min && summand <= max ? summand : 0;
    }

    private boolean isRootNotNull(TreeNode root) {
        return root != null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}