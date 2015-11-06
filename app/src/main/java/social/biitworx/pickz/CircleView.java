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
    private CircleCollection collectionLeft = new CircleCollection();
    public static CircleCollection collectionRight = new CircleCollection();

    public static int State = 0;

    public CircleView() {
        CircleCollection collection = new CircleCollection();
        CircleCollection collectionLeft = new CircleCollection();
        final CircleCollection collectionRight = new CircleCollection();

        int color1 = Color.argb(255, 200, 20, 160);
        int color2 = Color.argb(255, 70, 20, 200);
        int color3 = Color.argb(255, 120, 60, 20);
        int color4 = Color.argb(255, 200, 60, 20);

        int color5 = Values.BACK_CIRCLE_TODAY;
        int color6 = Values.BACK_CIRCLE_MONTH;
        int color7 = Values.BACK_CIRCLE_YEAR;
        int color8 = Values.BACK_PERSONAL;
        int color9 = Values.BACK_SPORT;
        int color10 = Values.BACK_VEHICLES;
        int color11 = Values.BACK_DRINKFOOD;
        int color12 = Values.BACK_SOCIAL;
        int color13 = Values.BACK_PLAY;


        Bitmap bitmap1 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_coffee);
        Bitmap bitmap2 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_work);
        Bitmap bitmap3 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_train);
        Bitmap bitmap4 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_bed);


        Bitmap bitmap5 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_day);
        Bitmap bitmap6 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_month);
        Bitmap bitmap7 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_year);
        Bitmap bitmap8 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_personal);
        Bitmap bitmap9 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_sport);
        Bitmap bitmap10 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_vehicles);
        Bitmap bitmap11 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_drinkfood);
        Bitmap bitmap12 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_social);
        Bitmap bitmap13 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_play);


        collection.add(new CircleItem(bitmap1).count(0).max(5).limit(10).color(color1).text("coffee"));
        collection.add(new CircleItem(bitmap2).units("hours").count(4).limit(10).color(color2).text("work"));
        collection.add(new CircleItem(bitmap3).count(2).units("hours").limit(3).color(color3).text("fitness"));
        collection.add(new CircleItem(bitmap4).count(12).units("hours").limit(14).color(color4).text("bed"));

        collectionLeft.add(new MenuCircleItem(bitmap5).color(color5).exposed(true).text("Today").action(new Runnable() {
            @Override
            public void run() {
                State = 0;
                CircleView.collectionRight = new CircleCollection();

            }
        }));
        collectionLeft.add(new MenuCircleItem(bitmap6).color(color6).text("Month").action(new Runnable() {
            @Override
            public void run() {
                State = 1;
                CircleView.collectionRight = new CircleCollection();

            }
        }));
        collectionLeft.add(new MenuCircleItem(bitmap7).color(color7).text("Year").action(new Runnable() {
            @Override
            public void run() {
                State = 2;
                CircleView.collectionRight = new CircleCollection();
            }
        }));
        collectionLeft.add(new MenuCircleItem(bitmap8).color(color8).text("Personal").action(new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = new CircleCollection();

            }
        }));
        collectionLeft.add(new MenuCircleItem(bitmap9).color(color9).text("Sport").action(new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = new CircleCollection();

            }
        }));
        collectionLeft.add(new MenuCircleItem(bitmap10).color(color10).text("Vehicle").action(new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = new CircleCollection();

            }
        }));
        collectionLeft.add(new MenuCircleItem(bitmap11).color(color11).text("Food").action(new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = new CircleCollection();

            }
        }));
        collectionLeft.add(new MenuCircleItem(bitmap12).color(color12).text("Social").action(new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = SocialMenuCircles.get();
            }
        }));
        collectionLeft.add(new MenuCircleItem(bitmap13).color(color13).text("Play").action(new Runnable() {
            @Override
            public void run() {
                CircleView.collectionRight = new CircleCollection();

            }
        }));

        this.collection = collection;
        this.collectionLeft = collectionLeft;
        this.collectionRight = collectionRight;


    }

    public CircleView(CircleCollection collection) {
        this.collection = collection;
    }

    public <T> T get(BaseCircleItem item) {
        return item != null ? (T) item.get() : null;
    }

    @Override
    public void onDrawChild(Canvas canvas) {


        Paint circleLine = new Paint();
        circleLine.setStyle(Paint.Style.STROKE);
        circleLine.setColor(Values.BACK_MENU);
        circleLine.setShadowLayer(40, 0, 0, Values.BACK_MENU_SHADOW);
        circleLine.setStrokeWidth(2);
        circleLine.setAntiAlias(true);

        CircleColors colors = Values.get(State);

        Paint circleFill = new Paint();
        circleFill.setStyle(Paint.Style.FILL);
        circleFill.setColor(CircleColors.BACK_CIRCLE_INNER);

        Paint circleFill6 = new Paint();
        circleFill6.setStyle(Paint.Style.FILL);
        circleFill6.setColor(colors.BACK_CIRCLE_MINUS);


        Paint circleFill3 = new Paint();
        circleFill3.setStyle(Paint.Style.FILL);
        circleFill3.setColor(colors.BACK_CIRCLE_OUTER);

        Paint circleFill4 = new Paint();
        circleFill4.setStyle(Paint.Style.STROKE);
        circleFill4.setColor(colors.BACK_CIRCLE_UNUSED);

        Paint circleFill2 = new Paint();
        circleFill2.setStyle(Paint.Style.STROKE);
        circleFill2.setColor(colors.BACK_CIRCLE_USED);

        Rect display2 = new Rect(display.left, display.top - display.height() / 10, display.right, display.bottom - display.height() / 10);

        float diff = (float) (display2.width() / 2.5) - (float) (display2.width() / 2.7);
        circleFill2.setStrokeWidth(diff);
        circleFill4.setStrokeWidth(diff);


        float left = display2.exactCenterX() - (float) (display2.width() / 2.6);
        float top = display2.exactCenterY() - (float) (display2.width() / 2.6);
        float right = display2.exactCenterX() + (float) (display2.width() / 2.6);
        float bottom = display2.exactCenterY() + (float) (display2.width() / 2.6);
        int minutes = DateTimeHelper.getMinutesOfDay();
        int minutes2 = State == 0 ? DateTimeHelper.getMinutesOfDay() : State == 1 ? DateTimeHelper.getDaysOfMonth() : DateTimeHelper.getDaysOfYear();
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

            int angle = State == 0 ? DateTimeHelper.getDayAngle(minutes) : State == 1 ? DateTimeHelper.getMonthAngle(minutes) : DateTimeHelper.getYearAngle(minutes);
            ;
            canvas.drawArc(left, top, right, bottom, 0, angle, true, circleFill2);

        }
        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), (float) (display2.width() / 2.7), circleFill3);
        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), display2.width() / 4, circleFill);

        if (c != null) {
            canvas.drawArc(display2.exactCenterX() - display2.width() / 4, display2.exactCenterY() - display2.width() / 4, display2.exactCenterX() + display2.width() / 4, display2.exactCenterY() + display2.width() / 4, 0, 180, true, circleFill6);

        }

        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), (float) (display2.width() / 2.7), circleLine);

        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), (float) (display2.width() / 2.5), circleLine);
        canvas.drawCircle(display2.exactCenterX(), display2.exactCenterY(), display2.width() / 4, circleLine);

        float rc1 = (float) (diff * 2.3);


        if (collection != null) {
            collection.onDraw(canvas, display2, rc1);

            c = get(collection.getExposed());
            if (c != null) {
                drawInfo(canvas, c.name, display2, -0.3f, 30, true);
                drawInfo(canvas, c.getCounter(), display2, 1.4f, 40, false);

            } else {
                if (State == 0) {
                    drawInfo(canvas, new SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date()), display2, 0, 30, false);
                    drawInfo(canvas, new SimpleDateFormat("yyyy-M-d", Locale.ENGLISH).format(new Date()), display2, 1.2f, 40, false);
                } else if (State == 1) {
                    drawInfo(canvas, new SimpleDateFormat("MMM", Locale.ENGLISH).format(new Date()), display2, 0, 30, false);
                    drawInfo(canvas, "Day ".concat(new SimpleDateFormat("d", Locale.ENGLISH).format(new Date())), display2, 1.2f, 40, false);

                } else if (State == 2) {
                    drawInfo(canvas, new SimpleDateFormat("yyyy", Locale.ENGLISH).format(new Date()), display2, 0, 30, false);
                    drawInfo(canvas, "Day ".concat(String.valueOf(DateTimeHelper.getDaysOfYear())), display2, 1.2f, 40, false);

                }
            }
        }


        Rect rcDown = new Rect(display2.left, (int) (display.bottom - display.height() / 2.4), display2.right, display.bottom);
        Rect rcDown1 = new Rect(rcDown.left, rcDown.top, rcDown.right - rcDown.width() / 2, rcDown.bottom);
        Rect rcDown2 = new Rect(rcDown.left + rcDown.width() / 2, rcDown.top, rcDown.right, rcDown.bottom);


        if (collectionLeft != null) {
            BaseCircleItem c1 = collectionLeft.getExposed();

            Paint circleFillLeft = new Paint();
            circleFillLeft.setStyle(Paint.Style.FILL);
            circleFillLeft.setColor(c1 != null ? c1.backcolor : Values.BACK_CIRCLE2);

            Paint circleFillLeft2 = new Paint();
            circleFillLeft2.setStyle(Paint.Style.FILL);
            circleFillLeft2.setColor(Values.BACK_CIRCLE);


            canvas.drawCircle(rcDown1.exactCenterX(), rcDown1.exactCenterY(), (float) (rcDown1.width() / 2.2), circleFillLeft2);
            canvas.drawCircle(rcDown1.exactCenterX(), rcDown1.exactCenterY(), (float) (rcDown1.width() / 2.2), circleLine);

            canvas.drawCircle(rcDown1.exactCenterX(), rcDown1.exactCenterY(), rcDown1.width() / 4, circleFillLeft);
            canvas.drawCircle(rcDown1.exactCenterX(), rcDown1.exactCenterY(), rcDown1.width() / 4, circleLine);


            collectionLeft.onDraw(canvas, rcDown1, rc1 / 1.75f);
            if (c1 != null) {
                drawInfo(canvas, c1.name, rcDown1, 0, 20, false);


            }

            if (collectionRight != null && collectionRight.size() > 0 && c1 != null) {
                BaseCircleItem c2 = collectionRight.getExposed();
                if (c1.expose) {
                    canvas.drawCircle(rcDown2.exactCenterX(), rcDown2.exactCenterY(), (float) (rcDown2.width() / 2.2), circleFillLeft2);
                    canvas.drawCircle(rcDown2.exactCenterX(), rcDown2.exactCenterY(), (float) (rcDown2.width() / 2.2), circleLine);

                    canvas.drawCircle(rcDown2.exactCenterX(), rcDown2.exactCenterY(), rcDown2.width() / 4, circleFillLeft);
                    canvas.drawCircle(rcDown2.exactCenterX(), rcDown2.exactCenterY(), rcDown2.width() / 4, circleLine);

                    collectionRight.onDraw(canvas, rcDown2, rc1 / 1.75f);
                    if (c2 != null) {
                        drawInfo(canvas, c2.name, rcDown2, 0, 20, false);


                    }
                }
            }
        }

    }

    private void drawInfo(Canvas canvas, String text, Rect display, float y, int size, boolean pm) {
        float fx = display.exactCenterX();
        float fy = display.exactCenterY();
        Paint font = new Paint();
        font.setFakeBoldText(true);
        font.setColor(Color.WHITE);
        font.setTextSize(display.height() / size);
        Rect rc = new Rect((int) (fx - display.width() / 4), (int) (fy - display.height() / 4), (int) (fx + display.width() / 4), (int) (fy + display.height() / 4));

        float mm = font.measureText(text);
        fy += y * font.getTextSize();
        if (pm) {
            plus = new Rect(rc.left, rc.top, rc.right, rc.top + rc.height() / 2);
            minus = new Rect(rc.left, rc.bottom - rc.height() / 2, rc.right, rc.bottom);
        }


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

        if (collectionLeft != null) {
            MenuCircleItem c = get(collectionLeft.canRotate(p));


            if (c != null) {
                collectionLeft.rotate(c);
            } else {
                MenuCircleItem c1 = get(collectionLeft.getExposed());

            }
        }

        if (collectionRight != null && collectionRight.size() > 0) {
            MenuCircleItem c = get(collectionRight.canRotate(p));


            if (c != null) {
                collectionRight.rotate(c);
            } else {
                MenuCircleItem c1 = get(collectionRight.getExposed());


            }
        }
    }


}
