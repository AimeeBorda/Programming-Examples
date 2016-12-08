package dynamicProgramming.sudoku;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class SudokuSolver{

    private final int SIZE = 9 ;

    public byte[][] solveSudoku(byte[][] board){

        List<Byte> values = new ArrayList<>();

        BitSet[][] poss = transform(board, values);

        poss = recInsert(poss, values) ? solveSudoku(poss) : null;

        return getAndPrintBoard(poss);
    }

    private BitSet[][] solveSudoku(BitSet[][] poss) {

        if(!isSolved(poss)) {

            for (byte row = 0; row < SIZE; row++) {
                for (byte col = 0; col < SIZE; col++) {

                    if (poss[row][col].cardinality() > 1) {
                        //next empty cell and try all combinations
                        for (byte i = (byte) poss[row][col].nextSetBit(0); i >= 0; i = (byte) poss[row][col].nextSetBit(i + 1)) {
                            BitSet[][] possC = clone(poss);
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

    private BitSet[][] clone(BitSet[][] poss){
        BitSet[][] res = new BitSet[SIZE][SIZE];

        for(int r = 0 ; r< SIZE; r++){
            for(int c = 0 ; c < SIZE;c++){
                res[r][c] = new BitSet(SIZE);
                res[r][c].or(poss[r][c]);
            }
        }
        return res;
    }

    public BitSet[][] transform(byte[][] board, List<Byte> values) {
        BitSet[][] poss = new BitSet[SIZE][SIZE];

        for(byte row = 0; row < SIZE; row++) {
            for (byte col = 0; col < SIZE; col++) {
                poss[row][col] = new BitSet(SIZE);


                if(board[row][col] > 0){
                    poss[row][col].clear();
                    poss[row][col].set((byte) (board[row][col] - 1));

                    if(values != null)
                        values.add((byte) (row* SIZE + col));
                }else{
                    poss[row][col].set(0,SIZE,true);
                }

            }
        }

        return poss;
    }

    private byte[][] getAndPrintBoard(BitSet[][] poss) {

        byte[][] board = new byte[SIZE][SIZE];
        if(poss!= null) {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    if (poss[row][col].cardinality() == 1) {
                        board[row][col] = (byte) (poss[row][col].nextSetBit(0)+1);
                    }
                }
                System.out.println(Arrays.toString(board[row]));
            }
        }

        return board;
    }

    public boolean isSolved(BitSet[][] poss){

        for(byte r = 0 ; r < SIZE; r++){
            for(byte c = 0 ; c < SIZE; c++){
                if(poss[r][c].cardinality() > 1)
                    return false;
                else {
                    for (byte i = 0; i < SIZE; i++) {
                        byte b = (byte) (3 * (c / 3) + (i % 3));
                        byte b1 = (byte) (3 * (r / 3) + (i / 3));
                        if ((i != c && poss[r][i].nextSetBit(0) == poss[r][c].nextSetBit(0))
                            || (i != r && poss[i][c].nextSetBit(0) == poss[r][c].nextSetBit(0))
                            || ((r!= b1 || c!= b) && poss[b1][b].nextSetBit(0) == poss[r][c].nextSetBit(0)))
                            return false;
                    }
                }
            }
        }

        return true;

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

    private boolean insert(BitSet[][] poss,  byte row, byte col, List<Byte> values){
        if(poss[row][col].cardinality() == 1 ) {
            byte val = (byte) poss[row][col].nextSetBit(0);

            for (byte i = 0; i < SIZE; i++) {
                removePoss(poss, i, col, val, row, col,values);
                removePoss(poss, row, i, val, row, col,values);
                removePoss(poss, (byte) (3 * (row / 3) + (i / 3)), (byte) (3 * (col / 3) + (i % 3)), val, row, col,values);
            }

            return true;
        }

        return false;
    }

    private void removePoss(BitSet[][] poss, byte row, byte col, byte val, byte origRow, byte origCol, List<Byte> values){
        if((row != origRow || col != origCol) && poss[row][col].get(val)) {

            poss[row][col].clear(val);

            if (poss[row][col].cardinality() == 1) {
                values.add((byte)(row*SIZE + col));
            }

        }

    }

}
