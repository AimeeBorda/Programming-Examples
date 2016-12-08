package dynamicProgramming.sudoku;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class SudokuSolverTest {

    SudokuSolver s;
    BoardBuilder b;
    @Before
    public void setUp(){
        s = new SudokuSolver();
        b = new BoardBuilder();
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

        assertTrue(isSolved(s.solveSudoku(board)));
    }

//    @Test
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
        assertArrayEquals(expected, s.solveSudoku(board));
    }

    private boolean isSolved(byte[][] board) {
        return false;
    }


    @Test
    public void testRegex(){
        assertTrue(Pattern.compile("([a-zA-Z](?=.*\\d.*\\d)|[0-9](?=.*\\d))(?=\\w{7,}$)").matcher("12345678").find());
    }
}
