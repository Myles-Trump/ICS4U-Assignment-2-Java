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
    * Numerical constants.
    */
    public static final int C4 = 4;
    public static final int C7 = 7;
    public static final int C100 = 100;
    public static final int C400 = 400;
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
    public static String dateToDay(LocalDate theDate) {

        int theYear = theDate.getYear();
        int theMonth = theDate.getMonthValue();
        int theDay = theDate.getDayOfMonth();
        int centuryCode = (int) (theYear / C1000);
        int shortYear = (theYear - ((int) (theYear / C100)) * C100);
        int yearDiv = (int) (shortYear / TOTALMONTHS);
        int yearMod = shortYear % TOTALMONTHS;
        int yearQuotient = (int) (yearMod / yearDiv);
        int doomsdaySubtotal = centuryCode + yearDiv + yearMod + yearQuotient;
        int doomsdayWeekday = (int) (doomsdaySubtotal % C7);

        int doomsdayDay = doomsdayDates[theMonth - 1];

        if ((((theYear % C4 == 0) && (theYear % C100 != 0)) ||
            (theYear % C400 == 0)) && (theMonth == 1 || theMonth == 2)) {

            doomsdayDay = doomsdayDay + 1;
        }

        int dayOffset = theDay - doomsdayDay;
        int dayOfTheWeekInt = dayOffset % C7;

        String dayOfTheWeek = "Placeholder";
        switch(dayOfTheWeekInt) {
            case 0:
                dayOfTheWeek = "Sunday";
                break;
            case 1:
                dayOfTheWeek = "Monday";
                break;
            case 2:
                dayOfTheWeek = "Tuesday";
                break;
            case 3:
                dayOfTheWeek = "Wednesday";
                break;
            case 4:
                dayOfTheWeek = "Thursday";
                break;
            case 5:
                dayOfTheWeek = "Friday";
                break;
            case 6:
                dayOfTheWeek = "Saturday";
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

        final Scanner date = new Scanner(System.in);

        System.out.print("Input the date (yyyy-mm-dd): ");

        LocalDate theDate = LocalDate.parse(date.nextLine());

        dayFinal = dateToDay(theDate);

        System.out.println("\nThe day of " + theDate + " is "
            + dayFinal + ".");
        System.out.println("\nDone.");
    }
}
