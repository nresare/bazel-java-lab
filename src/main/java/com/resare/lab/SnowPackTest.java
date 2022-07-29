package com.resare.lab;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SnowPackTest {
    @Test
    void testSnowPack() {
//        assertEquals(
//                List.of(new Valley(2, 2, 3)),
//                findValleys(List.of(1,3,2,3))
//        );
//        assertEquals(
//                List.of(new Valley(3, 6, 3), new Valley(8, 9, 3)),
//                findValleys(List.of(0,1,3,0,1,2,0,4,2,0,3,0))
//        );
//        assertEquals(
//                13,
//                upstreamSnowPack(List.of(0,1,3,0,1,2,0,4,2,0,3,0).toArray(new Integer[0]))
//        );
//        assertEquals(8, snowPack(List.of(8,7,8,0,0,3,2,3)));
    }

    private record Valley(int start, int end, int height) {}

    List<Valley> findValleys(List<Integer> input) {
        var results = new ArrayList<Valley>();
        int leftPeakHeight = 0;
        int leftPeakPosition = -1;
        boolean inValley = false;
        int bestRightCandidatePosition = 0;
        int bestRightCandidateHeight = 0;
        int previous = 0;

        for (int i = 0; i < input.size(); i++) {
            int value = input.get(i);
            if (!inValley) {
                if (value > leftPeakHeight) {
                    leftPeakHeight = value;
                    leftPeakPosition = i;
                }
                if (value < leftPeakHeight) {
                    inValley = true;
                }
            } else {
                if (value >= leftPeakHeight) {
                    results.add(new Valley(leftPeakPosition + 1, i - 1, leftPeakHeight));
                    leftPeakHeight = value;
                    leftPeakPosition = i;
                    inValley = false;
                } else {
                    if (value > previous && value > bestRightCandidateHeight) {
                        bestRightCandidateHeight = value;
                        bestRightCandidatePosition = i;
                    }
                }
            }
            previous = value;
        }
        if (inValley) {
            results.add(new Valley(leftPeakPosition + 1, bestRightCandidatePosition - 1, bestRightCandidateHeight));
        }
        return results;
    }

    public int snowPack(List<Integer> input) {
        int sum = 0;
        for (var valley : findValleys(input)) {
            for (int i = valley.start; i <= valley.end; i++) {
                sum += valley.height - input.get(i);
            }
        }
        return sum;
    }

    public int upstreamSnowPack(Integer[] arr) {
        var total = 0;
        Integer left_highest[] = new Integer[arr.length];
        Integer left_max = 0;
        for (Integer i = 0; i < arr.length; i++) {
            if (arr[i] > left_max) {
                left_max = arr[i];
            }
            left_highest[i] = left_max;
        }
        Integer right_max = 0;
        for (Integer i = arr.length - 1; i > 0; i--) {
            if (arr[i] > right_max) {
                right_max = arr[i];
            }
            if (Math.min(right_max, left_highest[i]) > arr[i]) {
                total += Math.min(right_max, left_highest[i]) - arr[i];
            }

        }
        return total;
    }
}
