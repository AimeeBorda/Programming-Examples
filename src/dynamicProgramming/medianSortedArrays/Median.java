package dynamicProgramming.medianSortedArrays;

import java.util.Arrays;

public class Median {

    public double getMedian(int[] a, int[] b){

        if(a.length + b.length <= 4){
            return medianBaseCase(a, b);
        }else {
            return medianInductiveCase(a, b);
        }
    }

    private double medianInductiveCase(int[] a, int[] b) {
        System.out.println("A: " + Arrays.toString(a) +",B: "+ Arrays.toString(b));

        double ma = m(a);
        double mb = m(b);
        if(ma == mb){
            return ma;
        }
        if(ma < mb){
            a = Arrays.stream(a).skip(a.length / 2).toArray() ;
            b = Arrays.stream(b).limit(b.length / 2 + (b.length % 2 == 0 ?0:1)).toArray() ;

            return getMedian(a,b);
        }else{
            a = Arrays.stream(a).limit(a.length / 2 + (a.length % 2 == 0 ?0:1)).toArray() ;
            b = Arrays.stream(b).skip(b.length / 2).toArray() ;
            return getMedian(a,b);
        }
    }

    private double medianBaseCase(int[] a, int[] b) {
        System.out.println("A: " + Arrays.toString(a) +",B: "+ Arrays.toString(b));
        int[] res = new int[a.length + b.length];

        System.arraycopy(a,0,res,0,a.length);
        System.arraycopy(b,0,res,a.length,b.length);

        Arrays.sort(res);

        return m(res);
    }

    private double m(int[] list) {

        if(list.length > 0){
            return list.length % 2== 0 ?(list[list.length/2] + list[(list.length /2) - 1])/2.0 : list[list.length / 2];
        }

        return 0;
    }

}