package io_streams.a_bar.copy_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo {
    public static void main(String[] args) {
        //Here I will copy from "src/main/java/io_streams/a_bar/files/java_source.txt"
        //to java_copy.txt

        FileInputStream fis;
        FileOutputStream fos;

        {
            try {
                fis = new FileInputStream("src/main/java/io_streams/a_bar/files/java_source.txt");
                fos = new FileOutputStream("src/main/java/io_streams/a_bar/files/java_copy.txt");

                int data;
                while((data = fis.read()) != -1) {
                    fos.write(data);
                }

                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
