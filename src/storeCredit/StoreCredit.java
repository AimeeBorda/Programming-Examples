package storeCredit;

import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class StoreCredit
{
    public void runFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("storeCredit.in"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("storeCredit.out"));


            int numberOfExamples = Integer.parseInt(reader.readLine());

            for(int i = 1 ; i <= numberOfExamples;i++){
                int credit = Integer.parseInt(reader.readLine());
                int numOfItems = Integer.parseInt(reader.readLine());
                AtomicInteger index = new AtomicInteger();
                String[] items = reader.readLine().split(" ");
                Map<Integer, Integer> collect = Arrays.stream(items).collect(Collectors.toMap(x -> Integer.parseInt((String) x), x -> index.getAndIncrement(), (a, b) -> a));

                int[] ans = solveExample(credit, collect.keySet());

                int value1 = collect.get(ans[0]);
                int value2 = ans[0] != ans[1] ? collect.get(ans[1]) : ArrayUtils.indexOf(items, String.valueOf(ans[1]), value1 + 1);
                writer.write("Case #"+i+": "+ (Math.min(value1,value2)+ 1) + " "+ (Math.max(value1,value2) + 1) +"\n");

            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public int[] solveExample(int credit, Set<Integer> collect) {

        //prepare input
        int min = collect.parallelStream().min(Integer::compare).get();

        Integer[] sorted = collect.parallelStream().filter(x -> x <= credit - min).sorted().toArray(Integer[]::new);

        int i = sorted.length - 1;
        int[] max = new int[]{0,0};
        while(i > 0 && sorted[i] + sorted[i-1] >= max[0] + max[1]){
            int secondValue = closest(sorted, credit - sorted[i]);

            if(secondValue + sorted[i] > max[0] + max[1]){
                max[0] = secondValue; max[1] = sorted[i];
            }

            i--;
        }
        return max;
    }

    public int closest(Integer[] sorted, int value) {
        int low = 0;
        int high = sorted.length - 1;

        while(high >= low) {
            int middle = (low + high) / 2;
            if(sorted[middle] == value) {
                return value;
            }
            if(sorted[middle] < value) {
                low = middle + 1;
            }
            if(sorted[middle] > value) {
                high = middle - 1;
            }
       }
        return high < sorted.length && high >= 0? sorted[high]:Integer.MAX_VALUE;
    }


}


