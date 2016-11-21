package dynamicProgramming.AB;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You are given two ints: N and K. Lun the dog is interested in strings that satisfy the following conditions:

 The string has exactly N characters, each of which is either 'A' or 'B'.
 The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
 If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string
 */
public class AB {

    public String createString(int N, int K) {
        String res = new String(new char[N]).replace("\0","B");

        while(K > N){
            res = res.replaceFirst("B","A");
            K -= (N - 1);
            N--;
        }

        if(K > 0){
            if(N - K >= 1){

                Matcher matcher = Pattern.compile("(.{" + (N - K - 1) + "})B").matcher(res);
                res = matcher.find()? matcher.replaceFirst("$1A") : "";
            }else{
                return "";
            }
        }

        return res;
    }
}
