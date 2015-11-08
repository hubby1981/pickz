package social.biitworx.pickz;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by marcel.weissgerber on 05.11.2015.
 */
public class DateTimeHelper {

    public static int getDayAngle(int minutes){
        return minutes / 4 ;
    }
    public static float getMonthAngle(int days){
        return days * 11.35f ;
    }

    public static int getYearAngle(int days){
        return (int)(days * 0.98901f) ;
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


        return new GregorianCalendar().get(Calendar.DAY_OF_MONTH);

    }

    public static int getDaysOfYear()
    {
        return new GregorianCalendar().get(Calendar.DAY_OF_YEAR);


    }
}
