package io_streams.a_bar.buffered_demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamDemo {
    /*
        - Buffer is like a temporary memory area for holding the data
        - If there is a difference in the speed between the device and the program then we use buffer
        - like in YouTube, it will try to fetch some video content and put it in the buffer
        - to play the video smoothly

     */
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/main/java/io_streams/a_bar/files/buffer_source.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);

            System.out.println("fiel: " + fis.markSupported()); //false
            System.out.println("bis: " + bis.markSupported()); //true

            /* demonstration for mark support */
            int count = 1;
            int i;
            while((i = bis.read()) != -1) {
                System.out.print((char) i);
                count++;

                if(count == 3) {
                    bis.mark(4); //cur char is marked - it will be marked until we read 4 more chars from it
                    System.out.print(" ");
                }
                if(count == 5) {
                    bis.reset();
                    System.out.print(" ");
                }

                if(i == 8) {
                    bis.reset();
                    System.out.print(" ");
                    //it wont work coz
                    //bis.mark(4); //only until 4 chars we can reset
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
 source file:
 -------------
 abcdefghijklmnop
 123456789.......

 output
 ---------
 ab cd cdefghijklmnop
 */