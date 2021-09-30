package com.petclinic.data.databuilders.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static String getTodayDate() {
        return LocalDate.now().format(DATE_FORMATTER);
    }
}
