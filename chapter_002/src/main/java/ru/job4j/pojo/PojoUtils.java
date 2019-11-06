package ru.job4j.pojo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PojoUtils {

    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String clearDate = dateFormat.format(new Date());
        return clearDate;
    }
}
