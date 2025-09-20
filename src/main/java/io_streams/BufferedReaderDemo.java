package io_streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;

        int wordCount = 0;
        int lineNo = 0;

        try {
            fr = new FileReader("src/main/java/io_streams/files/my_file.txt");
            br = new BufferedReader(fr); //buffer reader is a decorator of file reader - decorator design pattern

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
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

/*
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

Total words: 17
 */