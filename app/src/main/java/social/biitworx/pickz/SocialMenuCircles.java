package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by marcel.weissgerber on 06.11.2015.
 */
public class SocialMenuCircles  {
    protected static CircleCollection collection;

static
    {
        collection = new CircleCollection();
        init();
    }
    private static void init(){
        Bitmap bitmap1 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_social_google);
        Bitmap bitmap2 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_social_facebook);
        Bitmap bitmap3 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_social_instagram);
        Bitmap bitmap4 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_social_twitter);

        collection.add(new MenuCircleItem(bitmap1).color(Values.BACK_SOCIAL).exposing(true).text("Google+").action(new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = SocialMenuCirclesGoogle.get();
            }
        }));
        collection.add(new MenuCircleItem(bitmap2).color(Values.BACK_SOCIAL).text("Facebook"));
        collection.add(new MenuCircleItem(bitmap3).color(Values.BACK_SOCIAL).text("Instagram"));
        collection.add(new MenuCircleItem(bitmap4).color(Values.BACK_SOCIAL).text("Twitter"));

    }

    public static CircleCollection get(){
        return collection;
    }
}

