package io_streams.a_bar.buffered_demo;

import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        //exactly same as BufferedInputStream
        //it has an additional readline method

        try {
            FileReader fr = new FileReader("src/main/java/io_streams/a_bar/files/buffer_source.txt");
            BufferedReader br = new BufferedReader(fr);

            System.out.println("fr: " + fr.markSupported()); //false
            System.out.println("br: " + br.markSupported()); //true

            int count = 1;
            int i;
            while((i = br.read()) != -1) {
                System.out.print((char) i);
                count++;

                if(count == 3) {
                    br.mark(4); //cur char is marked - it will be marked until we read 4 more chars from it
                    System.out.print(" ");
                }
                if(count == 5) {
                    br.reset();
                    System.out.print(" ");
                }

                if(i == 8) {
                    br.reset();
                    System.out.print(" ");
                    //it wont work coz
                    //br.mark(4); //only until 4 chars from the marked character we can reset
                }
            }

            //initializing again coz of EOF
            fr = new FileReader("src/main/java/io_streams/a_bar/files/buffer_source.txt");
            br = new BufferedReader(fr);
            System.out.println("\n" + br.readLine());

            fr.close();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
