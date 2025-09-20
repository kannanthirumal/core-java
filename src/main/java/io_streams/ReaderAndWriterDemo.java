package io_streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderAndWriterDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        FileWriter fw = null;

        fr = new FileReader("src/main/java/io_streams/files/my_file.txt");
        fw = new FileWriter("src/main/java/io_streams/files/new_file.txt");

        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fr.close();
        fw.close();
    }
}
