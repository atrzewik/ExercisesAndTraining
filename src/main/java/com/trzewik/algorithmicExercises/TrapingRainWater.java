package com.trzewik.algorithmicExercises;

public class TrapingRainWater {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int count = 0;
        int biggestHeightBefore = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            int currentHeight = height[i];
            int biggestHeightAfter = getBiggestHeightAfter(i, height);
            if (biggestHeightBefore < currentHeight) {
                biggestHeightBefore = currentHeight;
            }
            if (biggestHeightBefore != currentHeight && biggestHeightBefore <= biggestHeightAfter) {
                count += biggestHeightBefore - currentHeight;
            } else if (biggestHeightAfter != currentHeight && biggestHeightAfter < biggestHeightBefore) {
                count += biggestHeightAfter - currentHeight;
            }
        }
        return count;
    }

    private int getBiggestHeightAfter(int currentHeightIndex, int[] height) {
        int biggestHeightAfter = height[currentHeightIndex];
        for (int i = currentHeightIndex + 1; i < height.length; i++) {
            int checkingHeightAfter = height[i];
            if (checkingHeightAfter > biggestHeightAfter) {
                biggestHeightAfter = checkingHeightAfter;
            }
        }
        return biggestHeightAfter;
    }
}