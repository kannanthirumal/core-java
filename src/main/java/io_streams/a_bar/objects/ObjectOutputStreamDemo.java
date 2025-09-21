package io_streams.a_bar.objects;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/io_streams/a_bar/files/object_output.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Student st = new  Student(12345, "Kannan", "CS", 5);
            oos.writeObject(st);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
