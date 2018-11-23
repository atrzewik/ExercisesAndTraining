package com.trzewik.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleList {

    private List<Integer> integers;

    public BubbleList(){
        this.integers = new ArrayList<>(Arrays.asList(2,5,1,-7,9,11,3));
    }

    public void sortIntegers() {
        for (int j =0; j < this.integers.size(); j++) {
            for (int i = 0; i < this.integers.size() - 1; i++) {
                int currentInteger = this.integers.get(i);
                int nextInteger = this.integers.get(i + 1);
                int currentIntegerIndex = this.integers.indexOf(currentInteger);
                if (nextInteger < currentInteger) {
                    this.integers.remove((Integer) nextInteger);
                    this.integers.add(currentIntegerIndex, nextInteger);
                }
            }
        }
    }

    public static void main(String[] args){
        BubbleList bubble = new BubbleList();
        bubble.sortIntegers();
        System.out.println(bubble.integers);
    }
}
