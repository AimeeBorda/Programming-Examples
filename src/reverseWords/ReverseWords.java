package reverseWords;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;

public class ReverseWords {

    public void runFileExample(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("reverse.in"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("reverse.out"));


            int numberOfExamples = Integer.parseInt(reader.readLine());

            for(int i = 1 ; i <= numberOfExamples;i++){
               String[] words = reader.readLine().split(" ");
                words = reverse(words);

                writer.write("Case #"+i+": "+ StringUtils.join(words, " ") +"\n");
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String[] reverse(String[] words) {

        if(words.length > 1) {
            int middle = words.length / 2;

            String[] arr1=reverse(Arrays.copyOfRange(words, 0, middle));
            String[] arr2 = reverse(Arrays.copyOfRange(words, middle , words.length ));

           System.arraycopy(arr2,0,words,0,arr2.length);
           System.arraycopy(arr1,0,words,arr2.length,arr1.length);
        }
        return words;
    }

//https://www.interviewcake.com/question/python/reverse-string-in-place
    public String inplaceReversal(String word){
        char[] letter = word.toCharArray();
        for(int i = 0 ; i < word.length() / 2; i++){
            char temp = letter[i];
            letter[i] = letter[word.length() - i - 1];
            letter[word.length() - i-1] = temp;
        }

        return Arrays.toString(letter).replaceAll(", ","").substring(1,letter.length+1);
    }
}
