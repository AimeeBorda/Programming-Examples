package AnagramSolver;

import java.util.HashSet;

public class AnagramSolver {

    TrieNode root = new TrieNode();
    HashSet<String>[] words;

    public String solveAnagram(String word, HashSet<String> dictionary) {
        if(dictionary == null || word == null)
            return "";

        parseDictionary(dictionary);
        words = new HashSet[word.length() + 1];

        for(int i = 0; i < word.length(); i++){
            words[i] = new HashSet<>();

            for(int j = 0; j < i; j++){
                lookUp(word.substring(j, i+1), j);

            }
        }

        return words[word.length() - 1].size() > 0 ?  words[word.length() - 1].iterator().next() : "";
    }

    public void lookUp(String word,  int j) {
        TrieNode current=root;
        for(int i = 0 ; current != null && i<word.length();i++){
            current = current.getChild(word.charAt(i));
        }

        if(current !=null){
           for(String s : current.words){
                    if(j > 0) {
                        words[j - 1].forEach(p -> words[j + word.length()-1].add(p + " " + s));
                    }else{
                        words[word.length()-1].add(s);
                    }
                }

        }
    }


    public void parseDictionary(HashSet<String> dictionary) {
        for(String word : dictionary){
            addWord(word,word,root);
        }
    }

    public void addWord(String anagram, String word, TrieNode current) {
        if(anagram.length() > 0){
            for(int i = 0 ; i < anagram.length() ;i++){
                TrieNode child = current.getChild(anagram.charAt(i));
                addWord(removeAt(anagram,i),word, child);
            }
        }else{
            current.words.add(word);
        }

    }

    public String removeAt(String word, int i) {
        return (i > 0?word.substring(0, i):"") + (word.length() > i + 1?word.substring(i+1):"");
    }

}
