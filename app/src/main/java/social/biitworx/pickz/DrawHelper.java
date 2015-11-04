package social.biitworx.pickz;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class DrawHelper {


    private static Paint BACK_NORMAL = null;
    private static Paint BACK_MENU = null;

    private static Paint BACK_CIRCLE_TODAY = null;

    public static Paint getNormalBack()
    {
        if(BACK_NORMAL==null){
            BACK_NORMAL = new Paint();
            BACK_NORMAL.setStyle(Paint.Style.FILL_AND_STROKE);
            BACK_NORMAL.setColor(Values.BACK_NORMAL);
        }
        return BACK_NORMAL;
    }

    public static Paint getNormalMenu()
    {
        if(BACK_MENU ==null){
            BACK_MENU = new Paint();
            BACK_MENU.setStyle(Paint.Style.FILL_AND_STROKE);
            BACK_MENU.setColor(Values.BACK_MENU);
            BACK_MENU.setShadowLayer(30,0,0, Values.BACK_MENU_SHADOW);
        }
        return BACK_MENU;
    }
}
