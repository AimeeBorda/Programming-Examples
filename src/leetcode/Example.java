package leetcode;


import java.util.Arrays;
import java.util.HashMap;

public class Example {
    /*
     * Assume you are an awesome parent and want to give your children some cookies.
     * But, you should give each child at most one cookie. Each child i has a greed
     * factor gi, which is the minimum size of a cookie that the child will be content
     * with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j
     * to the child i, and the child i will be content. Your goal is to maximize the
     * number of your content children and output the maximum number.
     */
    public int cookieProblem(int[] child, int[] cookies) {
       //greedy approach if we assume that the lists are sorted

        if(child == null || child.length == 0 || cookies.length <= 0)
            return 0;

        Arrays.sort(child);
        Arrays.sort(cookies);


        int j = 0;
        int res = 0;

        for(int i = 0; i< child.length && j < cookies.length; i++){
            while(j < cookies.length && child[i] > cookies[j]){
                j++;
            }

            if(j < cookies.length){
                res++;
                j++;
            }
        }
        return res;
    }
    
    /* Given a non-empty string check if it can be constructed by taking a substring of it and
     * appending multiple copies of the substring together. You may assume the given string
     * consists of lowercase English letters only and its length will not exceed 10000.
     */
    public boolean repeatedSubstringPattern(String str) {
        //O(n/2)* n/2
        for(int i = 1; i <= str.length() / 2 && i > 0; i++){
            String substring = str.substring(0,i);
            if(str.length() % substring.length() == 0){
                if(new String(new char[str.length() / substring.length()]).replace("\0",substring).equals(str))
                    return true;
            }

        }
        return false;
    }



    /* Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence
     * ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes
     * a list of n numbers as input and checks whether there is a 132 pattern in the list.
     */


    public boolean pattern(int[] numbers){

        int[] min = new int[numbers.length];
        int[] max = new int[numbers.length];
        int[] minRev = new int[numbers.length];

        for(int i =0, j = numbers.length - 1; i < numbers.length ; i++,j--){
            if(i ==0){
                min[i] = numbers[i];
                minRev[j] = numbers[j];
                max[j] = numbers[j];
            } else {
                min[i]  = Math.min(min[i-1],numbers[i]);
                minRev[j] = Math.min(minRev[j + 1], numbers[j]);

                max[j] = Math.max(max[j+1],numbers[j]);
            }
        }

        for(int i = 1; i < numbers.length - 1; i++){
            if(min[i-1] < numbers[i] && minRev[i+1] < numbers[i]){
                if(min[i-1] < minRev[i+1]){
                    return true;
                }else if(min[i-1] < max[i+1]){
                    for(int j = i + 1; j < numbers.length ; j++){
                        if(numbers[j] < numbers[i] && numbers[j] > min[i])
                            return true;
                    }
                }
            }
        }

        return false;
    }

    /* Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are
     * such that A[i] + B[j] + C[k] + D[l] is zero.
     * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers
     * are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.
*/
    public int sum4(int[]as, int[]bs , int[]cs, int[]ds){
        HashMap<Integer,Integer> map = getSum2(as,bs);

        return  matchSum2(cs,ds,map);
    }

    //this should be returned sorted
    private HashMap<Integer,Integer> getSum2(int[] as, int[] bs){
        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for(int a : as){
            for(int b: bs) {
                int key = a + b;

                hashmap.put(key, hashmap.getOrDefault(key,0) + 1);
            }
        }

        return hashmap;
    }

    private int matchSum2(int[] as, int[] bs,HashMap<Integer,Integer> map){
        int count= 0;
        for(int a : as){
            for(int b: bs) {
                int v = a + b;
                count +=  map.getOrDefault(-v,0);

            }
        }

        return count;
    }
}
