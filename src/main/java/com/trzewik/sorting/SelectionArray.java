package com.trzewik.sorting;

public class SelectionArray {

    private Integer[] integers;

    public SelectionArray(){
        this.integers = new Integer[]{2,5,1,-7,9,11,3};
    }

    public void sortIntegers(){
        Integer[] sortedIntegers = new Integer[this.integers.length];
        int lengthOfSortedIntegers = this.integers.length;
        for (int j =0; j < lengthOfSortedIntegers; j++) {
            int smallestInteger = this.integers[0];
            for (int i = 1; i < this.integers.length; i++) {
                int nextInteger = this.integers[i];
                if (nextInteger < smallestInteger) {
                    smallestInteger = nextInteger;
                }
            }
            sortedIntegers[j] = smallestInteger;
            this.integers = getArrayWithoutSmallestInteger(this.integers, getIndexOfSmallestInteger(smallestInteger));
        }
        this.integers = sortedIntegers;
    }

    private int getIndexOfSmallestInteger(int smallestInteger){
        int index = 0;
        for (int i =0; i < this.integers.length; i++){
            if (this.integers[i] == smallestInteger){
                index = i;
            }
        }
        return index;
    }

    private Integer[] getArrayWithoutSmallestInteger(Integer[] integers, int indexOfSmallestInteger){
        Integer[] newArray = new Integer[integers.length-1];
        int indexOfNewArray = 0;
        for (int i=0; i<integers.length; i++){
            if (i!=indexOfSmallestInteger){
                newArray[indexOfNewArray] = integers[i];
                indexOfNewArray++;
            }
        }
        return newArray;
    }

    public static void main(String[] args){
        SelectionArray selectionArray = new SelectionArray();
        selectionArray.sortIntegers();
        for (Integer integer: selectionArray.integers){
            System.out.println(integer);
        }
    }
}
