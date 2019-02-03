package com.trzewik.algorithmicExercises;

public class MinimumAbsoluteDifferenceInBST {

    private int minimumDifference = 0;

    public int getMinimumDifference(TreeNode root) {
        if (isRootNotNull(root)) {
            setFirstValueOfPossibleMinimumDifference(root);
            compareRoots(root);
        }
        return minimumDifference;
    }

    private void compareRoots(TreeNode root) {
        if (isRootNotNull(root.left)) {
            minimumDifference = Math.min(minimumDifference, countAbsoluteDifference(root.val, root.left.val));
            compareRoots(root.left);
            compareFurtherRoots(root, root.left);
        }
        if (isRootNotNull(root.right)) {
            minimumDifference = Math.min(minimumDifference, countAbsoluteDifference(root.val, root.right.val));
            compareRoots(root.right);
            compareFurtherRoots(root, root.right);
        }
    }

    private void compareFurtherRoots(TreeNode root, TreeNode nextRoot) {
        if (isRootNotNull(nextRoot.left)) {
            minimumDifference = Math.min(minimumDifference, countAbsoluteDifference(root.val, nextRoot.left.val));
            compareFurtherRoots(root, nextRoot.left);
        }
        if (isRootNotNull(nextRoot.right)) {
            minimumDifference = Math.min(minimumDifference, countAbsoluteDifference(root.val, nextRoot.right.val));
            compareFurtherRoots(root, nextRoot.right);
        }
    }

    private void setFirstValueOfPossibleMinimumDifference(TreeNode root) {
        if (isRootNotNull(root.left)) {
            minimumDifference = countAbsoluteDifference(root.val, root.left.val);
        } else if (isRootNotNull(root.right)) {
            minimumDifference = countAbsoluteDifference(root.val, root.right.val);
        }
    }

    private int countAbsoluteDifference(int firstNumber, int secondNumber) {
        return Math.abs(firstNumber - secondNumber);
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