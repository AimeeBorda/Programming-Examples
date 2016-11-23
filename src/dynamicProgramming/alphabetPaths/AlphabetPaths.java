package dynamicProgramming.alphabetPaths;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

    String[][] startAt;// = new String[letterMaze.length][letterMaze[0].length()];
    String[][] endsAt;// = new String[letterMaze.length][letterMaze[0].length()];


    public long count(String[] letterMaze) {
        if(letterMaze == null || letterMaze.length ==0)
            return 0;

        int count =0;
        startAt = new String[letterMaze.length][letterMaze[0].length()];
        endsAt = new String[letterMaze.length][letterMaze[0].length()];

        for(int row = 0; row < letterMaze.length ;row++){
            for(int col = 0; col < letterMaze[row].length();col++){

                String letter = letterMaze[row].substring(col, col+1);

                startAt[row][col] = Stream.concat(
                                        Arrays.stream(getArr(startAt,row-1,col))
                                                .filter(isAppendLast(letterMaze, row, col, letter))
                                                .map(s -> String.format("%s%s", s, letter))
                                        ,Arrays.stream(getArr(startAt,row,col-1))
                                                .filter(isAppendFirst(letterMaze, row, col, letter))
                                                .map(s -> String.format("%s%s", letter, s)))
                                    .distinct()
                                    .reduce((res, s) -> res + (s.length() > 0 ?"," + s : ""))
                                    .orElse("");
//
                endsAt[row][col] = Stream.concat(
                                        Arrays.stream(getArr(endsAt,row-1,col))
                                                .filter(isAppendLast(letterMaze, row, col, letter))
                                                .map(s -> String.format("%s%s", s, letter))
                                        ,Arrays.stream(getArr(endsAt,row,col-1))
                                                .filter(isAppendFirst(letterMaze, row, col, letter))
                                                .map(s -> String.format("%s%s", letter, s)))
                                    .distinct()
                                    .reduce((res, s) -> res + (s.length() > 0 ?"," + s : ""))
                                    .orElse("");

                count += Arrays.stream(startAt[row][col].split(",")).filter(p -> p.replaceAll("^\\.*($1)\\.*$","$1").length() == 21).count();
                count += Arrays.stream(endsAt[row][col].split(",")).filter(p -> p.replaceAll("^\\.*($1)\\.*$","$1").length() == 21).count();

            }
        }

        return count;
    }

    private String[] getArr(String[][] startAt, int row, int col){
        if(row <0 || col < 0)
            return new String[]{""};
        else{
            return startAt[row][col].replaceAll(",,",",").split(",");
        }
    }

    private <T> Predicate<String> isAppendLast(String[] letterMaze, int r, int c, String letter) {
        return p -> !p.contains(letter) &&
                    !p.endsWith(".") &&
                    ((r == 0 || p.length() ==0 || letterMaze[r - 1].charAt(c) == p.charAt(p.length() - 1))
                            && (c == 0 || p.length() ==0 || letterMaze[r].charAt(c-1) == p.charAt(p.length() - 1)));
    }

    private <T> Predicate<String> isAppendFirst(String[] letterMaze, int r, int c, String letter) {
        return p -> !p.contains(letter) &&
                    !p.startsWith(".") &&
                    ((r == 0 || p.length() ==0 || letterMaze[r - 1].charAt(c) == p.charAt(0))
                            && (c == 0 ||p.length() ==0 ||  letterMaze[r].charAt(c-1) == p.charAt(0)));
    }


}
