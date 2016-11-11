package NextLargerElement;

import java.util.Arrays;

/*
* Given an int array A, return an int array B that A[i + B[i]] is the first element in * A after A[i] that is greater than or equal to A[i]
*/
public class ArrayExample{


    public int[] arrayEx(int[] A){
        int[] B = new int[A.length];
        Arrays.fill(B,-1);

        for(int i = 0 ; i < A.length; i++){
            int j = i + 1;
            while(j < A.length){
                if(A[i] <= A[j]) {
                    B[i] = j - i;
                    break;
                }
                j++;
            }
        }

        return B;
    }
}
