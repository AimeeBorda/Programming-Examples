package multiThreading;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;


public class MainTest {

    private static final int NUM = 2;
    public static final int BUFFER = 10;

    public static AtomicInteger counter = new AtomicInteger();

    public static Semaphore s = new Semaphore(BUFFER);
    public static int[] buffer = new int[BUFFER];


    public static void main(String[] args) throws Exception {

        DateFormat timeZoneFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date date = timeZoneFormat.parse("01-01-2001 01:00:00");

        ExecutorService exec = java.util.concurrent.Executors.newCachedThreadPool();

        exec.submit(new Callable<String>() {
            @Override
            public String call(){
                return "";
            }
        });

        exec.submit(new Runnable() {
            @Override
            public void run() {
                return;
            }
        });

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("b");
        Iterator i = list.iterator();

        while(i.hasNext()){
             System.out.println(i.next());
             list.add("a");
        }

        System.out.println(list.size());

        //isNumber
        Pattern.compile("^\\d*(\\.\\d*)?\\d(e\\d+)?").matcher("9.1").matches();

        //split into comma separated
        Pattern.compile(",(?=(([^\"]*\"){2})*[^\"]*$)").split("hello, \"word, test\"");

        //matching brackets
        boolean hasMatchingParanthesis = "(())".replaceAll("[^()]","").replaceAll("\\(\\)","").length() == 0;
    }
}
