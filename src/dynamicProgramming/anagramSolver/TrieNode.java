package dynamicProgramming.anagramSolver;

import java.util.Optional;

public class TrieNode {

    private TrieNode[] children = new TrieNode[26];
    private String word;

    public void setWord(String w){
        if(word == null)
            this.word = w;
    }

    public Optional<String> getWord(){
        return Optional.ofNullable(word);
    }

    public TrieNode getChild(char c) {
        int index = c - 97;
        if(children[index] == null)
            children[index] = new TrieNode();

        return children[index];
    }

    public TrieNode lookUp(char[] path){
        TrieNode current = this;
        for(char c : path){
            current = current.getChild(c);
        }

        return current;
    }

}
