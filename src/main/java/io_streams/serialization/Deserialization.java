package io_streams.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/main/java/io_streams/files/EmpSerialized.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            Employee emp = (Employee) obj;

            System.out.println("Employee object deserialized successfully");
            System.out.println("Employee id: " + emp.id);
            System.out.println("Employee name: " + emp.name);
            System.out.println("Employee salary: " + emp.salary);
            System.out.println("Employee social security no: " + emp.social_security_no); //will be '0' - coz it's tranisent, if it's an object it will be null

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

/*
Output
-----------
Employee object deserialized successfully
Employee id: 1
Employee name: John
Employee salary: 1.0E8
Employee social security no: 0

*/