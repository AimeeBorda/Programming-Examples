import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by aimeeborda on 24/02/2017.
 */
public class ChapmanPuzzle {
    static int inversions(int[] p, int low, int high) { // inversions in p[low..high-1]
        int result = 0;
        for (int i = low; i < high; i = i + 1)
            for (int j = i + 1; j < high; j = j + 1)
                if (p[i] > p[j])
                    result = result + 1;
        return result;
    } // inversions

    static boolean even_perm(int[] p) {
        return p != null && inversions(p, 0, p.length) % 2 == 0;
    } // even


    static boolean isSolvable(int[] p) {
        return even_perm(p);
    }

    static boolean isSolved(int[] p) {
        if (p == null) return false;

        for (int i = 1; i < p.length; i++) {
            if (p[i - 1] > p[i])
                return false;
        }

        return true;
    }

    public static void solve() {

        LinkedList<Integer> list1 = new LinkedList<Integer>();

        list1.add(5);
        list1.add(6);
        list1.add(8);
        list1.add(15);
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(7);
        LinkedList<Integer> res = new LinkedList<Integer>();


        ListIterator iterA = list1.listIterator();
        ListIterator iterB = list2.listIterator();

        Integer num1 = null,num2 = null;
        while(iterA.hasNext() || iterB.hasNext()){
            num1 = num1 == null && iterA.hasNext() ? (Integer) iterA.next() : num1;
            num2 = num2 == null && iterB.hasNext() ? (Integer) iterB.next() : num2;

            if(num1 == null || (num2 != null && num1 > num2)){
                res.add(num2);
                num2 = null;
            } else {
                res.add(num1);
                num1 = null;
            }
        }


        System.out.println(Arrays.toString(res.toArray()));
    }



        /**
     * Method to produce a number corresponding to first k digits of the digits array
     * @param digits
     * @param k number of digits to construct the result from
     * @return number
     */
    public int getFirstKDigitNumber(int[] digits, int k) {
        // TODO: Implement
        return -1;
    }

    /**
     * Method to check if the specified number is divisible by the divisor
     * @param number
     * @param divisor
     * @return true if number is divisible by the divisor
     */
    public boolean isDivisible(int number, int divisor) {
        // TODO: Implement
        return false;
    }

    /**
     * Method to return a list containing all self divisible numbers found
     * @return 9-digit self divisible numbers
     */
    public List<Integer> getSelfDivisibleNumbers() {
        // TODO: Implement
        return null;
    }

    /**
     * Method to return the number of self divisible numbers found
     * @return number of 9-digit self divisible numbers
     */
    public int getNumberOfSelfDivisibleNumbers() {
        // TODO: Implement
        return -1;
    }
}
