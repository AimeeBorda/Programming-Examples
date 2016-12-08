package dynamicProgramming.sudoku;


import java.util.Arrays;
import java.util.BitSet;

public class SudokuSolver{

    private final int SIZE = 9 ;

    public byte[][] solveSudoku(byte[][] board){
        BitSet[][] poss = new BitSet[SIZE][SIZE];

        for(byte row = 0; row < SIZE; row++) {
            for (byte col = 0; col < SIZE; col++) {
                poss[row][col] = new BitSet(SIZE);
                poss[row][col].set(0,SIZE,true);

            }
        }
        return solveSudoku(board, poss);
    }


    public byte[][] solveSudoku(byte[][] board, BitSet[][] poss) {

        for(byte row = 0; row < SIZE; row++){
            for(byte col = 0; col < SIZE; col++){

                if(board[row][col] != 0)
                    insert(poss, row, col, (byte) (board[row][col] - 1));
            }
        }



        return getAndPrintBoard(solveBackTracking(poss));

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


    public BitSet[][] solveBackTracking(BitSet[][] poss){


        if(!isSolved(poss)) {


            for (byte row = 0; row < SIZE; row++) {
                for (byte col = 0; col < SIZE; col++) {
                    if (poss[row][col].cardinality() > 1) {
                        byte i = -1;

                        while((i = (byte)poss[row][col].nextSetBit(i+1)) >= 0){
                            BitSet[][] possC = poss.clone();
                            System.out.print("trying "+i +" in "+row+" "+col);
                            insert(possC, row, col,  i);
                            System.out.println(" and now back-tracking");

                            if(isSolved(solveBackTracking(possC)))
                                return possC;
                        }


                    }
                }
            }
        }

        return poss;
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

    private boolean insert(BitSet[][] possibilities,  byte row, byte col, byte val){
        boolean res = possibilities[row][col].cardinality() > 0 && possibilities[row][col].get(val);

        possibilities[row][col].clear(0,SIZE);
        possibilities[row][col].set(val);

        for(byte i = 0 ; i < SIZE; i++){
            clearPossibility(possibilities, i, col, val, row, col);
            clearPossibility(possibilities, row, i, val, row, col);
            clearPossibility(possibilities, (byte)(3*(row/3) + (i/3)),(byte) (3*(col/3) + (i%3)), val, row, col);
         }



        return res;
    }

    private void clearPossibility(BitSet[][] possibilities, byte row, byte col, byte val, byte cellR, byte cellC) {
        if(row != cellR && col != cellC) {
            try {
                possibilities[row][col].clear(val);
            }catch(StackOverflowError e){
                System.out.println(row +" "+col+" "+val+" "+ cellR+" "+cellC+" "+val);
            }
            //if only one possibility remains - add it to the board and restart process.
            if (possibilities[row][col].cardinality() == 1) {
                insert(possibilities, row, col, (byte) possibilities[row][col].nextSetBit(0));
            }
        }

    }


}
