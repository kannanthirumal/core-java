package io_streams.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {
    public static void main(String[] args) {
        FileOutputStream fos;
        ObjectOutputStream oos;

        //ser -> extension for serialized files
        try {
            fos = new FileOutputStream("src/main/java/io_streams/files/EmpSerialized.ser");
            oos = new ObjectOutputStream(fos);

            Employee emp = new Employee(1, "John", 100000000, 1234567);
            oos.writeObject(emp);

            System.out.println("Employee object serialized successfully");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
