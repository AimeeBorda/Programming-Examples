package dynamicProgramming.anagramSolver;

import java.util.*;

//https://www.careercup.com/question?id=5732347262533632
public class AnagramSolver {

    TrieNode root = new TrieNode();

    public String solveAnagram(String sentence, HashSet<String> dictionary) {
        if(dictionary == null || sentence == null)
            return "";

        parseDictionary(dictionary);
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
       for(char c : sentence.toCharArray()){
            word.append(c);
            Optional<String> s = getWord(word.toString());
            s.ifPresent(str -> {
                res.append(" " +str);
                word.delete(0, word.length());
            });
       }
        return res.length() > 0 ? res.substring(1) : "";
    }

    private Optional<String> getWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        return root.lookUp(chars).getWord();
    }




    private void parseDictionary(HashSet<String> dictionary) {
        for(String word : dictionary){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            root.lookUp(chars).setWord(word);

        }
    }


}
