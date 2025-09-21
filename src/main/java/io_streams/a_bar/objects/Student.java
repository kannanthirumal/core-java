package io_streams.a_bar.objects;

import java.io.Serializable;

public class Student implements Serializable {
    static int staticVariable = 5;
    transient int transientVariable = 5;
    /*
        both static and transient variables can't be serializable and saved
     */

    int rollNo;
    String name;
    String dept;

    /*   (it could be wrong -> read the below block comment)
        - it must have a non parameterized constructor alos (either default)
        - or if you have any other constructor
        - add one yourself
        - otherwise reading won't work
     */

    /*
     - figured this out recently & it is true
     - static and transient variables are not serialized.
     - For Java's built-in Serializable:
         * No-arg constructor is NOT required.
         * Deserialization bypasses constructors.
    */

//    public Student() {}


    public Student(int rollNo, String name, String dept, int transientVariable) {
        this.rollNo = rollNo;
        this.name = name;
        this.dept = dept;
        this.transientVariable = transientVariable;
    }
}
