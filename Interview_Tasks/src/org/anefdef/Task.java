package org.anefdef;

import java.util.Arrays;

public class Task {

    public static void main(String[] args) {
        Task task = new Task();
        System.out.println(task.countChars("aaabbccczcc"));
    }

    public String countChars(String line) {
        return null;
    }

    public int findSquares(int a, int b) {
        int res = 0;
        for (int i = a; i <= b; i++) {
            double root = Math.sqrt(i);
            if ((root - Math.floor(root)) == 0) {
                res++;
            }
        }
        return res;
    }

    public int findDigits(int a, int b) {
        int res = 0;
        for (int i = 1; i <= b; i++) {
            double temp = i * (i + 1);
            if (temp > a && temp <= b) {
                res++;
            }
        }
        return res;
    }

    public long doStuff(int n) {
        int inputSum = getSumOfDigits(n);
        int res = n;
        while (getSumOfDigits(++res) != inputSum) ;
        return res;
    }

    private int getSumOfDigits(int number) {
        return String.valueOf(number).chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public int doThings(int[] A, int[] B) {
        long sumA = Arrays.stream(A).asLongStream().sum();
        long sumB = Arrays.stream(B).asLongStream().sum();

        if (sumA != sumB || sumA % 2 != 0) {
            return 0;
        }
        int res = 0;
        long currentSumALeft = 0;
        long currentSumBLeft = 0;
        int range = A.length - 1;

        for (int i = 0; i < range; i++) {
            currentSumALeft += A[i];
            currentSumBLeft += B[i];
            if (currentSumALeft == currentSumBLeft && currentSumALeft == sumA - currentSumALeft)
                res++;
        }
        return res;
    }
}
