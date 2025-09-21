package io_streams.a_bar.byte_array;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) throws IOException {
        /*
            - here, I'm converting a byte array to a byte array stream
            - and a byte array stream to a byte array and then to a string
         */

        byte[] b = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        ByteArrayInputStream bais = new ByteArrayInputStream(b);

        int byteData;
        while((byteData = bais.read()) != -1) {
            System.out.print((char)byteData);
        }

        //now converting it back to byte array and then string
        /*
            - When you read from a stream, you get data byte by byte (or in chunks).
            - The stream keeps an internal pointer indicating the current read position.
            - Once you reach the end of the stream, there’s no more data to read.
            - EOF - end of file
            - So, I'm reinitializing it
         */
        bais = new ByteArrayInputStream(b);

        //now converting it back to byte array and then string
        byte[] newByteArray = bais.readAllBytes();
        String str = new String(newByteArray);
        System.out.println(str);

        bais.close();

    }
}
