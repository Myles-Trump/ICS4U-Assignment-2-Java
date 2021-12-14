/*
* The "DateCalc" Program tells you what day it was on the date you input
*
* @author  Myles Trump
* @version 1.0
* @since   2021-12-13
*/

import java.util.Scanner;
import java.time.LocalDate;

/**
* This is a program that tells you the day of inputted dates.
*/
final class DateCalc {

    /**
    * One Thousand.
    */
    public static final double THOUSAND = 1000;

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private DateCalc() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The dateToDay() function figures out the day the inputted date was on.
    *
    * @return date to day
    * @param inputtedDay inputted day
    */
    public static String dateToDay(LocalDate theDate) {

        String yearString = String.valueOf(theDate.getYear());

        int centuryCode  = (int) (theDate.getYear() / THOUSAND);

        return (yearString);
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // variables
        String dayFinal;

        final Scanner date = new Scanner(System.in);

        System.out.print("Input the date (yyyy-mm-dd): ");

        LocalDate theDate = LocalDate.parse(date.nextLine());

        dayFinal = dateToDay(theDate);

        System.out.println("\nThe day of " + theDate + " is "
            + dayFinal + ".");
        System.out.println("\nDone.");
    }
}
