package com.trzewik.sorting;

public class InsertionArray {

    private Integer[] integers;

    public InsertionArray(){
        this.integers = new Integer[]{2,5,1,-7,9,11,3};
    }

    public void sortIntegers(){
        for (int j =0; j < this.integers.length; j++) {
            int currentIntegerIndex = j;
            int currentInteger = this.integers[j];
            for (int i=j-1; i>=0; i--){
                if (currentInteger<this.integers[i]){
                    currentIntegerIndex=i;
                }
            }
            if (j>currentIntegerIndex) {
                Integer[] currentArray = this.integers;
                System.arraycopy(currentArray, currentIntegerIndex, this.integers, currentIntegerIndex+1, j- currentIntegerIndex);
            }
            this.integers[currentIntegerIndex] = currentInteger;
        }
    }

    public static void main(String[] args){
        InsertionArray insertionArray = new InsertionArray();
        insertionArray.sortIntegers();
        for (Integer integer: insertionArray.integers){
            System.out.println(integer);
        }
    }
}
