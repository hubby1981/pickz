package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SocialMenuCirclesGoogle {

    protected static CircleCollection collection;

    static
    {
        collection = new CircleCollection();
        init();
    }
    private static void init(){
        Bitmap bitmap1 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_social_google_share);
        Bitmap bitmap2 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_social_google_locate);
        Bitmap bitmap3 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_back);


        collection.add(new MenuCircleItem(bitmap1).color(Values.BACK_SOCIAL).text("Upload").exposing(true));
        collection.add(new MenuCircleItem(bitmap2).color(Values.BACK_SOCIAL).text("Locate"));
        collection.add(new MenuCircleItem(bitmap3).color(Values.BACK_SOCIAL).text("Back").exposing(false).action(new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = SocialMenuCircles.get();
            }
        }));


    }

    public static CircleCollection get(){
        return collection;
    }
}
