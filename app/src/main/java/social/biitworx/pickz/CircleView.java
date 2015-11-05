package social.biitworx.pickz;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class CircleView extends ComposeView {
    @Override
    public void onDrawChild(Canvas canvas) {


        Paint circleLine = new Paint();
        circleLine.setStyle(Paint.Style.STROKE);
        circleLine.setColor(Values.BACK_MENU_SHADOW);
        circleLine.setShadowLayer(40, 0, 0, Color.BLACK);


        Paint circleFill = new Paint();
        circleFill.setStyle(Paint.Style.FILL);
        circleFill.setColor(Color.argb(255, 150, 190, 220));

        Paint circleFill3 = new Paint();
        circleFill3.setStyle(Paint.Style.FILL);
        circleFill3.setColor(Color.argb(255, 150, 190, 200));

        Paint circleFill2 = new Paint();
        circleFill2.setStyle(Paint.Style.STROKE);
        circleFill2.setColor(Color.argb(255, 150, 190, 240));

        float diff = (float)(display.width() / 2.5)-(float)(display.width() / 2.7);
        circleFill2.setStrokeWidth(diff);

        float left = display.exactCenterX() - (float) (display.width() / 2.6);
        float top = display.exactCenterY() - (float) (display.width() / 2.6);
        float right = display.exactCenterX() + (float) (display.width() / 2.6);
        float bottom = display.exactCenterY() + (float) (display.width() / 2.6);



        canvas.drawArc(left, top, right, bottom, 0, DateTimeHelper.getDayAngle(DateTimeHelper.getMinutesOfDay()), true, circleFill2);

        canvas.drawCircle(display.exactCenterX(), display.exactCenterY(), (float) (display.width() / 2.7), circleFill3);
        canvas.drawCircle(display.exactCenterX(), display.exactCenterY(), display.width() / 4, circleFill);


        canvas.drawCircle(display.exactCenterX(), display.exactCenterY(), (float) (display.width() / 2.7), circleLine);

        canvas.drawCircle(display.exactCenterX(), display.exactCenterY(), (float) (display.width() / 2.5), circleLine);
        canvas.drawCircle(display.exactCenterX(), display.exactCenterY(), display.width() / 4, circleLine);

    }

}
