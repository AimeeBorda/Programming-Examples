package MaxCoinsFromPot;

public class MaxCoinsFromPot {
    private boolean chooseBottom(int[] pots, int bottom, int top){
        if(pots[bottom] > pots[top])
            return true;
        else if(pots[bottom] < pots[top])
            return false;
        else if(bottom + 1 < top -1) {
            //return where the next one is the smallest
            return pots[bottom + 1] < pots[top - 1];
        } else
            return true;
    }


    public int choosePots(int[] pots){
        int score = 0;

        if(pots != null) {
            int bottom = 0;
            int top = pots.length - 1;
            boolean myTurn = true;

            while (bottom < top) {
                if (chooseBottom(pots, bottom, top)) {
                    score += myTurn ? pots[bottom] : 0;
                    bottom++;
                } else {
                    score += myTurn ? pots[top] : 0;
                    top--;
                }

                myTurn = !myTurn;
            }
        }

        return score;
    }




}

