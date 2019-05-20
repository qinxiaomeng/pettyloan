package com.brother.common.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public final class DLClock {
    private DLClock() {
    }

    public static final String TIME_ZONE = "Asia/Shanghai";
    public static final String FORMAT_YYYY = "yyyy";
    public static final String FORMAT_MM = "MM";
    public static final String FORMAT_dd = "dd";
    public static final String FORMAT_YYYY_MM_dd = "yyyy-MM-dd";
    public static final String FORMAT_YYYY_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYYMMdd = "yyyyMMdd";
    public static final String FORMAT_YYYYMMddHHmmss = "yyyyMMddHHmmss";

    public static final Long MILLS_PER_SECOND = 1000l;
    public static final Long MILLS_PER_HOUR = 60 * 60 * 1000l;
    public static final Long MILLS_PER_DAY = 24 * 60 * 60 * 1000l;
    public static final Long MILLS_PER_MONTH = 30 * 24 * 60 * 60 * 1000l;
    public static final Long MILLS_OF_TWO_HOURS = 2 * 60 * 60 * 1000l;
    public static final Long MILLS_OF_NINE_HOURS = 9 * 60 * 60 * 1000l;
    public static final long MILLS_PER_MINUTE = 60 * 1000l;
    public static final int SECONDS_PER_DAY = 24 * 60 * 60;
    public static final int YEAR_IN_DAYS = 365;
    public static final int WEEK_IN_DAYS = 7;

    public static long now() {
        return nowDate().getMillis();
    }

    public static DateTimeZone getTimeZone() {
        return DateTimeZone.forID(TIME_ZONE);
    }

    public static DateTime nowDate() {
        return new DateTime(getTimeZone());
    }

    public static long today() {
        return nowDate().millisOfDay().withMinimumValue().getMillis();
    }

    public static DateTime date(Long timestamp) {
        return new DateTime(timestamp, getTimeZone());
    }

    public static long getBeginOfDay(Long millis) {
        return date(millis).millisOfDay().withMinimumValue().getMillis();
    }

    public static long getEndOfDay(Long millis) {
        return date(millis).millisOfDay().withMaximumValue().getMillis();
    }

    //计算天数,计头计尾
    public static int getDaysWithHeadAndTail(long startMillis, long endMills) {
        if (endMills < startMillis) {
            throw new RuntimeException("参数异常,endMills必须不小于startMillis");
        }
        long maxMillisOfFirstDay = getEndOfDay(startMillis);
        if (maxMillisOfFirstDay > endMills) {
            return 1;
        }
        long leftMillis = endMills - maxMillisOfFirstDay;
        int leftDays = (int) (leftMillis % MILLS_PER_DAY == 0 ? leftMillis / MILLS_PER_DAY : (leftMillis / MILLS_PER_DAY + 1));
        return leftDays + 1;
    }

    public static int getDaysBetween(Long startMillis, Long endMills) {
        return Days.daysBetween(date(startMillis), date(endMills)).getDays() + 1;
    }

    public static int getDaysWithHeadBetween(Long startMillis, Long endMills) {
        if (endMills < startMillis) {
            throw new RuntimeException("参数异常,endMills必须不小于startMillis");
        }
        int days = Days.daysBetween(date(startMillis), date(endMills)).getDays();
        if (days == 0) {
            days++;
        }
        return days;
    }

    public static int getMonthsBetween(Long startMillis, Long endMills) {
        return Months.monthsBetween(date(startMillis), date(endMills)).getMonths() + 1;
    }

    public static String tsToString(Long timestamp) {
        return tsToString(timestamp, FORMAT_YYYY_MM_dd_HH_mm_ss);
    }

    public static String tsToString(Long timestamp, String format) {
        if (null == timestamp) {
            return null;
        }
        return date(timestamp).toString(DateTimeFormat.forPattern(format));
    }

    public static String tsToString(Long timestamp, DateTimeFormatter format) {
        if (null == timestamp) {
            return null;
        }
        return date(timestamp).toString(format);
    }

    public static DateTime parse(String dateTimeStr, String format) {
        return DateTimeFormat.forPattern(format).withZone(getTimeZone()).parseDateTime(dateTimeStr);
    }
}
