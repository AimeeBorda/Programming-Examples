package  MaxCoinBalloonBurst;


public class MaxCoin {

    //get rid from smallest to largest 
    public int maxCoins(int[] nums) {
        int smallest = 0;
        int coins = 0;
        int nextSmallest = Integer.MAX_VALUE;
        int count = 0;
        for(int j = 0;j <= 500 && smallest <=500;j++){
            for(int i = 0;i < nums.length;i++){
                if(nums[i] == smallest){
                    coins += getCoins(nums,i);
                    System.out.print(nums[i]+" ");
                    nums[i] = -1;
                    count++;
                }

                nextSmallest = getSmallest(nextSmallest,nums,i,count,smallest);
            }
            smallest = nextSmallest;
            nextSmallest = Integer.MAX_VALUE;
        }

        return coins;
    }

    private int getCoins(int[] nums, int i){
        return nums[i] * getNext(nums,i) * getPrev(nums,i);
    }

    private int getNext(int[] nums,int i){
        i = i + 1;
        while(i < nums.length && nums[i] < 0){
            i++;
        }

        return i < nums.length?nums[i]:1;
    }

    private int getPrev(int[] nums,int i){
        i = i - 1;
        while(i >= 0 && nums[i] < 0){
            i--;
        }

        return i >= 0 ?nums[i]:1;
    }

    public int getSmallest(int nextSmallest, int[] nums, int i, int count,int smallest){

        boolean isFirst = true, isLast = true;
        for(int j = 0; j < i ; j++){
            if(nums[j] > 0 && nums[j] != smallest){
                isFirst = false;
                break;
            }

        }

        for(int j = i+1; j < nums.length ; j++){
            if(nums[j] > 0 && nums[j] != smallest){
                isLast = false;
                break;
            }
            if(nums[j] == smallest)
                count++;
        }

        if(((isFirst  || isLast) && (nums.length - count) > 2) || nums[i] < 0){
            return nextSmallest;
        }
        else{
            return Math.min(nextSmallest,nums[i]);
        }
    }
}