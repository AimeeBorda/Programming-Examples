package anagramSolver;


import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class AnagramSolverTest {

    AnagramSolver a;

    @Before
    public void setUp(){
        a = new AnagramSolver();
    }

    @Test
    public void testEmpty(){

        assertEquals("should return empty string","",a.solveAnagram("word",null));
        assertEquals("should return empty string","",a.solveAnagram("",null));
        assertEquals("should return empty string","",a.solveAnagram(null,null));
        assertEquals("should return empty string","",a.solveAnagram(null,new HashSet<String>()));
    }

    @Test
    public void testAnagram(){

        HashSet<String> dictionary = new HashSet<String>(){{
            add("to"); add("the");
            add("is"); add("we");
            add("hello"); add("world");
            add("tooth"); add("door"); }};
        assertEquals("should solve anagram", "hello to the world",a.solveAnagram("elhloothtedrowl",dictionary));
    }

    @Test
    public void testDictionary(){
        HashSet<String> wordsToEnter = new HashSet<String>() {{
            add("to");
            add("the");
            add("is");
            add("we");
            add("hello");
            add("world");
            add("tooth");
            add("door");
        }};
        for(String s : wordsToEnter){
           a.addWord(s,s,a.root);
       };

        HashSet<String> wordsEntered = new HashSet<>();
        count(a.root,wordsEntered);

//        assertEquals("number of wordsEntered should be 0", Arrays.toString(wordsToEnter.toArray()),Arrays.toString(wordsEntered.toArray()));
    }

    @Test
    public void testAddWord(){
        HashSet<String> words = new HashSet<>();
        count(a.root,words);
        assertEquals("number of words should be 0",0,words.size());

        a.addWord("word","word",a.root);
        count(a.root,words);
        assertEquals("number of words should be 1",1,words.size());

        assertEquals("number of words should be 1","word", words.iterator().next());

        words.clear();
        a.addWord("also","also",a.root);
        count(a.root,words);
        assertEquals("number of words should be 2",2,words.size());
        Iterator<String> iterator = words.iterator();
        assertEquals("number of words should be 1","also", iterator.next());
        assertEquals("number of words should be 1","word", iterator.next());
    }

    private void count(TrieNode root, HashSet<String> words){
        if(root != null){
            for(TrieNode node : root.children){
                count(node,words);
            }

           words.addAll(root.words);
        }
    }
    @Test
    public void testRemoveAt(){
        assertEquals("removeAt", "abde",a.removeAt("abcde",2));
        assertEquals("removeAt", "abce",a.removeAt("abcde",3));
        assertEquals("removeAt", "bcde",a.removeAt("abcde",0));
        assertEquals("removeAt", "abcd",a.removeAt("abcde",4));
    }
}
