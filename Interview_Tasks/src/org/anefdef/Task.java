package org.anefdef;

import java.util.Arrays;

public class Task {

    public long doStuff(int n) {
        int inputSum = getSumOfDigits(n);
        int res = n;
        do {
            ++res;
        } while (getSumOfDigits(res) != inputSum);
        return res;
    }

    private int getSumOfDigits(int number) {
        String input = String.valueOf(number);
        return input.chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public int doThings(int[] A, int[] B) {
        long sumA = Arrays.stream(A).asLongStream().sum();
        long sumB = Arrays.stream(B).asLongStream().sum();
        if(sumA == sumB) {
            int res = 0;
            long currentSumALeft = 0;
            long currentSumBLeft = 0;
            int range = A.length -1;

            for (int i = 0; i < range; i++) {

                currentSumALeft += A[i];

                currentSumBLeft += B[i];

                if (currentSumALeft == currentSumBLeft
                        && currentSumBLeft == (sumB - currentSumBLeft))
                    res++;
            }
            return res;
        }
        return 0;
    }
}
