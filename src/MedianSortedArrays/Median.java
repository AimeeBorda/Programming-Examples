package MedianSortedArrays;

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
}