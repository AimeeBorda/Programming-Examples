package dynamicProgramming.duplicates;


public class Duplicates {

    //https://www.careercup.com/question?id=5719799180034048
    //https://leetcode.com/problems/find-the-duplicate-number/
    public int findDuplicate(int[] arr){

    if(arr != null) {
        for (int i = 0; i < arr.length; i++) {
            int loc = Math.abs(arr[i]) - 1;
            if (arr[loc] < 0)
                return arr[i];
            else
                arr[loc] *= -1;

        }
    }

        return -1;
    }
}
