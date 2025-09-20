package io_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("src/main/java/io_streams/files/my_file.txt"));

            System.out.println("File opened");

            int i;
            /**
             * fis has a read method that returns back an int value
             * reads one byte at a time
             * if it returns "-1" - then it marks the end of the file
             */
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
                System.out.println("\nFile closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
