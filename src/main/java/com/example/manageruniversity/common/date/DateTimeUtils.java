package com.example.manageruniversity.common.date;

import java.time.LocalTime;

public class DateTimeUtils {


    public static boolean isBetween(LocalTime target, LocalTime start, LocalTime end) {
        return start.isBefore(target) && end.isAfter(target);
    }

}
