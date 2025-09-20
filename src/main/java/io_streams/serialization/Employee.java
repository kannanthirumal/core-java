package io_streams.serialization;

import java.io.Serializable;

// Employee class implements Serializable so that its objects can be saved to a file or sent over a network
public class Employee implements Serializable {
    /*
        1. Serializable interface:
           - It's a **marker interface** (has no methods).
           - By implementing it, JVM knows that instances of this class can be **converted into a byte stream**.
           - This process is called **serialization**.
           - Serialization allows you to **store objects** or **send them over the network**.

        2. transient keyword:
           - Fields marked as `transient` **will NOT be serialized**.
           - Useful for sensitive data (like passwords or social security numbers) or temporary data.
           - During deserialization, transient fields are initialized with their **default values** (0 for int, null for objects, etc.).
    */

    public int id;                         // This will be serialized
    public String name;                    // This will be serialized
    public double salary;                          // This will be serialized
    public transient int social_security_no;       // This will NOT be serialized

    public Employee(int id, String name, double salary, int social_security_no) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.social_security_no = social_security_no;
    }
}
