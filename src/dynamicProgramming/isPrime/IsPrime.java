package dynamicProgramming.isPrime;


public class IsPrime {

    boolean[] notPrimes;
    public boolean isPrime(int i) {
        int middle = (int) Math.ceil(i / 2);
        notPrimes = new boolean[middle + 1];

        int j = 2;

        while(j <= middle){
            if(i % j ==0)
                return false;
            j = nextPrime(j + 1);
        }
        return true;
    }


    private int nextPrime(int j) {
        while(j < notPrimes.length){
            boolean isPrime = true;
            for(int k = 2 ; k < j && isPrime; k++){
                if(notPrimes[k] && j % k == 0) {
                    isPrime = false;
                }
            }

            if(isPrime) {
                notPrimes[j] = false;
                return j;
            }else
                j++;
        }


        return Integer.MAX_VALUE;
    }
}
