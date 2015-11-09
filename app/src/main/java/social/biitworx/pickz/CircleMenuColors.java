package social.biitworx.pickz;

import android.graphics.Color;

import java.util.HashMap;

/**
 * Created by marcel.weissgerber on 09.11.2015.
 */
public class CircleMenuColors {
    private static HashMap<String,Integer> colors;

    static{
        colors=new HashMap<>();

        colors.put("7",Values.BACK_CIRCLE_TODAY);
        colors.put("8",Values.BACK_CIRCLE_MONTH);
        colors.put("9",Values.BACK_CIRCLE_YEAR);


        colors.put("1",Values.BACK_PERSONAL);
        colors.put("2",Values.BACK_SPORT);
        colors.put("3",Values.BACK_VEHICLES);
        colors.put("4",Values.BACK_DRINKFOOD);
        colors.put("5",Values.BACK_SOCIAL);
        colors.put("6",Values.BACK_PLAY);
    }

    public static int getColor(String id){
        if(colors.containsKey(id))
            return colors.get(id);

        return Color.argb(255,50,50,50);
    }
}
