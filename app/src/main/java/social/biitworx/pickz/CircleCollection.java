package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by marcel.weissgerber on 05.11.2015.
 */
public class CircleCollection {
    private int max = 12;
    private List<BaseCircleItem> items = new LinkedList<>();
    private HashMap<BaseCircleItem, Rect> touch = new HashMap<>();
    private Rect display = null;
    public CircleItem rotater = null;
    private boolean leftMove = true;

    public CircleCollection add(BaseCircleItem item) {
        if (items.size() < max) {
            item.degree = items.size() * 30;
            items.add(item);
        }
        return this;
    }

    public boolean isExposedHit(Point p, CircleItem c) {
        return touch != null && touch.containsKey(c) && touch.get(c).contains(p.x, p.y);

    }

    public void onDraw(Canvas canvas, Rect display, float size) {
        touch = new HashMap<>();
        this.display = display;
        if (!mustStopRotate()) {
            for (BaseCircleItem c : items) {
                if (leftMove)
                    c.moveL();
                else c.move();
                c.expose = false;
            }
        }
        for (BaseCircleItem c : items) {
            float yy = 0;
            if (c.expose) yy = size;
            Rect rc = drawWithDegree(canvas, c.degree, size, c.backcolor, c.icon, yy,display);
            if(yy==0)
                drawWithDegree(canvas,10,size/3,c.backcolor,String.valueOf(c.<CircleItem>get().getCount()),size/3,rc);
            touch.put(c, rc);
        }
    }

    private Rect drawWithDegree(Canvas canvas, int degree, float size, int color, Bitmap icon, float yy,Rect display) {
        float xc1 = (float) Math.sin(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float yc1 = (float) Math.cos(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float x = display.exactCenterX() + xc1;
        float y = display.exactCenterY() - yc1;

        y -= yy;
        float w = (float) (size / 1.1);
        Rect rc = new Rect((int) (x - w / 2), (int) (y - w / 2), (int) (x + w / 2), (int) (y + w / 2));
        Rect rc1 = new Rect((int) (x -w), (int) (y - w ), (int) (x + w ), (int) (y + w ));


        drawSmallCircle(canvas, x, y, size, color);
        if (icon != null) {
            BitmapHelper.drawIn(canvas, icon, rc, 0);
        }


        return rc1;
    }

    private Rect drawWithDegree(Canvas canvas, int degree, float size, int color,String text, float yy,Rect display) {
        float xc1 = (float) Math.sin(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float yc1 = (float) Math.cos(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float x = display.exactCenterX() + xc1;
        float y = display.exactCenterY() - yc1;

        y -= yy;
        float w = (float) (size / 1.1);
        Rect rc = new Rect((int) (x - w / 2), (int) (y - w / 2), (int) (x + w / 2), (int) (y + w / 2));
        drawSmallCircle(canvas, x, y, size, color);

        drawInfo(canvas, text, rc, 2, 1.5f);

        return rc;
    }

    private void drawInfo(Canvas canvas, String text, Rect display, float y, float size) {
        float fx = display.exactCenterX();
        float fy = display.exactCenterY();
        Paint font = new Paint();
        font.setFakeBoldText(true);
        font.setColor(Color.WHITE);
        font.setTextSize(display.height() / size);

        float mm = font.measureText(text);
        fy += y * font.getTextSize()/4;

        canvas.drawText(text, fx - mm / 2, fy, font);
    }

    private void drawSmallCircle(Canvas canvas, float x, float y, float radius, int color) {
        Paint circleLine = new Paint();
        circleLine.setStyle(Paint.Style.FILL);
        circleLine.setColor(color);
        circleLine.setShadowLayer(10, 0, 0, Color.BLACK);
        circleLine.setStrokeWidth(2);
        circleLine.setAntiAlias(true);
        canvas.drawCircle(x, y, radius, circleLine);


    }

    public void allUnExpose() {
        for (BaseCircleItem c : items) c.expose = false;
    }

    public BaseCircleItem canRotate(Point p) {

        if (rotater != null) return null;

        for (Map.Entry<BaseCircleItem, Rect> c : touch.entrySet()) {
            if (c.getValue().contains(p.x, p.y)) {
                leftMove = c.getKey().mustMoveL();
                return c.getKey();
            }
        }
        return null;
    }

    public void rotate(CircleItem rotater) {
        this.rotater = rotater;
    }

    public boolean mustStopRotate() {
        boolean result = true;
        if (rotater != null) {
            result = rotater.isMoved();
            if (result == true) {
                rotater.expose = !rotater.expose;
                rotater = null;
            }
        }
        return result;
    }

    public BaseCircleItem getExposed() {
        for (BaseCircleItem c : items) if (c.expose) return c;
        return null;
    }

}
