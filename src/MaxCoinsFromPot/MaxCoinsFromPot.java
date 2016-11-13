package MaxCoinsFromPot;

public class MaxCoinsFromPot {


    /*
    * There are n coins in a line. (Assume n is even). Two players take turns to take a coin from one
    * of the ends of the line until there are no more coins left. The player with the larger amount of money wins.
    * Would you rather go first or second? Does it matter?
    * Assume that you go first, describe an algorithm to compute the maximum amount of money you can win.
    *   http://articles.leetcode.com/coins-in-line/
    */

    public int choosePots(int[] pots){

        if(pots!=null && pots.length > 0) {
            int[][] max = new int[pots.length][pots.length];

            for (int i = pots.length - 1; i >= 0; i--) {
                max[i][i] = pots[i];
                for (int j = i+1; j < pots.length; j++) {

                    int[] opp = new int[]{max[i][j - 1], max[i + 1][j]};

                    if (opp[0] > opp[1]) {
                        max[i][j] = pots[i] + Math.min(i + 2 < pots.length ? max[i + 2][j] : 0, i + 1 < pots.length && j > 0 ? max[i + 1][j - 1] : 0);
                    } else {
                        max[i][j] = pots[j] + Math.min(i + 1 < pots.length && j > 0 ? max[i + 1][j - 1] : 0, j > 1 ? max[i][j - 2] : 0);
                    }

                }
            }

            return max[0][pots.length - 1];
        }

        return 0;

    }




}

