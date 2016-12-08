package dynamicProgramming.sudoku;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class SudokuSolver{

    private final int SIZE = 9 ;

    public byte[][] solveSudoku(byte[][] board){
        BitSet[][] poss = new BitSet[SIZE][SIZE];

        List<Byte> values = new ArrayList<>();
        for(byte row = 0; row < SIZE; row++) {
            for (byte col = 0; col < SIZE; col++) {
                poss[row][col] = new BitSet(SIZE);


                if(board[row][col] > 0){
                    poss[row][col].clear();
                    poss[row][col].set((byte) (board[row][col] - 1));
                    values.add((byte) (row* SIZE + col));
                }else{
                    poss[row][col].set(0,SIZE,true);
                }

            }
        }

        recInsert(poss, values);
        return getAndPrintBoard(solveSudoku(poss));
    }

    private boolean recInsert(BitSet[][] poss, byte val, byte row, byte col){
        poss[row][col].clear();
        poss[row][col].set(val);
        List<Byte> values = new ArrayList<Byte>(){{add((byte) (row*SIZE + col));}};

        return recInsert(poss, values);
    }

    private boolean recInsert(BitSet[][] poss, List<Byte> values) {

        boolean res = true;
        while(!values.isEmpty()){

            Byte[] temp = values.toArray(new Byte[]{});
            values.clear();
            for(Byte cell : temp){
                res &= insert(poss,(byte)(cell / SIZE),(byte)(cell % SIZE), values);
            }
        }

        return res;
    }


    public BitSet[][] solveSudoku(BitSet[][] poss) {

        if(!isSolved(poss)) {

            for (byte row = 0; row < SIZE; row++) {
                for (byte col = 0; col < SIZE; col++) {

                    if (poss[row][col].cardinality() > 1) {
                        //next empty cell and try all combinations
                        for (byte i = (byte) poss[row][col].nextSetBit(0); i >= 0; i = (byte) poss[row][col].nextSetBit(i + 1)) {
                            BitSet[][] possC = poss.clone();
                            if(recInsert(possC, i, row, col) && (possC = solveSudoku(possC)) != null)
                                return possC;
                        }
                        return null;
                    }
                }
            }

            return null;
        }

        return poss;

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


    private boolean isSolved(BitSet[][] board){

        for(BitSet[] r : board) {
            for (BitSet c : r) {
                if (c.cardinality() != 1)
                    return false;
            }
        }
        return true;
    }

    private boolean insert(BitSet[][] poss,  byte row, byte col, List<Byte> values){
        if(poss[row][col].cardinality() > 0){
             return insert(poss,row,col, (byte)poss[row][col].nextSetBit(0), values);
        }

        return false;
    }

    private boolean insert(BitSet[][] possibilities,  byte row, byte col, byte val, List<Byte> values){
        if(possibilities[row][col].cardinality() > 0 && possibilities[row][col].get(val)) {

            possibilities[row][col].clear();
            possibilities[row][col].set(val);

            for (byte i = 0; i < SIZE; i++) {
                removePoss(possibilities, i, col, val, row, col,values);
                removePoss(possibilities, row, i, val, row, col,values);
                byte r = (byte) (3 * (row / 3) + (i / 3));
                byte c = (byte) (3 * (col / 3) + (i % 3));
                removePoss(possibilities, r, c, val, row, col,values);
            }

            return true;
        }

        return false;
    }

    private void removePoss(BitSet[][] poss, byte row, byte col, byte val, byte origRow, byte origCol, List<Byte> values){
        if(row != origRow && col != origCol && poss[row][col].get(val)) {

            poss[row][col].clear(val);

            if (poss[row][col].cardinality() == 1) {
                values.add((byte)(row*SIZE + col));
            }
        }
    }

}
