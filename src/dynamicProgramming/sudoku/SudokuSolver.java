package dynamicProgramming.sudoku;


import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.*;

public class SudokuSolver extends RecursiveAction{

    private final int SIZE = 9 ;
    private BitSet[][] poss;

    public SudokuSolver(BitSet[][] poss){
        this.poss = poss;
    }

    public SudokuSolver(){
        poss = new BitSet[SIZE][SIZE];

        for(byte row = 0; row < SIZE; row++) {
            for (byte col = 0; col < SIZE; col++) {
                poss[row][col] = new BitSet(SIZE);
                poss[row][col].set(0,SIZE,true);

            }
        }
    }

    public byte[][] solveSudoku(byte[][] board) {

        for(byte row = 0; row < SIZE; row++){
            for(byte col = 0; col < SIZE; col++){

                if(board[row][col] != 0)
                    insert(poss, row, col, board[row][col]);
            }
        }

        ForkJoinPool pool = new ForkJoinPool();

        BitSet[][] res = poss.clone();
        pool.invoke(new SudokuSolver(res));

        pool.shutdown();
        return getAndPrintBoard(res);

    }

    private byte[][] getAndPrintBoard(BitSet[][] poss) {
        byte[][] board = new byte[SIZE][SIZE];

        for(int row =0 ; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(poss[row][col].cardinality() == 1){
                    board[row][col] = (byte) (SIZE - poss[row][col].nextSetBit(0));
                }
            }
            System.out.println(Arrays.toString(board[row]));
        }

        return board;
    }

    @Override
    public void compute(){
        if(!isSolved(poss)) {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    if (poss[row][col].cardinality() > 1) {
                        for (int i = poss[row][col].nextSetBit(0); i >= 0; i = poss[row][col].nextSetBit(i + 1)) {
                            BitSet[][] possC = poss.clone();
                            if (insert(possC, row, col, (short) (SIZE - i))) {
                                invokeAll(new SudokuSolver(possC));
                            }
                        }
                    }
                }
            }
        }
    }
    private boolean isSolved(BitSet[][] board){

        for(BitSet[] r : board) {
            for (BitSet c : r) {
                if (c.cardinality() != 1)
                    return false;
            }
        }
        return true;
    }

    private void printBoard(byte[][] board){
        Arrays.stream(board).forEach(r-> System.out.println(Arrays.toString(r)));
    }

    private boolean insert(BitSet[][] possibilities,  int row, int col, short val){
        boolean res = true;
        possibilities[row][col].clear(0,SIZE);


        for(byte i = 0 ; i < SIZE; i++){
            res &= clearPossibility(possibilities, i, col, val);
            res &= clearPossibility(possibilities, row, i, val);
            res &= clearPossibility(possibilities, 3*(row/3) + (i/3), 3*(col/3) + (i%3), val);
         }

        possibilities[row][col].set(val);

        return res;
    }

    private boolean clearPossibility(BitSet[][] possibilities, int row, int col, short val) {
        boolean res = !possibilities[row][col].get(val);
        possibilities[row][col].clear(val);

        //if only one possibility remains - add it to the board and restart process.
        if (possibilities[row][col].cardinality() == 1) {
            res &= insert(possibilities, row, col, (short) (SIZE - possibilities[row][col].nextSetBit(0)));
        }

        return res;
    }


}
