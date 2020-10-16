package org.anefdef;

import java.util.Arrays;

public class Task {

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
