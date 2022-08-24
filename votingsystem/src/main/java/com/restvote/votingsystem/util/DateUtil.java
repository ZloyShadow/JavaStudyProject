package com.restvote.votingsystem.util;

import java.time.LocalDate;

public class DateUtil {
    public static LocalDate getDefault(LocalDate date) {
        return date != null ? date : LocalDate.now();
    }
}
