package SortingByFrequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SortingByFrequency {

    //heap element is character + frequency
    static HashMap<Character,Integer> freq;
    static Object[] sortedFreq;

    public String createString(String word){
        if(word == null)
            return null;

        sortedFreq = new Object[word.length()];
        freq = new HashMap<>();
        for(Character c : word.toCharArray()){
            insert(c);
        }
        StringBuilder str = new StringBuilder();
        for(int i = sortedFreq.length - 1; i>=0;i--){
            if(sortedFreq[i] != null){
                Iterator<Character> t = ((HashSet<Character>)sortedFreq[i]).iterator();
                while(t.hasNext()){
                    str.append(new String(new char[i]).replace('\u0000', t.next()));
                }
            }
        }

        return str.toString();
    }


    private  void insert(char c){
        Integer count = freq.get(c);
        if(count == null){
            incrementLetter(c, 0);
            freq.put(c, 1);
        }else{
            incrementLetter(c, count);
            freq.put(c,count+1);
        }
    }

    public  void incrementLetter(char c, int count){
        if(sortedFreq[count] != null && sortedFreq[count] !=null)
            ((HashSet<Character>)sortedFreq[count]).remove(c);

        if(sortedFreq[count+1] == null)
            sortedFreq[count+1] = new HashSet<>();

        ((HashSet<Character>)sortedFreq[count+1]).add(c);
    }


}
