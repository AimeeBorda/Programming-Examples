package AnagramSolver;

import java.util.HashSet;
import java.util.Stack;

public class AnagramSolver {
    public String solveAnagram(String word, HashSet<String> dictionary) {
        TrieNode root = parseDictionary(dictionary);
        Stack<String> words = new Stack<>();

        for(char c : word.toCharArray()){
          //  root[c % 26 ]
        }
        return "";
    }

    private TrieNode parseDictionary(HashSet<String> dictionary) {
        return null;
    }
}
