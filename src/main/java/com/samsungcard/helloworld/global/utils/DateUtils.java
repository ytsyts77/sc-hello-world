package com.samsungcard.helloworld.global.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }
}
