package CakeThief;

public class CakeThief {


   int[][] max;

    public int dynamicProg(Pair<Integer, Integer>[] cakes, int capacity) {
        if(cakes == null || cakes.length == 0 || capacity <= 0)
            return 0;

        max = new int[cakes.length][capacity + 1];

        //O(n*W*W)
        for(int i = 0 ; i < cakes.length; i++){
            for(int j = 1; j <= capacity;j++) {
                getMaxWith(cakes, j, i);
            }
        }
        return max[cakes.length - 1][capacity];
    }

    private Pair<Integer, Integer> findClosestPair(Pair<Integer, Integer>[] ans2, Pair<Integer, Integer> p, int capacity) {
        int index = ans2.length / 2;
        Pair<Integer,Integer> res = new Pair<Integer, Integer>(0,0);
        while(index < ans2.length){
            if(ans2[index].first + p.first <= capacity){

            }
            index++;
        }

        return new Pair<Integer, Integer>(0,0);
    }


    public <T extends Comparable,K extends Comparable> void sort(Pair<T, K>[] cakes, int bottom, int top) {

        if(bottom  < top){
            int middle = (top - bottom) / 2;

            sort(cakes, bottom, bottom + middle);
            sort(cakes, bottom + middle + 1, top);

            merge(cakes, bottom, top);
        }
    }

    private <T extends Comparable,K extends Comparable> void merge(Pair<T, K>[] cakes,  int b, int t) {
        int m = ((t - b) / 2) + b;
        int s =  m + 1;

        while(b <=  m && s <= t){
            if(cakes[b].first.compareTo(cakes[s].first) > 0){
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


    private void getMaxWith(Pair<Integer,Integer>[] cakes, int j, int i){
        Pair<Integer,Integer> current = cakes[i];
        for(int n = 0; n <= j / current.first; n++) {
            int option = max[i > 0? i-1:0][j - n * current.first] + n * current.second;
            max[i][j] = Math.max(option, max[i][j]);
        }

    }

}
