package largestPrimeProduct;

import java.util.ArrayList;
import java.util.List;

public class LargestPrimeFactor {


    public static void main(String[] args){
//        largestPrimeFactor(600851475143l);

        System.out.println(largeProductPalindrome());
    }


    private static int largeProductPalindrome(){
        ArrayList<Integer> l = new ArrayList<>();
        int t = 9;
        while(l.isEmpty()) {
            for (int i = (t+1)*100- 1; i >= t*100; i--) {
                for (int j = (t+1)*100- 1; j >= t*100; j--) {
                    if (isPalindrome(i * j))
                        l.add(i * j);
                }
            }

            t--;

        }
        l.sort(Integer::compare);
        return l.get(l.size() -1);
    }

    private static boolean isPalindrome(int number){
        String str = String.valueOf(number);

        int len = str.length();
        for(int i = 0; i < len /2; i++){
            if(str.charAt(i) != str.charAt(len - i - 1))
                return false;

        }
        return true;
    }

    public static void largestPrimeFactor(long number){
        List<Integer> primes = new ArrayList<Integer>();
        int sq = (int) Math.floor(Math.sqrt(number));

        boolean isPrime;
        for(int i = 2; i <= sq;i++){
            isPrime = true;
            for(Integer p : primes ){
                if(i % p == 0)
                    isPrime = false;
            }
            //otherwise it is a pri

            if(isPrime) {
                while (number % i == 0)
                    number /= i;

                primes.add(i);
            }

            if(number < primes.get(primes.size()- 1))
                break;
        }
        System.out.println(primes.get(primes.size() - 1));

    }
}
