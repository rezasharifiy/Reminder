package com.rag.khavaranmessenger.domian.utility;

import java.util.Date;

public class ConvertDate {
    private JalaliCalendar jalaliCalendar;

    public ConvertDate() {
        jalaliCalendar = new JalaliCalendar();

    }

    private String getDate(Date date) {
        return  jalaliCalendar.getJalaliDate(date);
    }
}
