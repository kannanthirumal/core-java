package io_streams.a_bar.copy_file;

import java.io.*;
import java.util.*;

public class CopyMultipleFiles {
    public static void main(String[] args) throws IOException {
        //Here I will copy from "src/main/java/io_streams/a_bar/files/java_source.txt"
        //jav_source, java_copy, java_copy_2
        //to java_destination.txt

        //vector
        Vector<InputStream> v = new Vector<>();
        v.add(new FileInputStream("src/main/java/io_streams/a_bar/files/java_source.txt"));
        v.add(new FileInputStream("src/main/java/io_streams/a_bar/files/java_copy.txt"));
        v.add(new FileInputStream("src/main/java/io_streams/a_bar/files/java_copy_2.txt"));

        Enumeration<InputStream> e1 = v.elements();

        //collection
        List<InputStream> l = new ArrayList<>();
        l.add(new FileInputStream("src/main/java/io_streams/a_bar/files/java_source.txt"));
        l.add(new FileInputStream("src/main/java/io_streams/a_bar/files/java_copy.txt"));
        l.add(new FileInputStream("src/main/java/io_streams/a_bar/files/java_copy_2.txt"));

        Enumeration<InputStream> e2 = Collections.enumeration(l);

        //I have to pass Enumeration here so I tried doing it using vector as well as list
        SequenceInputStream sis1 = new SequenceInputStream(e1); //enumeration from vector
        SequenceInputStream sis2 = new SequenceInputStream(e2); //enumeration from collection

        //or simple way is
        FileInputStream fis1 = new FileInputStream("src/main/java/io_streams/a_bar/files/java_source.txt");
        FileInputStream fis2 = new FileInputStream("src/main/java/io_streams/a_bar/files/java_copy.txt");
        FileInputStream fis3 = new FileInputStream("src/main/java/io_streams/a_bar/files/java_copy_2.txt");
        /*
            - we can only pass 2 input streams in the argument so the beow code doesn't work
            - wrong -> SequenceInputStream sis3 = new SequenceInputStream(fis1, fis2, fis3);
            - correct -> SequenceInputStream sis3 = new SequenceInputStream(fis1, fis2);
        */

        FileOutputStream fos = new FileOutputStream(
                "src/main/java/io_streams/a_bar/files/java_destination.txt",
                true //for appending
        );

        /* it doesn't add new lines to the new files */
        /*
            int data;
            while ((data = sis1.read()) != -1) {
                fos.write(data);
            }

            fos.close();

         */

        // To add newlines between files, we need to read each stream one by one and write a newline after each.
// Re-initializing e1 is necessary because creating
// "SequenceInputStream sis1 = new SequenceInputStream(e1)"
// consumes the first element of the enumeration internally.
// Without re-initialization, the first file would be skipped.
        e1 = v.elements();

        while (e1.hasMoreElements()) {
            InputStream curStream = e1.nextElement();
            System.out.println("Copying file stream: " + curStream);
            int d;
            while ((d = curStream.read()) != -1) {
                fos.write(d);
            }
            fos.write('\n'); // Write newline after each file
            curStream.close();
        }

        fos.close();

    }
}
