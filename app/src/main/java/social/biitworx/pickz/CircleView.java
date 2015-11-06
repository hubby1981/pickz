package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class CircleView extends ComposeView {
    Rect plus = null;
    Rect minus = null;

    private CircleCollection collection = new CircleCollection();

    public CircleView() {
        CircleCollection collection = new CircleCollection();

        int color1 = Color.argb(255, 200, 20, 160);
        int color2 = Color.argb(255, 70, 20, 200);
        int color3 = Color.argb(255, 120, 60, 20);
        int color4 = Color.argb(255, 200, 60, 20);

        Bitmap bitmap1 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_coffee);
        Bitmap bitmap2 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_work);
        Bitmap bitmap3 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_train);
        Bitmap bitmap4 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_bed);

        collection.add(new CircleItem(bitmap1).text("coffee").count(0).max(5).limit(10).color(color1) );
        collection.add(new CircleItem(bitmap2).text("work").units("hours").count(4).limit(10).color(color2) );
        collection.add(new CircleItem(bitmap3).text("fitness").count(2).units("hours").limit(3).color(color3) );
        collection.add(new CircleItem(bitmap4).text("bed").count(12).units("hours").limit(14).color(color4) );
        collection.add(new CircleItem(bitmap1).text("coffee").count(0).max(5).limit(10).color(color1) );
        collection.add(new CircleItem(bitmap2).text("work").units("hours").count(4).limit(10).color(color2) );
        collection.add(new CircleItem(bitmap3).text("fitness").count(2).units("hours").limit(3).color(color3) );
        collection.add(new CircleItem(bitmap4).text("bed").count(12).units("hours").limit(14).color(color4) );
        collection.add(new CircleItem(bitmap1).text("coffee").count(0).max(5).limit(10).color(color1) );
        collection.add(new CircleItem(bitmap2).text("work").units("hours").count(4).limit(10).color(color2) );

        this.collection = collection;
    }

    public CircleView(CircleCollection collection) {
        this.collection = collection;
    }

    public <T> T get(BaseCircleItem item){
        return item!=null?(T)item.get():null;
    }
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


        Paint circleFill6 = new Paint();
        circleFill6.setStyle(Paint.Style.FILL);
        circleFill6.setColor(Color.argb(175, 250, 100, 100));


        Paint circleFill3 = new Paint();
        circleFill3.setStyle(Paint.Style.FILL);
        circleFill3.setColor(Color.argb(255, 150, 220, 150));

        Paint circleFill4 = new Paint();
        circleFill4.setStyle(Paint.Style.STROKE);
        circleFill4.setColor(Color.argb(255, 200, 230, 200));

        Paint circleFill2 = new Paint();
        circleFill2.setStyle(Paint.Style.STROKE);
        circleFill2.setColor(Color.argb(255, 120, 200, 120));
        Rect display2 = new Rect(display.left,display.top-display.height()/10,display.right,display.bottom-display.height()/10);

        float diff = (float) (display2.width() / 2.5) - (float) (display2.width() / 2.7);
        circleFill2.setStrokeWidth(diff);
        circleFill4.setStrokeWidth(diff);


        float left = display2.exactCenterX() - (float) (display2.width() / 2.6);
        float top = display2.exactCenterY() - (float) (display2.width() / 2.6);
        float right = display2.exactCenterX() + (float) (display2.width() / 2.6);
        float bottom = display2.exactCenterY() + (float) (display2.width() / 2.6);
        int minutes = DateTimeHelper.getMinutesOfDay();
        int minutes2 = DateTimeHelper.getMinutesOfDay();
        CircleItem c = null;
        if (collection != null) {

            c = get(collection.getExposed());
            if (c != null) {
                if (c.countTime() > 0) {
                    minutes = c.countTime();
                    circleFill2.setColor(c.backcolor);
                }
            }

        }
        canvas.drawArc(left, top, right, bottom, 0, 360, true, circleFill4);


        if (collection != null && collection.rotater == null) {

            canvas.drawArc(left, top, right, bottom, 0, DateTimeHelper.getDayAngle(minutes), true, circleFill2);

        }
        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), (float) (display2.width() / 2.7), circleFill3);
        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), display2.width() / 4, circleFill);

        if(c!=null){
            canvas.drawArc(display2.exactCenterX()-display2.width()/4 , display2.exactCenterY()-display2.width()/4 ,display2.exactCenterX()+display2.width()/4, display2.exactCenterY()+display2.width()/4, 0,180, true, circleFill6);

        }

        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), (float) (display2.width() / 2.7), circleLine);

        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), (float) (display2.width() / 2.5), circleLine);
        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), display2.width() / 4, circleLine);

        float rc1 = (float) (diff * 2.3);


        if (collection != null) {
            collection.onDraw(canvas, display2, rc1);

            c = get( collection.getExposed());
            if (c != null) {
                drawInfo(canvas, c.name, display2, 0, 30);
                drawInfo(canvas, c.getCounter(), display2, 1.2f, 40);

            } else {
                drawInfo(canvas, new SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date()), display2, 0, 30);
                drawInfo(canvas, new SimpleDateFormat("yyyy-M-d", Locale.ENGLISH).format(new Date()), display2, 1.2f, 40);

            }
        }


    }

    private void drawInfo(Canvas canvas, String text, Rect display, float y, int size) {
        float fx = display.exactCenterX();
        float fy = display.exactCenterY();
        Paint font = new Paint();
        font.setFakeBoldText(true);
        font.setColor(Color.WHITE);
        font.setTextSize(display.height() / size);
        Rect rc = new Rect((int) (fx - display.width() / 4), (int) (fy - display.height() / 4), (int) (fx + display.width() / 4), (int) (fy + display.height() / 4));

        float mm = font.measureText(text);
        fy += y * font.getTextSize();
        plus = new Rect(rc.left, rc.top, rc.right, rc.top + rc.height() / 2);
        minus = new Rect(rc.left, rc.bottom - rc.height() / 2, rc.right, rc.bottom);

        canvas.drawText(text, fx - mm / 2, fy, font);
    }

    @Override
    public void checkTouchDown(Point p) {

        if (collection != null) {
            CircleItem c = get(collection.canRotate(p));


            if (c != null) {
                collection.rotate(c);
            } else {
                CircleItem c1 = get(collection.getExposed());
                if (c1 != null && plus != null && plus.contains(p.x, p.y)) {
                    c1.plus();
                } else if (c1 != null && minus != null && minus.contains(p.x, p.y)) {
                    c1.minus();
                } else {

                    collection.allUnExpose();
                }
            }
        }
    }


}
