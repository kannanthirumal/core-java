package io_streams.a_bar.byte_array;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(20); //gives the size of the stream

        baos.write('a');
        baos.write('b');
        baos.write('c');
        baos.write('d');
        baos.write('e');
        baos.write('f');

        byte[] newByteArray = baos.toByteArray();
        for(byte b : newByteArray){
            System.out.println(b); //prints the integer
        }

        for(byte b : newByteArray){
            System.out.println((char) b); //prints the character
        }

        //writing it to a file named byte_output.txt
        FileOutputStream fos = new FileOutputStream("src/main/java/io_streams/a_bar/files/byte_output.txt");
        baos.writeTo(fos);

        fos.close();
        baos.close();
    }
}
