package social.biitworx.pickz;

import android.graphics.Point;
import android.view.Menu;

/**
 * Created by marcel.weissgerber on 09.11.2015.
 */
public class DragMenuItem {
    public MenuCircleItem item;
    public Point position;
    public DragMenuItem(MenuCircleItem item,Point position){
        this.item = item;
        this.position = position;
    }
}
