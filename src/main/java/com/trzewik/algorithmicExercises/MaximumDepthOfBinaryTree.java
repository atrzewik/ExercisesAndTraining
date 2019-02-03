package com.trzewik.algorithmicExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumDepthOfBinaryTree {

        private List<Integer> paths = new ArrayList();
        private int nodes = 0;

        public int maxDepth(TreeNode root) {
            findAllPaths(root, nodes);
            Collections.sort(paths);
            Collections.reverse(paths);
            return paths.get(0);
        }

        private void findAllPaths(TreeNode root, int path){
            if(root == null){
                paths.add(path);
                return;
            }
            path += 1;
            findAllPaths(root.right, path);
            findAllPaths(root.left, path);
        }

    class TreeNode {
        private int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
