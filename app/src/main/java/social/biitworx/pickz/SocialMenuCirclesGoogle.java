package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SocialMenuCirclesGoogle {

    protected static CircleCollection collection;
    private static String text="pick_social_google_";
    static
    {
        collection = new CircleCollection();
        init();
    }
    private static void init(){
        collection.add(ImageLoader.createMenuItem("Upload", text.concat("share"), Values.BACK_SOCIAL));
        collection.add(ImageLoader.createMenuItem("Upload",text.concat("locate"),Values.BACK_SOCIAL));
        collection.add(ImageLoader.createMenuItem("Back","pick_back",Values.BACK_SOCIAL,new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = SocialMenuCircles.get();
            }
        },false));

    }

    public static CircleCollection get(){
        return collection;
    }
}
