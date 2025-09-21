package static_members;

public class HelloWorld {

    public static void main(String[] args) {
        // Main method → entry point of the program
        // Executed after the class is loaded and static initialization is done.
        System.out.println("Hello World");
    }

    // Static block → executed once, when the class is loaded into JVM memory.
    // Happens BEFORE main() is called.
    static {
        System.out.println("Static Block");
    }
}

/*
Explanation:
------------
1. When you run:  java HelloWorld
   - JVM loads the class HelloWorld into memory.
   - During this "class loading + initialization phase", all static blocks run.

2. After class loading is complete, JVM looks for main(String[] args) and executes it.

So the output will be:
----------------------
Static Block
Hello World
*/

/*
package static_members;

public class HelloWorld {
    // First static block
    static {
        System.out.println("Static Block 1");
    }

    // Second static block
    static {
        System.out.println("Static Block 2");
    }

    // Third static block
    static {
        System.out.println("Static Block 3");
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

/*
Explanation:
------------
- JVM executes static blocks IN THE ORDER they appear in the class.
- All static blocks are executed once when the class is loaded into memory.
- Only after that, main() is invoked.

So the output will be:
----------------------
Static Block 1
Static Block 2
Static Block 3
Hello World
*/
