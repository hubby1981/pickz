package social.biitworx.pickz;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class BackgroundView extends ComposeView {

    @Override
    public void onDrawChild(Canvas canvas) {


            canvas.drawRect(display,DrawHelper.getNormalBack());


    }
}
