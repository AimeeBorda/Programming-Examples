package regularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions
{

    public boolean isPrime(int n){
        return !new String(new char[n]).matches(".?|(..+?)\\1+");
    }

    public boolean langN(String str){
        // is it of the form a^nb^n
        return Pattern.compile("(?x)(?:a(?= a*(\\1?+b)))*\\1?+").matcher(str).matches();
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
        Matcher m = Pattern.compile("(\\s*)(\\S+\\s?)").matcher(str);

        return m.replaceAll("$2");
    }

    public boolean isNumber(String s){
        return Pattern.compile("^\\d*(\\.\\d*)?\\d(e\\d+)?").matcher(s).matches();
    }

    public String[] commaSeparated(String str){
        return Pattern.compile(",(<! (?: \".*\")*\")").split(str);
     }

    private boolean notEmpty(String s){
        return s != null && !s.isEmpty();
    }

    public boolean matchDate(String date) {
        return date.matches("^[12]\\d{3}-(0[0-9]|1[0-2])-([0-2][0-9]|3[0-1]) \\d{2}:\\d{2}:\\d{2}(?:.\\d+)?$");
    }

    public boolean hasMatchingParanthesis(String expr){
        return expr.replaceAll("[^()]","").replaceAll("\\(\\)","").length() == 0;
    }
}