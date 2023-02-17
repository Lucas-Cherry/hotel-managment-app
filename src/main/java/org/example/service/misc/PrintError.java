package org.example.service.misc;
import java.util.InputMismatchException;


public class PrintError {
    public static void printError(Exception err) {
        if (err instanceof IndexOutOfBoundsException) System.out.println("Requested item doesn't exist");
        if (err instanceof InputMismatchException)  {
            System.out.println("Wrong input");
        }else {
            System.out.println("Something went wrong");
        }
         ;
    }
}
