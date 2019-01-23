package com.faina._12_30;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main19 {

    public static void main( String [] args )   {


        LocalDate startDate = LocalDate.of(1901, 1, 1);
        LocalDate endDate = LocalDate.of(2000, 12, 31);

        List<LocalDate> sundays = new ArrayList<> ();  // Collect each Sunday found.
        LocalDate nextOrSameSunday = startDate.with ( TemporalAdjusters.nextOrSame ( DayOfWeek.SUNDAY ) );
// Loop while we have a sunday in hand (non-null) AND that sunday is not after our stop date (isBefore or isEqual the stop date).
        while ( ( null != nextOrSameSunday ) & (  ! nextOrSameSunday.isAfter ( endDate ) ) ) {
            sundays.add ( nextOrSameSunday );  //  Remember this sunday.
            nextOrSameSunday = nextOrSameSunday.plusWeeks ( 1 );  // Move to the next Sunday, setting up for next iteration of this loop.
        }

        System.out.println("There are "+sundays.size()+" Sundays are between 01/01/1900 and 31/12/2000");

        List<LocalDate> firstOfMonthSundays = sundays
                .stream()
                .filter(sunday -> sunday.getDayOfMonth() == 1)
                .collect(Collectors.toList());

        System.out.println("There are "+firstOfMonthSundays.size()+" Sundays between 01/01/1900 and 31/12/2000 fail on 1-st day of month");

    }
}
