package social.biitworx.pickz;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcel.weissgerber on 04.11.2015.
 */
public class ComposedDrawView extends View {

    private List<ComposeView> views = new ArrayList<>();
    public ComposedDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void registerView(ComposeView view ){
        views.add(view);
    }


    @Override
    protected void onDraw(Canvas canvas){

        for(ComposeView v : views){
            v.onDraw(canvas);
        }
    }
}
