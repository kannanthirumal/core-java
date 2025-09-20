package io_streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.StringTokenizer;

public class BufferedReaderAutoClose {
    public static void main(String[] args) {
        /*
            - It's the same thing that I did in BufferedReaderDemo
            - but here using this syntax I don't have to explicitly close the resources
            - and jvm will do it for me
        */
        int wordCount = 0;
        int lineNo = 0;

        try (
                FileReader fr = new FileReader("src/main/java/io_streams/files/my_file.txt");
                BufferedReader br = new BufferedReader(fr);
        ) {
                String line;
                while((line = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(line);
                    System.out.println("Printing line: " + ++lineNo +"\n");
                    System.out.println("---");
                    while(st.hasMoreTokens()) {
                        System.out.println(st.nextToken());
                        wordCount++;
                    }
                    System.out.println();
                }

            System.out.println("Total words: " + wordCount);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
Output
---------
Printing line: 1

---
Welcome
to
IO
streams!

Printing line: 2

---
Believe,
act,
and
nothing
can
stop
you.

Printing line: 3

---
Push
your
limits,
achieve
the
impossible.
 */