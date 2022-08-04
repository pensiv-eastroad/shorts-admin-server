package ai.pensiv.shorts.util;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    public static long getBetweenDays(String firstTime, String secondTime, String pattern){
        DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
        Days checkDays = Days.daysBetween(dtf.parseDateTime(firstTime), dtf.parseDateTime(secondTime));
        return checkDays.getDays();
    }

    public static int getBetweenWeeks(String firstTime, String secondTime, String pattern){
        DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
        Weeks weeks = Weeks.weeksBetween(dtf.parseDateTime(firstTime), dtf.parseDateTime(secondTime));
        return weeks.getWeeks();
    }

    public static int getBetweenMonths(String firstTime, String secondTime, String pattern){
        DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
        Months months = Months.monthsBetween(dtf.parseDateTime(firstTime), dtf.parseDateTime(secondTime));
        return months.getMonths();
    }

    public static String getFormattedDate(DateTime sourceData, String delimiter){
        List<String> dayPartList = Lists.newArrayList(String.valueOf(sourceData.getYear()),
                Strings.padStart(String.valueOf(sourceData.getMonthOfYear()), 2, '0'),
                Strings.padStart(String.valueOf(sourceData.getDayOfMonth()), 2, '0'));
        return Joiner.on(delimiter).join(dayPartList);
    }

    public static Date dateFromString(String dateString, String format, String timezone) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
            if (timezone == null) sdf.setTimeZone(TimeZone.getDefault());
            else sdf.setTimeZone(TimeZone.getTimeZone(timezone));
            return sdf.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
