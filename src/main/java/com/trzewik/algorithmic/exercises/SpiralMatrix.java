package com.trzewik.algorithmic.exercises;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrderMatrix = new ArrayList<>();
        if (matrix.length > 0) {
            int allMatrixLength = matrix.length * matrix[0].length;
            int firstColumn = 0;
            int firstRow = 0;
            int lastRow = matrix.length - 1;
            int lastColumn = matrix[0].length - 1;
            while (spiralOrderMatrix.size() < allMatrixLength) {
                for (int i = firstColumn; i <= lastColumn; i++) {
                    spiralOrderMatrix.add(matrix[firstRow][i]);
                }
                if (spiralOrderMatrix.size() >= allMatrixLength){
                    break;
                }
                firstRow += 1;
                for (int i = firstRow; i <= lastRow; i++) {
                    spiralOrderMatrix.add(matrix[i][lastColumn]);
                }
                if (spiralOrderMatrix.size() >= allMatrixLength){
                    break;
                }
                lastColumn -= 1;
                for (int i = lastColumn; i >= firstColumn; i--) {
                    spiralOrderMatrix.add(matrix[lastRow][i]);
                }
                if (spiralOrderMatrix.size() >= allMatrixLength){
                    break;
                }
                lastRow -= 1;
                for (int i = lastRow; i >= firstRow; i--) {
                    spiralOrderMatrix.add(matrix[i][firstColumn]);
                }
                firstColumn += 1;
            }
        }
        return spiralOrderMatrix;
    }
}
