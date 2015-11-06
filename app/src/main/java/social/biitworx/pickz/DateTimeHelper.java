package social.biitworx.pickz;

import java.util.Date;

/**
 * Created by marcel.weissgerber on 05.11.2015.
 */
public class DateTimeHelper {

    public static int getDayAngle(int minutes){
        return minutes / 4 ;
    }
    public static int getMonthAngle(int days){
        return days / 11 ;
    }

    public static int getYearAngle(int days){
        return days / (int)4f ;
    }
    public static int getMinutesOfDay()
    {
       Date d = new Date();
        int minutes = 0;

        minutes = (d.getHours()*60)+d.getMinutes();

        return minutes;

    }

    public static int getDaysOfMonth()
    {
        Date d = new Date();
        int minutes = 0;

        minutes = d.getDay();

        return minutes;

    }

    public static int getDaysOfYear()
    {
        Date d = new Date();
        int minutes = 0;

        minutes = d.getDay()*30;

        return minutes;

    }
}
