package regularExpressions;

public class Quine
{

    public static void main(String[] args)
    {
        String s = "public class HelloWorld {  public static void main(String[] args)  { String s = \"%s\"; System.out.printf(s,s);} }";

        System.out.printf(s,s);
    }
}