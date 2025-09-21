package io_streams.a_bar.copy_file;

import io_streams.a_bar.File_Output_Stream.FileOutputDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileCapsToLower {
    public static void main(String[] args) {
        //Here I will copy from "src/main/java/io_streams/a_bar/files/java_source.txt"
        //to java_copy.txt
        //in java_source - it's all uppercase
        //in addition I will convert the upper case to lowercase using a trick
        //A-Z => ASCII => 65 to 90
        //a-z => ASCII => 97 to 122

        try {
            FileInputStream fis = new FileInputStream("src/main/java/io_streams/a_bar/files/java_source.txt");
            FileOutputStream fos = new FileOutputStream("src/main/java/io_streams/a_bar/files/java_copy.txt");

            int data;
            while((data = fis.read()) != -1) {
                if(data >= 65 && data <= 90) {
                    fos.write(data + 32);
                }
                else {
                    fos.write(data);
                }
            }

            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
