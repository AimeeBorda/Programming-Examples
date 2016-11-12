package duplicates;


public class Duplicates {

    //assume that values are +ve
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
