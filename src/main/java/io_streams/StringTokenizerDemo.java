package io_streams;


import java.util.StringTokenizer;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        //it allows us to break a given string into multiple tokens

        String s1 = "Nothing is impossible.";

        String s2 = "Nothing,is,impossible.";

        //stringtokenizer - default delimitters are -> tab, space, \n (new line), \r (carriage return)
        StringTokenizer st1 = new StringTokenizer(s1);

        StringTokenizer st2 = new StringTokenizer(s2, ",");

        StringTokenizer st3 = new StringTokenizer(s2, ",", true);



        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());
        }

        System.out.println("\n--------\n");

        while (st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }

        System.out.println("\n--------\n");

        while (st3.hasMoreTokens()) {
            System.out.println(st3.nextToken());
        }
    }
}

/*
Output
----------
Nothing
is
impossible.

--------

Nothing
is
impossible.

--------

Nothing
,
is
,
impossible.
 */