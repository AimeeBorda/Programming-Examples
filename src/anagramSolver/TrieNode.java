package anagramSolver;

import java.util.HashSet;

public class TrieNode {

     TrieNode[] children = new TrieNode[26];
    HashSet<String> words = new HashSet<String>();


    public TrieNode getChild(char c) {
        int index = c - 97;
        if(children[index] == null)
            children[index] = new TrieNode();

        return children[index];
    }
}
