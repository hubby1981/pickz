package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class BitmapHelper {


    public static int  drawIn(Canvas canvas, Bitmap bitmap, Rect display, int x) {
        if(bitmap!=null) {
            Rect source = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            display = new Rect(display.left + x, display.top + x, display.right - x, display.bottom - x);
            canvas.drawBitmap(bitmap, source, display, null);
            return x+display.width();
        }
        return 0;
    }
}
