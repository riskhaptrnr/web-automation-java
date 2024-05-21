package helper;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GeneratedDate {
    public static String dateTimeBody() {
        String output = null;
        Locale locale = new Locale("id", "ID");
        DateFormat sdf1 = new SimpleDateFormat("MMMM yyyy", locale);
        Date date = new Date();
        try {
            output = sdf1.format(date);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String startDate() {
        String output = null;
        Locale locale = new Locale("id", "ID");
        DateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss", locale);
        Date date = new Date();
        try {
            output = sdf1.format(date);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String startDateList() {
        String output = null;
        Locale locale = new Locale("id", "ID");
        DateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd", locale);
        Date date = new Date();
        try {
            output = sdf1.format(date);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String dateInfo() {
        String output = null;
        Locale locale = new Locale("id", "ID");
        DateFormat sdf1 = new SimpleDateFormat("MMM yyyy", locale);
        Date date = new Date();
        try {
            output = sdf1.format(date);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String endDate() {
        long yourmilliseconds = System.currentTimeMillis() + (long) (1 * 24 * 60 * 60 * 1000);
        String output = null;
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        try {
            Date parseDate = new Date(yourmilliseconds);
            output = sdf.format(parseDate);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String endDateList() {
        long yourmilliseconds = System.currentTimeMillis() + (long) (20 * 24 * 60 * 60 * 1000);
        String output = null;
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        try {
            Date parseDate = new Date(yourmilliseconds);
            output = sdf.format(parseDate);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String dateHistory() {
        long yourmilliseconds = System.currentTimeMillis() + (long) (1 * 24 * 60 * 60 * 1000);
        String output = null;
        Locale locale = new Locale("id", "ID");
        DateFormat sdf1 = new SimpleDateFormat("dd-MMM-YYYY", locale);
        Date date = new Date(yourmilliseconds);
        try {
            output = sdf1.format(date);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String startDateMission() {
        long yourmilliseconds = System.currentTimeMillis() + (long) (0 * 24 * 60 * 60 * 1000);
        String output = null;
        Locale locale = new Locale("id", "ID");
        DateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd", locale);
        Date date = new Date(yourmilliseconds);
        try {
            output = sdf1.format(date);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String endDateMission() {
        long yourmilliseconds = System.currentTimeMillis() + (long) (1 * 24 * 60 * 60 * 1000);
        String output = null;
        Locale locale = new Locale("id", "ID");
        DateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd", locale);
        Date date = new Date(yourmilliseconds);
        try {
            output = sdf1.format(date);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    @Test
    public void test() throws ParseException {
        System.out.println(startDateMission());
    }

    public static String getMonthNameInThreeChars(String date, int index) {
        return date.substring(8, index);
    }
}
