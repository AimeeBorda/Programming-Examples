package dynamicProgramming.polygonSet;

import java.util.Arrays;

/**
 * We call a set X good if:
 |X| >= 3.
 There exist a postive area polygon such that each side has a different length, and the set of lengths of sides is X.
 You are given a set S, return the number of subsets that is good.
 */
public class PolygonSet {
    public int count(int[] S) {

        int[][] count = new int[S.length][S.length];

        for(int end = 2; end < S.length ; end++) {
            for(int start = end - 2; start >= 0; start-- ){
                count[start][end] = count[start][end-1] + count[start + 1][end] + (formPolygon(S,start, end)? 1: 0);
            }
        }

        return count[0][S.length-1];
    }



    public boolean formPolygon(int[] r, int s, int e){
        //ri≤12(r1+...+rn)

        double sum = Arrays.stream(r).skip(s).limit(e - s + 1).sum() /2.0;
        return !Arrays.stream(r).anyMatch(st -> st >= sum);
    }


}
