package CakeThief;

public class CakeThief {

    //assume the cakes are sorting desc
    public int maxValue(Pair<Integer, Integer>[] cakes, int capacity) {


        sortDescending(cakes,0,cakes.length - 1);

        // for every pair if there exists a pair that can
        // either offer less weight for same value or more value for same weight
        // remove the element
        int total = 0;
        for(int i = 0 ; i < cakes.length ; i++){
           Pair<Integer,Integer>[] pairs = getMaxWith(cakes, capacity, i);
            total = Math.max(total(pairs), total);
        }
        return 0;
    }

    public <T extends Comparable,K extends Comparable> void sortDescending(Pair<T, K>[] cakes,  int bottom, int top) {

        if(bottom  < top){
            int middle = (top - bottom) / 2;

            sortDescending(cakes, bottom, bottom + middle);
            sortDescending(cakes, bottom + middle + 1, top);

            merge(cakes, bottom, top);
        }
    }

    private <T extends Comparable,K extends Comparable> void merge(Pair<T, K>[] cakes,  int b, int t) {
        int m = ((t - b) / 2) + b;
        int s =  m + 1;

        while(b <=  m && s <= t){
            if(cakes[b].first.compareTo(cakes[s].first) < 0){
                //we don't swap we
                shift(cakes, b, s);
                b++; s++;
            } else{
                b++;
            }
        }
    }

    private <T,K> void shift(Pair<T, K>[] cakes,  int start, int end){
        Pair<T,K> temp = cakes[end];
        for(int i = end ; i > 0 && i > start;i--){
            cakes[i] = cakes[i-1];
        }

        cakes[start] = temp;
    }

    private int total(Pair<Integer,Integer>[] cakes){
        int total = 0;
        for(Pair p : cakes){
            total +=  (int)p.second;
        }

        return total;
    }
    private Pair<Integer,Integer>[]getMaxWith(Pair<Integer,Integer>[] cakes, int capacity, int index){
        return null;

    }

}
