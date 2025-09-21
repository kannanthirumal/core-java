package io_streams.a_bar.File_Output_Stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("src/main/java/io_streams/a_bar/files/japan.txt");

            String str = "I'd love to visit Japan someday.";

            //1. first way
            /*
            byte[] bytes = str.getBytes();
            fos.write(bytes);
             */

            //2. second way
            /*
            byte[] bytes = str.getBytes();
            for(byte b : bytes){
                fos.write(b);
            }
             */

            //3. third way
            /*
            fos.write(str.getBytes());
             */

            //4. fourth way - write partially - "love to visit japan"
            byte[] bytes = str.getBytes();
            fos.write(bytes, 4, 19);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
