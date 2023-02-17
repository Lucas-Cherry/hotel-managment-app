package org.example.service.misc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReadInput {
    public static int inputNum() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static String inputStr() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static char inputChar() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    public static boolean inputBool() {
        char check = inputChar();
        return (check =='y'||check=='Y') ? true : false;
    }

    public static int inputTinyInt() {
        char check = inputChar();
        return (check =='y'||check=='Y') ? 1 : 0;
    }
    public static Date inputDate() throws ParseException {
            Scanner scanner = new Scanner(System.in);

            String dateString = scanner.next();

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(dateString);
            return date;
    }
}

