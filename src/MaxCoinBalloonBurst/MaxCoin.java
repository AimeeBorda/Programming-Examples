package  MaxCoinBalloonBurst;

/* https://leetcode.com/problems/burst-balloons/
 *
 * Given N balloons, if you burst ith balloon you get Ai−1∗Ai∗Ai+1 coins and then (i-1)th and (i+1)th
 * balloons become adjacent. Find maximum number of coins you can gather.
 * Assume that we have extra 1 at left most and right most positions. (don't take in answer just for boundary positions)
 * Hence if we have left or right boundary positions we multiply 1
 *
 */
public class MaxCoin {

    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for(int end = 0; end < nums.length; end++){
            dp[end][end] = n(nums, end - 1) * n(nums, end) * n(nums, end + 1);
            for(int start = end - 1; start >= 0;start--){
                //value is we burst the balloon in the jth pos

                for(int pos = start; pos <= end;pos++){

                    int val =   (pos > 0 ? dp[start][pos-1] : 0)
                                + (pos < nums.length -1? dp[pos+1][end] : 0)
                                + (n(nums,pos)* n(nums,end+1) * n(nums,start-1));

                    dp[start][end] = Math.max(dp[start][end],val);
                }
            }
        }
       return dp[0][nums.length-1];
    }


    public int n(int[] nums, int i) {
        return i < nums.length && i >=0? nums[i] : 1;
    }

}