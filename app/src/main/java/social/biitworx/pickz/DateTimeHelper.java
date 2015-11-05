package social.biitworx.pickz;

import java.util.Date;

/**
 * Created by marcel.weissgerber on 05.11.2015.
 */
public class DateTimeHelper {

    public static int getDayAngle(int minutes){
        return minutes / 4 ;
    }


    public static int getMinutesOfDay()
    {
       Date d = new Date();
        int minutes = 0;

        minutes = (d.getHours()*60)+d.getMinutes();

        return minutes;

    }


}
