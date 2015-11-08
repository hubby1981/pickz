package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by marcel.weissgerber on 06.11.2015.
 */
public class SocialMenuCircles {
    protected static CircleCollection collection;
    private static String text = "pick_social_";

    static {
        collection = new CircleCollection();
        init();
    }

    private static void init() {
        collection.add(ImageLoader.createMenuItem("Google+", text.concat("google"), Values.BACK_SOCIAL, new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = SocialMenuCirclesGoogle.get();

            }
        }));
        collection.add(ImageLoader.createMenuItem("Facebook", text.concat("facebook"), Values.BACK_SOCIAL));
        collection.add(ImageLoader.createMenuItem("Instagram", text.concat("instagram"), Values.BACK_SOCIAL));
        collection.add(ImageLoader.createMenuItem("Twitter", text.concat("twitter"), Values.BACK_SOCIAL));

    }

    public static CircleCollection get() {
        return collection;
    }
}

