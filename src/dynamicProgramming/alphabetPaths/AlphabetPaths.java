package dynamicProgramming.alphabetPaths;

import java.util.Arrays;

/**
 *     	The original Latin alphabet contained the following 21 letters:
 A B C D E F Z H I K L M N O P Q R S T V X

 You are given a 2-dimensional matrix of characters represented by the String[] letterMaze. The
 i-th character of the j-th element of letterMaze will represent the character at row i and column j.
 The matrix will contain each of the 21 letters at least once. It may also contain empty cells marked
 as '.' (quotes for clarity).

 A path is a sequence of matrix elements such that the second element is (horizontally or vertically)
 adjacent to the first one, the third element is adjacent to the second one, and so on. No element may
 be repeated on a path. A Latin alphabet path is a path consisting of exactly 21 elements, each
 containing a different letter of the Latin alphabet. The letters are not required to be in any particular
 order.

 Return the total number of Latin alphabet paths in the matrix described by letterMaze.
 */
public class AlphabetPaths {
    public long count(String[] letterMaze) {
        if(letterMaze == null || letterMaze.length ==0)
            return 0;

        String[][] paths = new String[letterMaze.length][letterMaze[0].length()];

        for(int i = 0 ; i < letterMaze.length;i++){
            paths[i][i] = String.valueOf(letterMaze[i].charAt(i));
            paths[i][i] = paths[i][i].equals(".")? "":paths[i][i];
        }
        for(int row = 0; row < letterMaze.length ;row++){
            for(int col = 0; col < letterMaze[row].length();col++){
                String path = ((row > 0 ?paths[row-1][col] +","   : "") + (col > 0 ?paths[row][col - 1]: "")).replace(",,",",") ;
                String letter = letterMaze[row].substring(col, col+1);

                //if path is reached leave it in else append letter
               paths[row][col] =  Arrays.stream(path.split(","))
                                    .filter(p -> (!p.contains(letter) && !letter.equals(".")) || p.length() == 21)
                                    .map(s -> s.length() < 21 ? s + letter : s)
                                    .reduce((res, s) -> res + "," + s)
                                    .orElse("");
            }
        }

        return (paths.length > 0 ?getCount(paths[letterMaze.length -1][paths[0].length -1]) : 0)*2l; //paths * reverse order
    }

    private long getCount(String paths){
        return Arrays.stream(paths.split(",")).filter(s -> s.length() == 21).count();
    }
}
