package com.trzewik.sorting;


public class BubbleArray {

    private Integer[] integers;

    public BubbleArray(){
        this.integers = new Integer[]{2,5,1,-7,9,11,3};
    }

    public void sortIntegers(){
        for (int j =0; j < this.integers.length; j++) {
            for (int i = 0; i < this.integers.length - 1; i++) {
                int currentInteger = this.integers[i];
                int nextInteger = this.integers[i + 1];
                if (nextInteger < currentInteger) {
                    this.integers[i] = nextInteger;
                    this.integers[i+1] = currentInteger;
                }
            }
        }
    }

    public static void main(String[] args){
        BubbleArray bubble = new BubbleArray();
        bubble.sortIntegers();
        for (Integer integer: bubble.integers){
            System.out.println(integer);
        }
    }
}
