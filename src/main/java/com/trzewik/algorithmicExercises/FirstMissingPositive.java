package com.trzewik.algorithmicExercises;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int currentPositive = 0;
        if (nums.length > 0) {
            int[] sortedNums = sortArray(nums);
            for (int num : sortedNums) {
                if (num >= 1) {
                    if (currentPositive + 1 != num && currentPositive != num) {
                        return currentPositive + 1;
                    } else if (currentPositive + 1 == num) {
                        currentPositive++;
                    }
                }
            }
        }
        return currentPositive + 1;
    }

    private int[] sortArray(int[] nums) {
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - 1; i++) {
                int currentInteger = nums[i];
                int nextInteger = nums[i + 1];
                if (nextInteger < currentInteger) {
                    nums[i] = nextInteger;
                    nums[i + 1] = currentInteger;
                }
            }
        }
        return nums;
    }
}
