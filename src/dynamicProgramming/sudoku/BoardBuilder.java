package dynamicProgramming.sudoku;


public class BoardBuilder {
    public byte[][] board;

    public BoardBuilder setCell(byte row, byte col, byte value){
        board[row][col] = value;
        return this;
    }


}
