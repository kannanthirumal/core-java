package io_streams.a_bar.File_Input_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInputDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("src/main/java/io_streams/a_bar/files/japan.txt");

            //first method
            /*
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
             */

            //second method
            //available -> gives the no of available bytes
            byte[] b = new byte[fis.available()];
            fis.read(b);
            String str = new String(b);
            System.out.println(str);

            fis.close();

            //File Reader also works exactly the same way
            FileReader fr = new FileReader("src/main/java/io_streams/a_bar/files/japan.txt");
            int ch;
            while( (ch = fr.read()) != -1 ) {
                System.out.print((char)ch);
            }
            fr.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
