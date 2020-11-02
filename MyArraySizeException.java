package project1;

import java.io.PrintStream;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    MyArraySizeException(String description){
     super(description);
    }
}
