package fibonacci;

public class Fibonacci {

    public int fib(int i) {
       int[] stack = new int[]{1,0};
        for(int j = 0; j < i ;j++){
            int val1 = stack[0];
            int val2 = stack[1];
            stack[1] = val1;
            stack[0] = val1 + val2;
        }
        return stack[1];
    }
}
