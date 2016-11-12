package MaxCoinsFromPot;

public class MaxCoinsFromPot {

    int[] max;
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
    private void choosePot(int[] pots,  int i){
        if(i == 0){
            max[0] = pots[0];
        }else {
//            max[i] = Math.max()

        }
    }

    public int choosePots(int[] pots){
        max = new int[pots.length];

        for(int i = 0 ; i < pots.length; i++){
            choosePot(pots, i);
        }

        return max[pots.length - 1];

    }




}

