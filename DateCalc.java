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
    * Months in a year.
    */
    public static final int TOTALMONTHS = 12;

    /**
    * Three.
    */
    public static final int C3 = 3;

    /**
    * Four.
    */
    public static final int C4 = 4;

    /**
    * Five.
    */
    public static final int C5 = 5;

    /**
    * Six.
    */
    public static final int C6 = 6;

    /**
    * Seven.
    */
    public static final int C7 = 7;

    /**
    * Hundred.
    */
    public static final int C100 = 100;

    /**
    * Four hundred.
    */
    public static final int C400 = 400;

    /**
    * Thousand.
    */
    public static final int C1000 = 1000;

    /**
    * Doomsday dates.
    */
    public static final int[] doomsdayDates =
        {3, 28, 14, 4, 9, 6, 11, 8, 5, 10, 7, 12};

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
    * @param theDate inputted date
    */
    public static String dateToDay(final LocalDate theDate) {

        int dayOfTheWeekInt = 0;
        int theYear = theDate.getYear();
        int theMonth = theDate.getMonthValue();
        int theDay = theDate.getDayOfMonth();
        int centuryCode = (int) (theYear / C1000);
        int shortYear = (theYear - ((int) (theYear / C100)) * C100);
        int yearDiv = (int) (shortYear / TOTALMONTHS);
        if (yearDiv == 0) {
            yearDiv = 1;
            dayOfTheWeekInt = 1;
        }
        int yearMod = shortYear % TOTALMONTHS;
        int yearQuotient = (int) (yearMod / yearDiv);
        int doomsdaySubtotal = centuryCode + yearDiv + yearMod + yearQuotient;
        int doomsdayWeekday = (int) (doomsdaySubtotal % C7);

        int doomsdayDay = doomsdayDates[theMonth - 1];

        if ((((theYear % C4 == 0) && (theYear % C100 != 0))
            || (theYear % C400 == 0)) && (theMonth == 1 || theMonth == 2)) {

            doomsdayDay = doomsdayDay + 1;
        }

        int dayOffset = theDay - doomsdayDay;
        dayOfTheWeekInt = dayOfTheWeekInt + dayOffset % C7;

        String dayOfTheWeek = "Placeholder";
        switch (dayOfTheWeekInt) {
            case 0:
                dayOfTheWeek = "Sunday";
                break;
            case 1:
                dayOfTheWeek = "Monday";
                break;
            case 2:
                dayOfTheWeek = "Tuesday";
                break;
            case C3:
                dayOfTheWeek = "Wednesday";
                break;
            case C4:
                dayOfTheWeek = "Thursday";
                break;
            case C5:
                dayOfTheWeek = "Friday";
                break;
            case C6:
                dayOfTheWeek = "Saturday";
                break;
            default:
                dayOfTheWeek = "Noneday";
                break;
        }

        return (dayOfTheWeek);
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // variables
        String dayFinal;

        try {
            final Scanner date = new Scanner(System.in);

            System.out.print("Input the date (yyyy-mm-dd): ");

            LocalDate theDate = LocalDate.parse(date.nextLine());

            dayFinal = dateToDay(theDate);

            System.out.println("\nThe day of " + theDate + " is "
                + dayFinal + ".");

        } catch (java.util.InputMismatchException errorCode) {
            // block of code to handle errors
            System.out.println("\nYou have not entered a valid input.");
        }

        System.out.println("\nDone.");
    }
}
