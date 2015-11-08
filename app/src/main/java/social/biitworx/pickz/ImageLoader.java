package social.biitworx.pickz;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

/**
 * Created by marce_000 on 08.11.2015.
 */
public class ImageLoader {


    public static int getId(String icon){
        return MainActivity.context.getResources().getIdentifier(icon,"drawable",MainActivity.context.getPackageName());
    }
    public static Bitmap loadIcon(String icon) {
       return BitmapFactory.decodeResource(MainActivity.context.getResources(),getId(icon));
    }

    public static BaseCircleItem createMenuItem(String name,String icon,int color){
        return new MenuCircleItem(loadIcon(icon)).color(color).text(name);
    }

    public static BaseCircleItem createMenuItem(String name,String icon,int color,Runnable action){
        return new MenuCircleItem(loadIcon(icon)).color(color).text(name).action(action);
    }

    public static BaseCircleItem createMenuItem(String name,String icon,int color,Runnable action,boolean exposing){
        return new MenuCircleItem(loadIcon(icon)).color(color).text(name).action(action).exposing(exposing);
    }
}
