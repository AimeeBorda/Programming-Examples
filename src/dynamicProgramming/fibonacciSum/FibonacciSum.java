package dynamicProgramming.fibonacciSum;

/**
 * Depicted below is the Fibonacci sequence:
 *      1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
 * As you can see, each value from 2 on is the sum of the previous two values. Any positive integer can be written as a
 * sum of values taken from the Fibonacci sequence. These values need not be distinct. Return the smallest number of
 * such values that sum to n.
 */
public class FibonacciSum {


    public int howMany(int num) {
        if(num < 4)
            return 1;
        else {
            int[] fib = new int[num];

            fib[0] = 1;
            fib[1] = 1;

            int index = 2, value = 2;
            while (value <= num) {
                fib[index] = value;
                index++;
                value = fib[index - 1] + fib[index - 2];
            }

            value = 0;
            while (num > 0) {

                while (fib[index] == 0 || fib[index] > num)
                    index--;

                value += num / fib[index];
                num = num % fib[index];
            }
            return value;
        }
    }


}
