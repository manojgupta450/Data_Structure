package com.manu.Array;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import static java.time.ZoneOffset.UTC;
import static java.time.temporal.ChronoUnit.MINUTES;

public class Test {
    public static void main(String args[]) {
        B b = new B();
        C c = new C();

        System.out.println(b.getName());
        System.out.println(c.getName());


        // Create a default calendar
        Calendar cal = Calendar.getInstance();
        System.out.println();
        System.out.println("\nCurrent Date and Time:" + cal.getTime());
        int actualMaxYear = cal.getActualMaximum(Calendar.YEAR);
        int actualMaxMonth = cal.getActualMaximum(Calendar.MONTH);
        int actualMaxWeek = cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
        int actualMaxDate = cal.getActualMaximum(Calendar.DATE);

        System.out.println("Actual Maximum Year: "+actualMaxYear);
        System.out.println("Actual Maximum Month: "+actualMaxMonth);
        System.out.println("Actual Maximum Week of Year: "+actualMaxWeek);
        System.out.println("Actual Maximum Date: "+actualMaxDate+"\n");
        System.out.println();

        Date d = new Date();
        System.out.println("Current date : " + d);
        System.out.println("Current time-zone offset is : " + d.getTimezoneOffset());

        ZonedDateTime zonedStartDate = getServerTimeAtInputDate(d).plus(-1000000000, MINUTES);

        System.out.println("Current zonedStartDate  : " + zonedStartDate);

    }

    private static ZonedDateTime getServerTimeAtInputDate(Date date) {
        return date.toInstant().atZone(UTC).toLocalDate().atStartOfDay(UTC);
    }
}
