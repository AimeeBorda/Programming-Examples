package MedianSortedArrays;

import java.util.Arrays;

public class Median {
    int len1,len2, pos1=0,pos2=0;
    int[] nums1, nums2;

    public double findMedianSortedArrays(int[] n, int[] m) {
        if(n == null || m == null || (n.length == 0) && m.length ==0)
            return 0;
        nums1 = n;
        nums2 = m;
        len1 = n.length;
        len2 = m.length;
        pos1=0;
        pos2=0;
        int totalLength = len1 + len2;
        int position = (totalLength / 2) - 1;

        while(position > 0){
            getNext();
            position--;
        }


        if(totalLength % 2 > 0){
            getNext();
            return getAtPos();
        }
        else{
            int md = getAtPos();
            getNext();
            int md2 = getAtPos();

            return ((double)md + md2)/2;
        }
    }

    private  int getAtPos(){

        if(pos1 >= len1 && len2 > 0)
            return nums2[Math.min(pos2,len2-1)];
        else if(pos2 >= len2 && len1 > 0)
            return nums1[Math.min(pos1,len1-1)];
        else
            return Math.min(nums1[pos1],nums2[pos2]);
    }

    private  void getNext(){
        if((pos2 >= len2) || (pos1 < len1 && nums1[pos1] <= nums2[pos2]) ){
            pos1++;
        }else{
            pos2++;
        }
    }


    private double getMedian(int[] a, int[] b, int as, int ae, int bs, int be){
        int lenA = l(ae, as);
        int lenB = l(be, bs);

        if(lenA + lenB <= 4){
            return medianBaseCase(a, b, as, ae, bs, be, lenA, lenB);
        }else {
            return medianInductiveCase(a, b, as, ae, bs, be, lenA, lenB);
        }
    }

    private double medianInductiveCase(int[] a, int[] b, int as, int ae, int bs, int be, int lenA, int lenB) {
        int ma = m(ae,as);
        int mb = m(be,bs);

        double medianA = lenA % 2 == 0 && ma < ae - 1 ? (a[ma-1] + a[ma]) /2.0 : lenA > 0 ?a[ma]:0;
        double medianB = lenB % 2 == 0 && mb < be - 1? (b[mb-1] + b[mb]) /2.0 : lenB > 0 ? b[mb] : 0;


        if(medianA < medianB){
//            int be1 = (&& lenB %2 > 0? (mb + 1) : (mb + 0)) ;
            int as1 = (lenB % 2) != (lenA % 2) ? ma + 1 : ma;
            int be1 = (lenB % 2) == (lenA % 2) ? mb : mb;
            return getMedian(a,b, as1,ae,bs, be1);
        }else{
//            int ae1 = ((lenB % 2) == (lenA % 2) && lenA % 2 > 0? (ma + 1) : (ma + 0)) ;
            int bs1 = (lenB % 2) != (lenA % 2) ? mb + 1 : mb;
            int ae1 =  (lenB % 2) == (lenA % 2) ? ma  : ma;
            return getMedian(a,b,as, ae1, bs1,be );
        }
    }

    private double medianBaseCase(int[] a, int[] b, int as, int ae, int bs, int be, int lenA, int lenB) {
//        if((lenA + lenB) % 2 == 0){
            int[] res = new int[lenA + lenB];
            for(int i = 0 ; i < lenA; i++){
                res[i] = a[as + i];
            }

            for(int i = 0 ; i < lenB; i++){
                res[i+lenA] = b[bs + i];
            }

            Arrays.sort(res);

            if(res.length %2 == 0 && res.length >0){
                return (res[res.length / 2 - 1] + res[(res.length / 2)]) /2.0;
            }else if(res.length > 0){
                return res[res.length /2];
            }else {
                return 0;
            }
//            int middle = Math.min(Math.max(minA,minB), Math.min(maxA,maxB));
//
//            return ;//(Math.max(Math.min(minA,minB)) + Math.min(maxA,maxB)) / 2;
//            int elem1 = lenA > 0 ? a[as] : 0;
//            elem1 = lenB > 0 ? Math.max(b[bs],elem1) : elem1;
//            int elem2 = lenA > 0 ? a[ae - 1] : Integer.MAX_VALUE;
//            elem2 = lenB > 0 ? Math.min(b[be - 1],elem2) : elem2;
//            elem2 = elem2 == Integer.MAX_VALUE ? 0 : elem2;

//            return (elem1 + elem2)/2.0;
//        } else{
//            int elem1 =  lenA > 0 ? a[as] : b[bs];
//            int elem3 =  lenA > 1 || lenB > 1? Math.min(a[ae -1], b[be-1]) : 0;
//
//            return Math.max(elem1, elem3);
//        }
    }


    public double getMedian(int[] a, int[] b) {
        return getMedian(a,b,0,a.length,0,b.length);
    }

    private int m(int ae, int as) {
        return (ae - as)/2 + as;
    }

    private int l(int ae, int as) {
        return ae - as;
    }


}