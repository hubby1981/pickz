package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class MenuView extends ComposeView {
    @Override
    public void onDrawChild(Canvas canvas) {

            Rect menu = new Rect(display.left,display.top,display.right,display.height()/10);
            canvas.drawRect(menu, DrawHelper.getNormalMenu());
            int h = menu.height();
            int x =  BitmapHelper.drawIn(canvas, BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.home),new Rect(0,0,h,h),h/10);
            x+=h/4;
            x +=  BitmapHelper.drawIn(canvas, BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.charts),new Rect(x,0,x+h,h),h/10);
        x+=h/4;

        x +=  BitmapHelper.drawIn(canvas, BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.settings),new Rect(x,0,x+h,h),h/10);

        Bitmap last = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.menu);
        BitmapHelper.drawIn(canvas, last,new Rect((menu.right-h)-h/10,0,((menu.right-h)-h/10)+h,h),h/10);
    }
}
