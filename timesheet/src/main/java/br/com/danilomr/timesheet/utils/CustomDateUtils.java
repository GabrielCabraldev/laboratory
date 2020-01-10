package br.com.danilomr.timesheet.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateUtils {

    public static LocalDateTime stringToDateTime(final String stringDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(stringDateTime, formatter);
    }

    public static LocalDate stringToDate(final String stringDate) {

        LocalDate date = LocalDate.parse(stringDate);
        return date;
    }

    public static String dateTimeToString(final LocalDateTime dateTime) {

        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
