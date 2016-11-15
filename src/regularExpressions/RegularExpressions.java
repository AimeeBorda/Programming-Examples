package regularExpressions;

import java.util.List;
import java.util.regex.*;
import java.util.*;

public class RegularExpressions
{

    public void isPrime(int number){

    }

    public boolean langN(String str){
        // is it of the form a^nb^n
        return Pattern.compile("^(a*)(b)\\1$").matcher(str).find();
    }

    public List<Integer> extractNumbers(String str){
        Matcher m = Pattern.compile("\\d+").matcher(str);
        List<Integer> res = new ArrayList<>();
        while(m.find()){
            res.add(Integer.parseInt(m.group()));
        }
        return res;
    }

    public String[] splitNewLine(String str){
        return Pattern.compile("\\n").split(str);
    }

    public String deleteExtraAndLeadingSpacesOnly(String str){
        StringBuffer buffer = new StringBuffer();
        Matcher m = Pattern.compile("(\\s{2,}\\w)*(\\s*)$").matcher(str);

        while(m.find()) {
            m.appendReplacement(buffer, " ");
        }

        return buffer.toString();
    }
}