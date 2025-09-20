package io_streams;

import java.io.*;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {

            //source - read
            fis = new FileInputStream("src/main/java/io_streams/files/images/robot.png");
            //destination - write
            fos = new FileOutputStream("src/main/java/io_streams/files/images/newImage.png");
            int data;

            //loop through the content of the image
            while((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
