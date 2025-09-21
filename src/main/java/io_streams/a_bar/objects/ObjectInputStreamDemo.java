package io_streams.a_bar.objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("src/main/java/io_streams/a_bar/files/object_output.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student st = (Student) ois.readObject();
            System.out.println("rollNo: " + st.rollNo);
            System.out.println("name: " + st.name);
            System.out.println("dept: " + st.dept);

            Student.staticVariable = 99;
            System.out.println("staticVariable: " + st.staticVariable);
            System.out.println("transientVariable: " + st.transientVariable);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/*
//object serialization nuance
# Java Serialization: Static vs Transient Variables

## Key Points

### Static Variables

-   **Static variables are not serialized.**
-   They belong to the **class**, not to any particular object instance.
-   During deserialization, the static variable value comes from the
    **currently loaded class in memory**, not from the file.

**Example Behavior:** 1. Serialize an object with `staticVariable = 5`.
2. Change the code so `staticVariable = 99` in the class. 3. Deserialize
   the object.

**Output:**

    staticVariable: 99

Even though the object was serialized with `5`, the value reflects the
**current class definition**, proving static variables are not
serialized.

------------------------------------------------------------------------

### Transient Variables

-   **Transient variables are skipped during serialization.**
-   Their values are not saved in the stream.
-   Upon deserialization, they are reset to the default value of their
    type:
    -   `0` for integers
    -   `null` for objects
    -   `false` for booleans

**Example Behavior:**

``` java
transient int transientVariable = 5;
```

After deserialization:

    transientVariable: 0

------------------------------------------------------------------------

### Serializable Fields

-   Non-`static`, non-`transient` fields **are serialized** and
    restored.

------------------------------------------------------------------------

## Clarification on Constructors

-   For Java's built-in `Serializable`, **a no-arg constructor is not
    required**.
-   Deserialization bypasses constructors and directly restores the
    object from the byte stream.

------------------------------------------------------------------------

## Summary

-   `static` → Not serialized, value depends on current class state.
-   `transient` → Not serialized, resets to default value after
    deserialization.
-   Normal fields → Fully serialized and restored.

This explains why in your code, `staticVariable` showed `5` (from the
class) and `transientVariable` showed `0` (reset to default).

 */
