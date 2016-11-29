package dynamicProgramming.primeNumbers;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PrimeNumbersSubstring {

    public String findSubstring(String n){
        ArrayList<Integer> list = new ArrayList<Integer>(){{add(2); add(3);}};
        StringBuffer primeNumbers =  new StringBuffer("23");
        for(int i = 5; i < Integer.MAX_VALUE; i++){
            int ii = i;
            if(!list.parallelStream().anyMatch(p -> (ii % p == 0))){
                list.add(i);
                primeNumbers.append(i);

                int index = primeNumbers.indexOf(n);
                if(index >= 0 && primeNumbers.length() - index > 5){
                    return primeNumbers.substring(index,index+5);
                }
            }
        }

        return null;
    }

    @Test
    public void test(){
        assertEquals("prime numbers find","71113",findSubstring("711"));
        assertEquals("prime numbers find","98737",findSubstring("98737"));
    }
}
