package social.biitworx.pickz;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class BackgroundView extends ComposeView {

    @Override
    public void onDrawChild(Canvas canvas) {


            canvas.drawRect(display,DrawHelper.getNormalBack());


    }

    @Override
    public void checkTouchDown(Point p) {

    }

    @Override
    public void checkMoveDown(Point p) {

    }

    @Override
    public void releaseDrag() {

    }
}
