package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

public class SecondBiggestFinder {
    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {19, 9, 11, 0, 12};

        System.out.println("Second biggest in numbers1: " + findSecondBiggest(numbers1));
        System.out.println("Second biggest in numbers2: " + findSecondBiggest(numbers2));
    }

    public static int findSecondBiggest(int[] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Array should have at least two elements.");
        }

        int firstBiggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > firstBiggest) {
                secondBiggest = firstBiggest;
                firstBiggest = num;
            } else if (num > secondBiggest && num != firstBiggest) {
                secondBiggest = num;
            }
        }

        if (secondBiggest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("There is no second biggest element in the array.");
        }

        return secondBiggest;
    }
}
