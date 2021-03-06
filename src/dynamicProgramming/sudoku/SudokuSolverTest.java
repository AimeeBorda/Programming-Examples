package dynamicProgramming.sudoku;

import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.*;


public class SudokuSolverTest {

    SudokuSolver s;

    @Before
    public void setUp(){
        s = new SudokuSolver();
    }


    @Test
    public void testBoard1(){
        byte[][] board = {
        {8,6,0,0,2,0,0,0,0},
        {0,0,0,7,0,0,0,5,9},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,6,0,8,0,0},
        {0,4,0,0,0,0,0,0,0},
        {0,0,5,3,0,0,0,0,7},
        {0,0,0,0,0,0,0,0,0},
        {0,2,0,0,0,0,6,0,0},
        {0,0,7,5,0,9,0,0,0}};

        s.solveSudoku(board);
    }

    @Test
    public void testBoard2(){
        byte[][] board = {{0, 0, 8, 6, 0, 4, 3, 0,0},
                {0, 4, 0, 0, 7, 0, 0, 1, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 2},
                {4, 0, 0, 0, 8, 0, 0, 0, 9},
                {0, 1, 0, 9, 0, 5, 0, 3, 0},
                {3, 0, 0, 0, 2, 0, 0, 0, 1},
                {6, 0, 0, 0, 0, 0, 0, 0, 5},
                {0, 5, 0, 0, 3, 0, 0, 9, 0},
                {0, 0, 2, 1, 0, 6, 7, 0, 0}};;

        byte[][] expected = {
                {2, 9, 8, 6, 1, 4, 3, 5, 7},
                {5, 4, 6, 2, 7, 3, 9, 1, 8},
                {7, 3, 1, 5, 9, 8, 4, 6, 2},
                {4, 2, 5, 3, 8, 1, 6, 7, 9},
                {8, 1, 7, 9, 6, 5, 2, 3, 4},
                {3, 6, 9, 4, 2, 7, 5, 8, 1},
                {6, 7, 3, 8, 4, 9, 1, 2, 5},
                {1, 5, 4, 7, 3, 2, 8, 9, 6},
                {9, 8, 2, 1, 5, 6, 7, 4, 3}};

        byte[][] res = s.solveSudoku(board);

        for(int r = 0 ; r < expected.length ;r++){
            assertArrayEquals(expected[r], res[r]);
        }
    }

    @Test
    public void testTransform(){
        byte[][] expected = {
                {2, 9, 8, 6, 1, 4, 3, 5, 7},
                {5, 4, 6, 2, 7, 3, 9, 1, 8},
                {7, 3, 1, 5, 9, 8, 4, 6, 2},
                {4, 2, 5, 3, 8, 1, 6, 7, 9},
                {8, 1, 7, 9, 6, 5, 2, 3, 4},
                {3, 6, 9, 4, 2, 7, 5, 8, 1},
                {6, 7, 3, 8, 4, 9, 1, 2, 5},
                {1, 5, 4, 7, 3, 2, 8, 9, 6},
                {9, 8, 2, 1, 5, 6, 7, 4, 3}};

        BitSet[][] transform = transform(expected);
        BitSet[][] transform2 = s.transform(expected,null);

        for(int r = 0 ; r < transform.length ;r++){
            for(int c = 0 ; c < transform.length ;c++)
                assertEquals(transform[r][c].toString(), transform2[r][c].toString());
        }

    }

    @Test
    public void testIsSolved(){
        byte[][] expected = {
                {2, 9, 8, 6, 1, 4, 3, 5, 7},
                {5, 4, 6, 2, 7, 3, 9, 1, 8},
                {7, 3, 1, 5, 9, 8, 4, 6, 2},
                {4, 2, 5, 3, 8, 1, 6, 7, 9},
                {8, 1, 7, 9, 6, 5, 2, 3, 4},
                {3, 6, 9, 4, 2, 7, 5, 8, 1},
                {6, 7, 3, 8, 4, 9, 1, 2, 5},
                {1, 5, 4, 7, 3, 2, 8, 9, 6},
                {9, 8, 2, 1, 5, 6, 7, 4, 3}};
        assertTrue(s.isSolved(transform(expected)));

        expected[8][5] = 7;
        assertFalse(s.isSolved(transform(expected)));
    }

    private BitSet[][] transform(byte[][] board){
        BitSet[][] poss = new BitSet[board.length][board.length];
        for(int row = 0 ; row < board.length ; row++){
            for(int col = 0 ; col < board.length;col++){
                poss[row][col] = new BitSet(9);

                if(board[row][col] > 0){
                    poss[row][col].clear();
                    poss[row][col].set((byte) (board[row][col] - 1));
                }else{
                    poss[row][col].set(0,9,true);
                }
            }
        }

        return poss;
    }

}
