package dynamicProgramming.quickSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given a string of digits, find the minimum number of additions required for the string
    to equal some target number. Each addition is the equivalent of inserting a plus sign
    somewhere into the string of digits. After all plus signs are inserted, evaluate the
    sum as usual. For example, consider the string "12" (quotes for clarity). With zero
    additions, we can achieve the number 12. If we insert one plus sign into the string,
    we get "1+2", which evaluates to 3. So, in that case, given "12", a minimum of 1 addition
    is required to get the number 3. As another example, consider "303" and a target sum of 6.
    The best strategy is not "3+0+3", but "3+03". You can do this because leading zeros do not
    change the result.
    Write a class QuickSums that contains the method minSums, which takes a String numbers and
    an int sum. The method should calculate and return the minimum number of additions required
    to create an expression from numbers that evaluates to sum. If this is impossible, return -1.
    */
public class QuickSum {

     public int quickSums(String digits, int target){
         List<String> res = new ArrayList<>();
         quickSumsStr(digits, target, res);

         return res.stream()
                    .filter(s -> compute(s) == target)
                    .map(v -> v.split("\\+").length - 1)
                    .reduce(-1, (ex,v) -> ex < 0 ? v : Math.min(ex,v) );
     }

     private void quickSumsStr(String digits, int target, List<String> res) {

         if(digits.length() > 1){
             List<String>  res1 = new ArrayList<>();
             List<String> res2 = new ArrayList<>();

             quickSumsStr(digits.substring(0, digits.length() / 2), target,res1);
             quickSumsStr(digits.substring(digits.length()/2, digits.length()), target,res2);

              merge(res1, res2, res, target);
         }else{
             res.add(digits);
         }

     }


     private void merge(List<String> res1, List<String> res2, List<String> res, int target){
         for(String frm1 : res1){
             for(String frm2 : res2){
                 int frmPlus = compute(frm1 + "+" + frm2);
                 int frmConcat = compute(frm1 + frm2);
                 if(frmPlus <= target){
                     res.add(frm1 +"+"+frm2);
                 }
                 if(frmConcat <= target){
                     res.add(frm1 + frm2);
                 }
             }
         }

     }


     private int compute(String frm){
         return Arrays.stream(frm.split("\\+")).mapToInt(Integer::parseInt).sum();
     }
}
