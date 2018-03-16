package com.spotify.puzzles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 4 4 16
 * C3 D2
 * C2 D1
 * C2 D1
 * C3 D1
 * C2 D1
 * C3 D1
 * C2 D1
 * C2 D1
 * D3 C1
 * D3 C1
 * D3 C1
 * D3 C1
 * D3 C1
 * D3 C1
 * D3 C1
 * D3 C1
 *
 * => 16 (-C1, -D1, -D2)
 */
public class CatsVsDogs {

    public static int maxSatisfied(int cats, int dogs, String[][] votes) {

        int[] dogsKeep  = new int[dogs+1];
        int[] dogsThrow = new int[dogs+1];
        int[] catsKeep  = new int[cats+1];
        int[] catsThrow = new int[cats+1];

        Map<Integer, List<Integer>> catsToDogs = new HashMap<>();
        Map<Integer, List<Integer>> dogsToCats = new HashMap<>();

        for (String[] vote: votes) {
            // keep
            int forIndex = Character.getNumericValue(vote[0].charAt(1));
            if (vote[0].startsWith("C")) {
                catsKeep[forIndex]++;
            } else {
                dogsKeep[forIndex]++;
            }

            // throw
            int againstIndex = Character.getNumericValue(vote[1].charAt(1));
            if (vote[1].startsWith("C")) {
                catsThrow[againstIndex]++;
                addToMapList(catsToDogs, againstIndex, forIndex);
            } else {
                dogsThrow[againstIndex]++;
            }
        }

        int max = findMax(dogsKeep, dogsThrow, catsKeep, catsThrow);

        return max;
    }

    private static void addToMapList(Map<Integer, List<Integer>> map, int mapIndex, int index) {
        if (map.containsKey(mapIndex)) {
            map.get(mapIndex).add(index);
        }
    }

    private static int findMax(int[] dogsKeep, int[] dogsThrow, int[] catsKeep, int[] catsThrow) {
        int max = 0;

        for (int i = 0; i < dogsThrow.length; i++) {
            int d = dogsThrow[i];
            if (d > 0) {
                if (d > max) {
                    int sum = d - costToThrow(d);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }

        return max;
    }

    private static int costToThrow(int d) {
        return 1;
    }

    public static void main(String[] args) {

        String[][] votes = new String[4][];
        votes[0] = new String[]{"C1", "D1"};
        votes[1] = new String[]{"C1", "D1"};
        votes[2] = new String[]{"C1", "D2"};
        votes[3] = new String[]{"D2", "C1"};
        System.out.println(maxSatisfied(1, 2, votes));
    }
}
