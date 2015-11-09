package social.biitworx.pickz;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public abstract class ComposeView {

    protected Rect display = null;
    public void onDraw(Canvas canvas){
        if(canvas!=null)
        {
            display = new Rect(0,0,canvas.getWidth(),canvas.getHeight());
            onDrawChild(canvas);
        }
    }
    public abstract void onDrawChild(Canvas canvas);

    public abstract void checkTouchDown(Point p);

    public abstract void checkMoveDown(Point p);

    public abstract void releaseDrag();
}
