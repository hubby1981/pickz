package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class MenuView extends ComposeView {

    Rect highRect = null;
    @Override
    public void onDrawChild(Canvas canvas) {

        Rect menu = new Rect(display.left, display.top, display.right, display.height() / 10);
        canvas.drawRect(menu, DrawHelper.getNormalMenu());
        int h = (int) (menu.height() / 1.6);
        int y = 0+h/3;
        Rect homeRect = new Rect(2, y, h, h + y);
        int x = BitmapHelper.drawIn(canvas, BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.home), homeRect, h / 10);
        x += h;
        Rect chartsRect = new Rect(x, y, x + h, h+y);

        x += BitmapHelper.drawIn(canvas, BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.charts), chartsRect, h / 10);
        x += h;

        Rect settingsRect = new Rect(x, y, x + h, h+y);
        x += BitmapHelper.drawIn(canvas, BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.settings), settingsRect, h / 10);

        Bitmap last = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.menu);
        Rect menuRect =  new Rect((menu.right - h) - h / 10, y, ((menu.right - h) - h / 10) + h, h+y);
        BitmapHelper.drawIn(canvas, last,menuRect, h / 10);

        highRect = homeRect;
        Rect high = new Rect(highRect.left-h/2,menu.bottom-h/10,highRect.right+h/2,menu.bottom);

        canvas.drawRect(high, DrawHelper.getHighMenu());

        Paint font = new Paint();
        font.setTextSize(h / 4);
        font.setColor(Color.WHITE);
        font.setStyle(Paint.Style.FILL);
        font.setFakeBoldText(true);
        canvas.drawText("Dashboard", homeRect.left + h / 14, h / 4, font);
        canvas.drawText("Charts", chartsRect.left+h/10, h/4, font);
        canvas.drawText("Settings", settingsRect.left+h/14, h/4, font);
        canvas.drawText("Menu", menuRect.left+h/6, h/4, font);

    }

    @Override
    public void checkTouchDown(Point p) {

    }
}
