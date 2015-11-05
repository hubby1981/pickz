package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        circleLine.setColor(Values.BACK_MENU);
        circleLine.setShadowLayer(40, 0, 0, Values.BACK_MENU_SHADOW);
        circleLine.setStrokeWidth(2);
        circleLine.setAntiAlias(true);

        Paint circleFill = new Paint();
        circleFill.setStyle(Paint.Style.FILL);
        circleFill.setColor(Color.argb(255, 100, 200, 100));

        Paint circleFill3 = new Paint();
        circleFill3.setStyle(Paint.Style.FILL);
        circleFill3.setColor(Color.argb(255, 150, 230, 150));

        Paint circleFill2 = new Paint();
        circleFill2.setStyle(Paint.Style.STROKE);
        circleFill2.setColor(Color.argb(255, 100, 250, 100));

        float diff = (float) (display.width() / 2.5) - (float) (display.width() / 2.7);
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

        float rc1 = (float)(diff * 2.3);
        int color1 = Color.argb(255, 200, 20, 160);
        int color2 = Color.argb(255, 70, 20, 200);
        int color3 = Color.argb(255, 120, 60, 20);
        int color4 = Color.argb(255, 200, 60, 20);

        Bitmap bitmap1 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_coffee);
        Bitmap bitmap2 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_work);
        Bitmap bitmap3 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_train);
        Bitmap bitmap4 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_bed);

        drawWithDegree(canvas, 0, rc1,color1,bitmap1);
        drawWithDegree(canvas, 30, rc1,color2,bitmap3);
        drawWithDegree(canvas, 60, rc1,color3,bitmap2);
        drawWithDegree(canvas, 90, rc1,color4,bitmap4);


    }

    private void drawWithDegree(Canvas canvas, int degree, float size,int color,Bitmap icon) {
        float xc1 = (float) Math.sin(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float yc1 = (float) Math.cos(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float x = display.exactCenterX() + xc1;
        float y = display.exactCenterY() - yc1;
        float w = (float)(size/1.1);
        Rect rc = new Rect((int)(x-w/2),(int)(y-w/2),(int)(x+w/2),(int)(y+w/2));

        drawSmallCircle(canvas, x, y, size,color);

        BitmapHelper.drawIn(canvas,icon,rc,0);
    }

    private void drawSmallCircle(Canvas canvas, float x, float y, float radius,int color) {
        Paint circleLine = new Paint();
        circleLine.setStyle(Paint.Style.FILL);
        circleLine.setColor(color);
        circleLine.setShadowLayer(10, 0, 0, Color.BLACK);
        circleLine.setStrokeWidth(2);
        circleLine.setAntiAlias(true);
        canvas.drawCircle(x, y, radius, circleLine);


    }

}
