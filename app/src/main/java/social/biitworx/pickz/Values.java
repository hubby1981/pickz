package social.biitworx.pickz;

import android.graphics.Color;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class Values {

    public static int TRANSPARENT = 255;
    public static int BACK_NORMAL=Color.argb(TRANSPARENT,150,200,150);
    public static int BACK_MENU=Color.argb(TRANSPARENT,100,150,100);
    public static int BACK_MENU_SHADOW=Color.argb(TRANSPARENT,0,50,0);
    public static int BACK_MENU_HIGH=Color.argb(TRANSPARENT,50,200,50);


    public static int BACK_CIRCLE_TODAY = Color.argb(TRANSPARENT, 100, 180, 100); // inner circle
    public static int BACK_CIRCLE_INNER_TODAY = Color.argb(TRANSPARENT, 100, 180, 100);  //used time
    public static int BACK_CIRCLE_OUTER_TODAY = Color.argb(TRANSPARENT,  150, 220, 150); //unsed time
    public static int BACK_CIRCLE_TIME_TODAY = Color.argb(TRANSPARENT, 180, 240, 180);  //outer Circle
    public static int BACK_CIRCLE_UNTIME_TODAY = Color.argb(TRANSPARENT, 230, 100, 100); // minus half circle

    public static int BACK_CIRCLE_MONTH = Color.argb(TRANSPARENT, 100, 170,180); // inner circle
    public static int BACK_CIRCLE_INNER_MONTH = Color.argb(TRANSPARENT,100, 170,180);  //used time
    public static int BACK_CIRCLE_OUTER_MONTH= Color.argb(TRANSPARENT,  160,220,230); //unsed time
    public static int BACK_CIRCLE_TIME_MONTH = Color.argb(TRANSPARENT, 180, 230, 240);  //outer Circle
    public static int BACK_CIRCLE_UNTIME_MONTH = Color.argb(TRANSPARENT, 230, 100, 100); // minus half circle

    public static int BACK_CIRCLE_YEAR = Color.argb(TRANSPARENT, 180,110,0); // inner circle
    public static int BACK_CIRCLE_INNER_YEAR = Color.argb(TRANSPARENT,180,110,0);  //used time
    public static int BACK_CIRCLE_OUTER_YEAR= Color.argb(TRANSPARENT,  250,200,140); //unsed time
    public static int BACK_CIRCLE_TIME_YEAR = Color.argb(TRANSPARENT, 250,230,210);  //outer Circle
    public static int BACK_CIRCLE_UNTIME_YEAR = Color.argb(TRANSPARENT, 230, 100, 100); // minus half circle

    public static int BACK_PERSONAL = Color.argb(TRANSPARENT, 70,150,0);
    public static int BACK_SPORT = Color.argb(TRANSPARENT, 80,50,0);
    public static int BACK_VEHICLES = Color.argb(TRANSPARENT, 150,50,250);
    public static int BACK_DRINKFOOD = Color.argb(TRANSPARENT, 200,160,40);
    public static int BACK_SOCIAL = Color.argb(TRANSPARENT, 30,180,220);
    public static int BACK_PLAY = Color.argb(TRANSPARENT, 220,30,180);

    public static int BACK_CIRCLE= Color.argb(TRANSPARENT, 180,230,180);
    public static int BACK_CIRCLE2= Color.argb(TRANSPARENT, 100,180,100);



    public static CircleColors get(int state){
        switch (state){
            case 1:
                return new CircleColors().inner(BACK_CIRCLE_MONTH).used(BACK_CIRCLE_INNER_MONTH).unused(BACK_CIRCLE_OUTER_MONTH).outer(BACK_CIRCLE_TIME_MONTH).minus(BACK_CIRCLE_UNTIME_MONTH);
            case 2:
                return new CircleColors().inner(BACK_CIRCLE_YEAR).used(BACK_CIRCLE_INNER_YEAR).unused(BACK_CIRCLE_OUTER_YEAR).outer(BACK_CIRCLE_TIME_YEAR).minus(BACK_CIRCLE_UNTIME_YEAR);

            default:
                return new CircleColors().inner(BACK_CIRCLE_TODAY).used(BACK_CIRCLE_INNER_TODAY).unused(BACK_CIRCLE_OUTER_TODAY).outer(BACK_CIRCLE_TIME_TODAY).minus(BACK_CIRCLE_UNTIME_TODAY);
        }
    }

}

