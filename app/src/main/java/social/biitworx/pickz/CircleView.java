package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import org.json.JSONException;
import org.json.JSONObject;

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
    private DragMenuItem dragMenuItem;

    Rect circle = null;

    public CircleView() {
        CircleCollection collection = new CircleCollection();
        CircleCollection collectionLeft = new CircleCollection();
        final CircleCollection collectionRight = new CircleCollection();

        int color1 = Color.argb(255, 200, 20, 160);
        int color2 = Color.argb(255, 70, 20, 200);
        int color3 = Color.argb(255, 120, 60, 20);
        int color4 = Color.argb(255, 200, 60, 20);



        Bitmap bitmap1 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_coffee);
        Bitmap bitmap2 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_work);
        Bitmap bitmap3 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_train);
        Bitmap bitmap4 = BitmapFactory.decodeResource(MainActivity.context.getResources(), R.drawable.pick_bed);





        collectionLeft.readMenuCircle(FileHelper.getObject("menu_circles.txt"));

        collection.add(new CircleItem(bitmap1).count(0).max(5).limit(10).color(color1).text("coffee"));
        collection.add(new CircleItem(bitmap2).units("hours").count(4).limit(10).color(color2).text("work"));
        collection.add(new CircleItem(bitmap3).count(2).units("hours").limit(3).color(color3).text("fitness"));
        collection.add(new CircleItem(bitmap4).count(12).units("hours").limit(14).color(color4).text("bed"));

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
        circleLine.setColor(Color.argb(100, 50, 50, 50));
        circleLine.setShadowLayer(20, 0, 0, Color.DKGRAY);
        circleLine.setStrokeWidth(5);
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
        circle = new Rect((int) left + display2.width() / 8, (int) top + display2.width() / 8, (int) right - display2.width() / 8, (int) bottom - display2.width() / 8);
        int minutes = State == 0 ? DateTimeHelper.getMinutesOfDay() : State == 1 ? DateTimeHelper.getDaysOfMonth() : DateTimeHelper.getDaysOfYear();
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

            int angle = State == 0 ? DateTimeHelper.getDayAngle(minutes) : (int) (State == 1 ? DateTimeHelper.getMonthAngle(minutes) : DateTimeHelper.getYearAngle(minutes));

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
            BaseCircleItem c4 = collection.getExposed();
            if (c4 != null && dragMenuItem != null)
                c4.expose = false;
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
        int mm = 10;
        Rect rcDown11 = new Rect(rcDown.left - rcDown.width() / mm, rcDown.top - rcDown.width() / mm, (rcDown.right - rcDown.width() / 2) + rcDown.width() / mm, rcDown.bottom + rcDown.width() / mm);
        Rect rcDown22 = new Rect((rcDown.left + rcDown.width() / 2) - rcDown.width() / mm, rcDown.top - rcDown.width() / mm, rcDown.right + rcDown.width() / mm, rcDown.bottom + rcDown.width() / mm);


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

            canvas.drawCircle(rcDown1.exactCenterX(), rcDown1.exactCenterY(), rcDown1.width() / 3, circleFillLeft);
            canvas.drawCircle(rcDown1.exactCenterX(), rcDown1.exactCenterY(), rcDown1.width() / 3, circleLine);


            collectionLeft.onDraw(canvas, rcDown11, rc1 / 1.2f);
            if (c1 != null) {
                drawInfo(canvas, c1.name, rcDown1, 0, 20, false);


            }

            if (collectionRight != null && collectionRight.size() > 0 && c1 != null) {
                BaseCircleItem c2 = collectionRight.getExposed();
                if (c1.expose) {
                    canvas.drawCircle(rcDown2.exactCenterX(), rcDown2.exactCenterY(), (float) (rcDown2.width() / 2.2), circleFillLeft2);
                    canvas.drawCircle(rcDown2.exactCenterX(), rcDown2.exactCenterY(), (float) (rcDown2.width() / 2.2), circleLine);

                    canvas.drawCircle(rcDown2.exactCenterX(), rcDown2.exactCenterY(), rcDown2.width() / 3, circleFillLeft);
                    canvas.drawCircle(rcDown2.exactCenterX(), rcDown2.exactCenterY(), rcDown2.width() / 3, circleLine);

                    collectionRight.onDraw(canvas, rcDown22, rc1 / 1.2f);
                    if (c2 != null) {
                        drawInfo(canvas, c2.name, rcDown2, 0, 20, false);
                        if (dragMenuItem != null) {
                            int si = (int) (rc1);
                            Rect rcDrag = new Rect(dragMenuItem.position.x - si / 2, dragMenuItem.position.y - si / 2, dragMenuItem.position.x + si / 2, dragMenuItem.position.y + si / 2);
                            collectionRight.drawSmallCircle(canvas, dragMenuItem.position.x, dragMenuItem.position.y, si, dragMenuItem.item.backcolor);
                            BitmapHelper.drawIn(canvas, dragMenuItem.item.icon, rcDrag, 0);

                        }

                    } else {
                        drawInfo(canvas, "Select", rcDown2, 0, 20, false);

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
                    if (c1.getCount() <= 0) {
                        collection.remove(c1);
                    }
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

    @Override
    public void checkMoveDown(Point p) {

        if (collectionRight != null) {
            BaseCircleItem item = collectionRight.getExposed();

            if (item != null && dragMenuItem == null) {
                if (collectionRight.drag(item, p.x, p.y)) {
                    dragMenuItem = new DragMenuItem(item.<MenuCircleItem>get(), p);
                }
            }

            if (dragMenuItem != null) {
                dragMenuItem.position = p;
            }
        }
    }

    @Override
    public void releaseDrag() {

        if (dragMenuItem != null) {

            if (circle.contains(dragMenuItem.position.x, dragMenuItem.position.y)) {

                if (!collection.contains(dragMenuItem.item)) {
                    dragMenuItem.item.expose = true;
                    collection.add(new CircleItem(dragMenuItem.item.icon).count(1).limit(10).color(dragMenuItem.item.backcolor).text(dragMenuItem.item.name).oldid(dragMenuItem.item.id));
                } else {
                    CircleItem c = collection.getId(dragMenuItem.item.id);
                    if (c != null) {
                        c.count(c.getCount() + 1);
                    }
                }
                BaseCircleItem item = collection.getId(dragMenuItem.item.id);
                if (item != null) {
                    if (item.degree == 0)
                        item.expose = true;
                    else
                        collection.rotate(item);

                }

            }
            dragMenuItem = null;
        }
    }

}
