package io_streams.a_bar.char_array;

import java.io.*;

public class CharArrayReaderWriterDemo {
    public static void main(String[] args) throws IOException {
        //exactly similar to byte array input stream
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};

        CharArrayReader car = new CharArrayReader(charArray);

        int data;
        while((data = car.read()) != -1)
            System.out.println((char) data);

        //writing it to a file named char_output.txt
        CharArrayWriter caw = new CharArrayWriter();
        caw.write('a');
        caw.write('b');
        caw.write('c');
        caw.write('d');
        caw.write('e');
        caw.write("fig tree");

        FileWriter fw = new FileWriter("src/main/java/io_streams/a_bar/files/char_output.txt");
        caw.writeTo(fw);

        fw.close();
        car.close();
        caw.close();
    }
}

/*
    output displayed in the char_output.txt
    --------------
    abcdefig tree
 */
