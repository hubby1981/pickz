package social.biitworx.pickz;

import android.graphics.Bitmap;

/**
 * Created by marcel.weissgerber on 06.11.2015.
 */
public abstract class BaseCircleItem {

    public int backcolor =android.graphics.Color.argb(255,100,100,100);
    public int degree = 0;
    public Bitmap icon=null;
    public boolean expose=false;
    private int mover=10;

    public BaseCircleItem(Bitmap icon){
        this.icon = icon;
    }

    public void move(){
        degree +=mover;
        if(degree >= 360)degree=0;
    }

    public void moveL(){
        if(degree <= 0)degree=360;
        degree -=mover;
    }



    public boolean mustMoveL(){
        return degree<180 && degree>0;
    }

    public boolean isMoved(){
        return degree==0;
    }

    public BaseCircleItem color (int color){
        this.backcolor=color;
        return this;
    }


    public <T> T get(){
        return (T)this;
    }



}
